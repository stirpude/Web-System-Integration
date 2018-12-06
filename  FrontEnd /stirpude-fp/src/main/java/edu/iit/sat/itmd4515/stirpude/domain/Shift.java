/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author shruti
 */
@Entity
@Table(name = "Shifts")
public class Shift {

    @Id
    private Long id;

    @ManyToMany
    @JoinTable(name = "Owner_shift",
            joinColumns = @JoinColumn(name = "shifts_ID"),
            inverseJoinColumns = @JoinColumn(name = "owners_ID"))
    private List<Owner> owners = new ArrayList<>();

    private String shiftName;

    public Shift(String shiftName) {
        this.shiftName = shiftName;
    }

    /*
     *Helper methods to help manage both sides of the bi-directional relationship
     */
    public void addOwner(Owner ow) {
        if (!this.owners.contains(ow)) {
            this.owners.add(ow);
        }
        if (!ow.getShifts().contains(this)) {
            ow.getShifts().add(this);
        }
    }

    public Shift() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

}
