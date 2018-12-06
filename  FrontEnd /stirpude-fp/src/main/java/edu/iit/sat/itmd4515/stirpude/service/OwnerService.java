/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.service;

import edu.iit.sat.itmd4515.stirpude.domain.Manager;
import edu.iit.sat.itmd4515.stirpude.domain.Owner;
import edu.iit.sat.itmd4515.stirpude.domain.StoreInventory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shruti
 */
@Stateless
public class OwnerService {

    @PersistenceContext(unitName = "itmd4515PU")
    private EntityManager em;

    /**
     *
     */
    public OwnerService() {
    }

    //crud 

    /**
     *
     * @param ow
     */
    public void create(Owner ow) {

        //persist will manage the ow
        em.persist(ow);

    }

    /**
     *
     * @param id of Owner to find
     * @return the Owner or null if the Owner does not exist
     */
    public Owner find(long id) {

        return em.find(Owner.class, id);

    }

    /**
     *
     * @return
     */
    public List<Owner> findAll() {

        return em.createNamedQuery("Owner.findAll", Owner.class).getResultList();

    }
    
    public Owner findByUserName(String username) {
        return em.createNamedQuery("Owner.findByUsername", Owner.class).setParameter("username", username).getSingleResult();
    }

    /**
     *
     * @param ow
     */
    public void update(Owner ow) {

        //merge will manage the ow
        em.merge(ow);

    }

    /**
     *
     * @param ow
     */
    public void remove(Owner ow) {

        em.remove(em.merge(ow));

    }

}
