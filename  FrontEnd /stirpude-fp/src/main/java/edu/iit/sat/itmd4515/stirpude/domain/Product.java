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
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author shruti
 */
@Entity
public class Product {

    @Id
    private Long id;

    @ManyToMany
    private List<Customer> customers = new ArrayList<>();

    @NotNull
    private String productName;
    
    
    @Size(max = 2000)
    private String description;



    public Product() {
    }

    public Product(String productName, String description) {
        this.productName = productName;
        this.description = description;
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

   
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", description=" + description + '}';
    }

}
