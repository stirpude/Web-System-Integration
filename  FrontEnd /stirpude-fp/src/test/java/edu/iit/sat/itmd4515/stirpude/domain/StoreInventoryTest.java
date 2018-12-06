/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.domain;

import java.text.ParseException;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import java.util.List;
import javax.persistence.RollbackException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author shruti
 */
public class StoreInventoryTest extends AbstractJPATest {

    @Before
    public void beforeEachTest() {
        em = e.createEntityManager();
        tx = em.getTransaction();

        StoreInventory seed = new StoreInventory(
                "SEED",
                "furniture",
                1,
                new GregorianCalendar(1980, 11, 11).getTime());
        tx.begin();
        em.persist(seed);
        tx.commit();

    }

    @After
    public void afterEachTest() {

        StoreInventory seed = em
                .createNamedQuery("StoreInventory.findByName", StoreInventory.class)
                .setParameter("name", "SEED")
                .getSingleResult();

        tx.begin();
        em.remove(seed);
        tx.commit();

        if (em != null) {

            em.close();
        }

    }

    @Test
    public void verifySeedDataTest() {
        List<StoreInventory> seeds = em
                .createNamedQuery("StoreInventory.findByName", StoreInventory.class)
                .setParameter("name", "SEED")
                .getResultList();

        assertEquals(seeds.size(), 1);
        assertEquals("SEED", seeds.get(0).getCustomerName());

    }

    /*
     *Sunny day test for persist
     * 
     */
    @Test
    public void persistNewStoreInventory() {

        StoreInventory si1 = new StoreInventory(
                "Brian",
                "furniture",
                1,
                new GregorianCalendar(1970, 11, 11).getTime());

        tx.begin();
        assertNull("id should  be null untill after em.persist", si1.getId());
        em.persist(si1);
        assertNull("id should  be null untill after em.persist and before tx.commit", si1.getId());
        tx.commit();
        assertNotNull("id should not  be null after em.persist and after tx.commit", si1.getId());
        assertTrue("id should always be  greater than 0", si1.getId() > 01);

    }

    /*
     *Rainy day test for persist
     * 
     */
    @Test(expected = RollbackException.class)
    public void persistNewStoreInventoryFailure() {

        StoreInventory si1 = new StoreInventory(
                "SEED",
                "furniture",
                1,
                new GregorianCalendar(1980, 11, 11).getTime());

        tx.begin();
        em.persist(si1);

        tx.commit();

    }

    /*
     *Sunny day test for update
     * 
     */
    @Test
    public void updateCustomerNameSuccess() {
        //update  functionality

        StoreInventory si2;
        tx.begin();
        si2 = em.find(StoreInventory.class, em.createNamedQuery("StoreInventory.findByName", StoreInventory.class)
                .setParameter("name", "Brian")
                .getSingleResult().getId());
        si2.setCustomerName("Shruti");
        tx.commit();
        System.out.println("Customer Id " + si2.getId() + " Customer Name" + si2.getCustomerName());
        assertEquals("Shruti", si2.getCustomerName());
    }

    /*
     *Rainy day test for update
     * 
     */
    public void updateCustomerFailure() {
        //update  functionality

        tx.begin();
        StoreInventory seed = em.find(StoreInventory.class, em.createNamedQuery("StoreInventory.findByName", StoreInventory.class)
                .setParameter("name", "SEED").getSingleResult().getId());

        seed.setCustomerName("SEED");

        tx.commit();

        assertEquals("SEED", seed.getCustomerName());
    }

    /*
     *Sunny day test for read
     * 
     */
    @Test
    public void readCustomerNameSuccess() {

        tx.begin();
        StoreInventory seed = em.find(StoreInventory.class, em.createNamedQuery("StoreInventory.findByName", StoreInventory.class)
                .setParameter("name", "SEED").getSingleResult().getId());
        em.persist(seed);
        em.find(StoreInventory.class, seed.getId());
        System.out.println("Customer Name kya be " + seed.getCustomerName());
        tx.commit();
        assertEquals("SEED", seed.getCustomerName());

    }

    /*
     *rainy day test for read
     * 
     */
    public void readCustomerNameFailure() {

        List<StoreInventory> seeds = em
                .createNamedQuery("StoreInventory.findByName", StoreInventory.class)
                .setParameter("name", "LISA")
                .getResultList();

        assertEquals(seeds.size(), 0);

    }

    /*
     *Sunny day test for delete
     * 
     */
    @Test
    public void deleteCustomerNameSuccess() {
        //delete functionality

        StoreInventory si5 = new StoreInventory(
                "James",
                "Books",
                3,
                new GregorianCalendar(1999, 11, 11).getTime());

        tx.begin();
        em.persist(si5);
        tx.commit();
        if (si5 != null) {
            tx.begin();
            em.remove(si5);
            tx.commit();
        }
        List<StoreInventory> seeds = em.createNamedQuery("StoreInventory.findByName", StoreInventory.class)
                .setParameter("name", "James")
                .getResultList();

        assertEquals(0, seeds.size());
        for (StoreInventory s : seeds) {
            assertNull(s);
        }

    }

    /*
     *Rainy day test for delete
     * 
     */
    public void deleteCustomerNameFailure() throws ParseException {
        //delete functionality

        StoreInventory si6 = new StoreInventory(
                "Antonio",
                "Food",
                3,
                new GregorianCalendar(1999, 11, 11).getTime());

        tx.begin();
        em.persist(si6);
        tx.commit();
        if (si6 != null) {
            tx.begin();
            em.remove(si6);
            tx.commit();
        }
        List<StoreInventory> seeds = em.createNamedQuery("StoreInventory.findByName", StoreInventory.class)
                .setParameter("name", "Antonio")
                .getResultList();

        assertTrue("Amtonio" != si6.getCustomerName());

    }

    @Test
    public void testAssertEquals() {
        assertEquals("failure - strings are not equal", "text", "text");
    }

    @Test
    public void testAssertFalse() {
        assertFalse("failure - should be false", false);
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull("should not be null", new Object());

    }

}
