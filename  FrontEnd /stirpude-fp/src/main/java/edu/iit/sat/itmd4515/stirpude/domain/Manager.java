/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.domain;

import edu.iit.sat.itmd4515.stirpude.domain.security.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author shruti
 */

@Entity
@NamedQueries({
    @NamedQuery(
            name = "Manager.findByName",
            query = "select m from Manager m where m.name = :name")
    ,
    @NamedQuery(
            name = "Manager.findAll",
            query = "select m from Manager m"),
    @NamedQuery(
            name = "Manager.findByUsername",
            query = "select m from Manager m where m.user.userName = :username")    
})
public class Manager {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    private String name;

    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public Manager() {
    }

    public Manager(String name, User user) {
        this.name = name;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Category{" + "name=" + name + ", user=" + user + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    
}
