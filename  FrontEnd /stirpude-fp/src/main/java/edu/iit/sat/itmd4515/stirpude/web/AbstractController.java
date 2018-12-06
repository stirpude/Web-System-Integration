/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.web;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author shruti
 * The AbstractController class is based on Instructor Example
 */
public abstract class AbstractController {
    
    
    protected FacesContext context;

   
    protected AbstractController() {
    }

   
    @PostConstruct
    public void postConstruct() {
        context = FacesContext.getCurrentInstance();
    }
    
}
