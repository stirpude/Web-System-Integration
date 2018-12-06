/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.service;

import edu.iit.sat.itmd4515.stirpude.domain.Manager;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shruti
 */

@Stateless
public class ManagerService extends AbstractService<Manager> {

    public ManagerService() {
        super(Manager.class);
    }
    
    

  
    @Override
    public List<Manager> findAll() {
        return getEntityManager().createNamedQuery("Manager.findAll", Manager.class).getResultList();
    }
    
    
    public Manager findByUserName(String username) {
        return getEntityManager().createNamedQuery("Manager.findByUsername", Manager.class).setParameter("username", username).getSingleResult();
    }
    
    
    
    
}
