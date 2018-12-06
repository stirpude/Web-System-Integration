/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.service;

import edu.iit.sat.itmd4515.stirpude.domain.StoreInventory;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author shruti
 */

@Stateless
public class StoreInventoryService extends AbstractService<StoreInventory>{
    
    public StoreInventoryService() {
        super(StoreInventory.class);
    }
    
    @Override
    public List<StoreInventory> findAll() {
        return getEntityManager().createNamedQuery("StoreInventory.findAll", StoreInventory.class).getResultList();
    }
    
    
    
    
}
