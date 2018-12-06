package com.iit.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iit.edu.model.Category;
import com.iit.edu.service.CategoryService;

/**
 *
 * @author shruti
 * Class CategoryController controls the categories of workout application
 * Class CategoryController contains three methods to list,add and delete categories
 * The backend server is listening on port 8080 using CrossOrigin annotations
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
    /**
     *
     * @return
     * The getCategories method returns the list of all categories of workout
     */
    @RequestMapping(value = "/getCategories", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Category> getCategories() {
		List<Category> catList = categoryService.getAllCategories();
		if (!(catList!=null && catList.size() > 0 )) {
			return null;
		}
		return catList;
	}
	
    /**
     *
     * @param 
     * @return
     * The addCategory method adds and posts the categories to the database
     * Request Mapping annotation maps the url /addCategory 
     */
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public Category addCategory(@RequestBody Category cat) {
		
		Category cat1 =  categoryService.addCategory(cat);
		return cat1;
	}
	
    /**
     *
     * @param cat
     * The deleteCategory method is called when /deleteCategory url is hit
     * 
     */
    @RequestMapping(value = "/deleteCategory", method = RequestMethod.POST)
	public void deleteCategory(@RequestBody Category cat) {
		categoryService.deleteCategory(cat);
	}
}

