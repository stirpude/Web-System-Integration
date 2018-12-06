/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.domain;

import static edu.iit.sat.itmd4515.stirpude.domain.AbstractJPATest.e;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author shruti
 */
public class OrderInformationTest extends AbstractJPATest {

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
     * Test for validating if quantity is less than 1
    */

    @Test
    public void quantityCountTooLow() {

        OrderInformation order = new OrderInformation(new GregorianCalendar(1999, 4, 4).getTime(), 0);

        System.out.println(order.toString());

        Set<ConstraintViolation<OrderInformation>> constraintViolations = validator.validate(order);

        assertEquals(1, constraintViolations.size());

        for (ConstraintViolation<OrderInformation> bad : constraintViolations) {
            System.out.println(bad.toString() + " " + bad.getPropertyPath() + " " + bad.getMessage());

        }
        assertEquals(
                "must be greater than or equal to 1",
                constraintViolations.iterator().next().getMessage()
        );

    }

}
