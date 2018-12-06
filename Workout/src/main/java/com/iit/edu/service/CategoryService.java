package com.iit.edu.service;

import java.util.List;

import com.iit.edu.model.Category;

/**
 *
 * @author shruti
 */
public interface CategoryService {
	
    /**
     *
     * @return
     * List all categories 
     */
    public List<Category> getAllCategories();
	
    /**
     *
     * @param cat
     * @return
     * Add category
     */
    public Category addCategory(Category cat);
	
    /**
     *
     * @param cat
     * delete category
     */
    public void deleteCategory(Category cat);
	

}