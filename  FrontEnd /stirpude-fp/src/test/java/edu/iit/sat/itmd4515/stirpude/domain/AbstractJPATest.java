/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author shruti
 */
public abstract class AbstractJPATest {
    protected static EntityManagerFactory e;
    protected static Validator validator;
    protected EntityManager em;
    protected EntityTransaction tx;
    
    @BeforeClass
    public static void beforeClassTestFixture() {
        e = Persistence.createEntityManagerFactory("itmd4515PU_TEST");
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
        
    }

    @AfterClass
    public static void afterClassTestFixture() {
        e.close();

    }
    
    
   
    
}
