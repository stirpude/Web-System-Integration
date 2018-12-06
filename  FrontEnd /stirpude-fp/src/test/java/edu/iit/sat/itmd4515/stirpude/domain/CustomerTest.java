/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.domain;

import static edu.iit.sat.itmd4515.stirpude.domain.AbstractJPATest.e;
import java.util.GregorianCalendar;
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
public class CustomerTest extends AbstractJPATest {

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

    @Test
    public void persistCustomerTest() {

        Customer cu = new Customer("Shruti");

        tx.begin();
        em.persist(cu);

        tx.commit();

    }
}
