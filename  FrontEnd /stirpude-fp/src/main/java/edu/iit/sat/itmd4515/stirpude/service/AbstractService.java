/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.service;

import edu.iit.sat.itmd4515.stirpude.domain.Owner;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shruti
 */
public abstract class AbstractService<T> {
    
    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager em;
    
    private final Class<T> entityClass;
    
    public AbstractService(Class entityClass) {
        this.entityClass = entityClass;
    }
    
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void create(T entity) {

        //persist will manage the ow
        em.persist(entity);
        
    }
    
    public T find(Object id) {
        
        return em.find(entityClass, id);
        
    }
    
   // public List<T> findAll(String namedQuery){
      //   return em.createNamedQuery(namedQuery,entityClass ).getResultList();
        
   // }
    
    public abstract List<T> findAll();
    
    public void update(T entity) {
        em.merge(entity);
        
    }
    
    public void remove(T entity) {
        em.remove(em.merge(entity));
        
    }
}
