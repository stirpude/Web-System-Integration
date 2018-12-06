/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.domain;

import edu.iit.sat.itmd4515.stirpude.domain.security.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

/**
 *
 * @author shruti
 */
@Entity
@NamedQueries({
@NamedQuery(
        name = "Owner.findByName",
        query = "select ow from Owner ow where ow.name = :name"),
@NamedQuery(
        name ="Owner.findAll",
        query = "select ow from Owner ow"
                           ),
@NamedQuery(
            name = "Owner.findByUsername",
            query = "select ow from Owner ow where ow.user.userName = :username")
})
public class Owner {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    


    @ManyToOne
    @JoinColumn(name = "SI_ID")
    private StoreInventory storeInventory;

    @NotNull
    private String name;
    
    @PastOrPresent(message = "The dateJoined has to be past or present")
    @Temporal(TemporalType.DATE)
    private Date dateJoined;

    @ManyToMany(mappedBy = "owners")
    private List<Shift> shifts = new ArrayList<>();
    
    
    @Email
    private String email;
    
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public Owner(String name, Date dateJoined, String email) {
        this.name = name;
        this.dateJoined = dateJoined;
        this.email = email;
    }


    

    /*
     *Helper methods to help manage both sides of the bi-directional relationship
     */
    public void addShift(Shift s) {
        if (!this.shifts.contains(s)) {
            this.shifts.add(s);

        }

        if (!s.getOwners().contains(this)) {
            s.getOwners().add(this);

        }

    }

    public Owner() {
    }

    public Owner(String name, Date dateJoined) {
        this.name = name;
        this.dateJoined = dateJoined;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreInventory getStoreInventory() {
        return storeInventory;
    }

    public void setStoreInventory(StoreInventory storeInventory) {
        this.storeInventory = storeInventory;
        if (!this.storeInventory.getOwner().contains(this)) {
            this.storeInventory.getOwner().add(this);

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Owner{" + "id=" + id + ", name=" + name + ", dateJoined=" + dateJoined + ", email=" + email + '}';
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
