/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.domain;

import static edu.iit.sat.itmd4515.stirpude.domain.AbstractJPATest.e;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author shruti
 */
public class OwnerTest extends AbstractJPATest {

    @Before
    public void beforeEachTest() {
        em = e.createEntityManager();
        tx = em.getTransaction();

    }

    @After
    public void afterEachTest() {

        if (em != null) {

            em.close();
        }

    }
    
    /*
     *joinDate test constraint for for join date should be past or present
    */

    @Test()
    public void joinDate() {
        Owner ow = new Owner("Receptionist",
                new GregorianCalendar(2018, 4, 4).getTime());

        Set<ConstraintViolation<Owner>> violations = validator.validate(ow);
        assertTrue(violations.size() == 0);
    }

    @Test
    public void nameIsNull() {

        Owner ow = new Owner(null,
                new GregorianCalendar(1999, 4, 4).getTime());

        System.out.println(ow.toString());
        Set<ConstraintViolation<Owner>> constraintViolations = validator.validate(ow);
        assertEquals(1, constraintViolations.size());
        //em.persist(ow);
        //assertNotNull(ow.getName());
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());

        for (ConstraintViolation<Owner> bad : constraintViolations) {
            System.out.println(bad.toString() + " " + bad.getPropertyPath() + " " + bad.getMessage());

        }

    }

    @Test
    public void ownerEmailIsValid() {
        Owner ow = new Owner("Owner validated",
                new GregorianCalendar(1999, 4, 4).getTime());
        ow.setEmail("owner@hawk.iit.edu");
        System.out.println(ow.toString());
        Set<ConstraintViolation<Owner>> constraintViolations = validator.validate(ow);
        assertEquals(0, constraintViolations.size());

    }

    @Test
    public void persistStoreOwnerTest() {

        Owner ow = new Owner("Store Manager", new GregorianCalendar(1999, 4, 4).getTime());

        StoreInventory si = new StoreInventory("LakeView", "headphones", 1, new GregorianCalendar(1999, 5, 4).getTime());

        /*Shifts shift1 = new Shifts("Morning");
        shift1.addOwner(ow);
        Shifts shift2 = new Shifts("Evening");
        shift2.addOwner(ow);*/
        //si.getOwner().add(ow);
        //ow.setStoreInventory(si);
        ow.setStoreInventory(si);

        tx.begin();
        em.persist(si);
        //em.persist(shift1);
        //em.persist(shift2);
        em.persist(ow);
        tx.commit();

        //what we see in persistence context
        //this is from the inverse side
        StoreInventory findMe = em.find(StoreInventory.class, 1l);
        System.out.println("From the inverse side....Store Inventory name is : \t" + findMe.getCustomerName());
        System.out.println("From the inverse side....Owner  name is : \t" + findMe.getOwner().get(0).getName());

        //this is from the owning side 
        Owner findOwner = em.find(Owner.class, 1l);

        System.out.println("From the owning side...Owner name is : \t" + findOwner.getName());
        System.out.println("From the owning side...Store Inventory name is   : \t" + findOwner.getStoreInventory().getCustomerName());

        //test the inverse collection side
        assertTrue(si.getOwner().size() == 1);

        //test the owning side of the relationship
        assertNotNull(findOwner.getStoreInventory().getCustomerName());
        assertEquals("LakeView", findOwner.getStoreInventory().getCustomerName());

    }

}
