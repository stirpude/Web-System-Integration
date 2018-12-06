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
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author shruti
 */
public class ProductTest extends AbstractJPATest {

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
    public void productNameIsNull() {

        Product product = new Product(null, "Food Category");

        System.out.println(product.toString());

        Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);
        assertEquals(1, constraintViolations.size());
        assertEquals("must not be null", constraintViolations.iterator().next().getMessage());

        for (ConstraintViolation<Product> bad : constraintViolations) {
            System.out.println(bad.toString() + " " + bad.getPropertyPath() + " " + bad.getMessage());

        }

    }

}
