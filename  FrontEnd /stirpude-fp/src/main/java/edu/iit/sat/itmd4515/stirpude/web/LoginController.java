/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author shruti
 * The LoginController class is based on Instructor Example
 */


@Named
@RequestScoped
public class LoginController extends AbstractController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());
   
    
    @NotBlank(message = "Please enter username")
    private String username;
    
    @NotBlank(message = "Please enter password")
    private String password;


    public LoginController() {
    }
    
    
    //action methods used from example in class lecture
    
    public String doLogin() {
        
        
        try {
            System.out.println("Inside login controller");
            HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
            req.login(username, password);
            System.out.println("Inside login controller");
            return "/welcome?faces-redirect=true";
            //return "/dist/index?faces-redirect=true";
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error in  Login", "Please check your username or password and try again."));
           
            return "/login";
        }
        
    }
    
    public String doLogout() {
    try {
            HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
            req.logout();

        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        return "/login?faces-redirect=true";
    
    }
    
    
    //helper methods for login 
    
    public String getRemoteUser() {
        return context.getExternalContext().getRemoteUser();
    }
    
    
    public boolean isManager() {
        return context.getExternalContext().isUserInRole("Manager_Role");
    }

    public boolean isOwner() {
        return context.getExternalContext().isUserInRole("Owner_Role");
    }

    /*public boolean isAdmin() {
        return context.getExternalContext().isUserInRole("ADMIN_ROLE");
    }*/



    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    
    
}
