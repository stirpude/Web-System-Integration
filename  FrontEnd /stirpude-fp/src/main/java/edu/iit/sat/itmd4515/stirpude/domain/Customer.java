/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.domain;

import edu.iit.sat.itmd4515.stirpude.domain.security.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author shruti
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    
    /*@OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;*/



    public Customer() {
    }

    @OneToMany
    private List<OrderInformation> orderInformation = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderInformation> getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(List<OrderInformation> orderInformation) {
        this.orderInformation = orderInformation;
    }
    /*public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }*/

}
