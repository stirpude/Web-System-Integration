package com.iit.edu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author shruti
 * The entity class Category is used to create table workout_category in the mysql database
 * The pojo class contains the attributes for the category of workout
 */
@Entity
@Table(name="workout_category")
public class Category {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="category_id")
	private Long categoryId;
	
	@Column(name="category_name", length=64)
	private String categoryName;
	
    /**
     *
     * @return
     * Method getCategoryId returns the category id
     */
    public Long getCategoryId() {
		return categoryId;
	}

    /**
     *
     * @param categoryId
     * Setter method to set the category id
     */
    public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
    /**
     *
     * @return
     * getCategoryName method returns the name of category
     */
    public String getCategoryName() {
		return categoryName;
	}

    /**
     *
     * @param categoryName
     * Setter method for category name
     * The method hashCode is used to hash the name and id of category
     * 
     */
    public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		return true;
	}
	
	

}

