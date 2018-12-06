/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.stirpude.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author shruti
 */
@Entity
@Table(name = "storeinventory")
@NamedQueries({
@NamedQuery(
        name = "StoreInventory.findByName",
        query = "select r from StoreInventory r where r.customerName= :name"),
@NamedQuery(
        name ="StoreInventory.findAll",
        query = "select r from StoreInventory r"
                           )    
})
public class StoreInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customerName", unique = true)
    private String customerName;

    @Column(name = "productName", unique = false)
    private String productName;

    @Column(name = "qauntity", unique = false)
    private int qauntity;

    @Transient
    private int notAddedToTable;

    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchase_date;
    private String string;

    @OneToMany(mappedBy = "storeInventory")
    private List<Owner> owners = new ArrayList<>();

    public StoreInventory() {

    }

    public StoreInventory(String customerName, String productName, int qauntity, Date purchase_date) {
        this.customerName = customerName;
        this.productName = productName;
        this.qauntity = qauntity;
        this.purchase_date = purchase_date;
    }

    /**
     * Get the value of customerName
     *
     * @return the value of customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Set the value of customerName
     *
     * @param customerName new value of customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "StoreInventory{" + "id=" + id + ", customerName=" + customerName + ", productName=" + productName + ", qauntity=" + qauntity + ", purchase_date=" + purchase_date + '}';
    }

    public List<Owner> getOwner() {
        return owners;
    }

    public void setOwner(List<Owner> owners) {
        this.owners = owners;
    }

}
