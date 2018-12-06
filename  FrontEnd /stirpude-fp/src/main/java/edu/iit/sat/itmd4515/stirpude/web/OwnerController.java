/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.web;

import edu.iit.sat.itmd4515.stirpude.domain.Owner;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author shruti
 */

@Named
@RequestScoped
public class OwnerController {
    private static final Logger LOG = Logger.getLogger(OwnerController.class.getName());
    
        private Owner owner;
        
        @PostConstruct
        private void postConstruct(){
            owner = new Owner();
            LOG.info("I am in OwnerController in  postConstruct");
            
        }

    /**
     * Get the value of owner
     *
     * @return the value of owner
     */
    public Owner getOwner() {
        return owner;
    }
    
    //methods 
    
    public String executeSaveOwner(){
        LOG.info("I am in executeSaveOwner method of class OwnerController ");
        return "/admin/welcome.xhtml"; 
    }

    /**
     * Set the value of owner
     *
     * @param owner new value of owner
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    
}
