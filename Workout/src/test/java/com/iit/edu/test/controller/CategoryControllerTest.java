package com.iit.edu.test.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iit.edu.controller.CategoryController;
import com.iit.edu.model.Category;
import com.iit.edu.service.CategoryService;

/**
 *
 * @author shruti
 * class CategoryControllerTest defined to test category
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired 
	private ObjectMapper mapper;
	
	@MockBean
	private CategoryService categoryService; 
	
    /**
     *
     * @throws Exception
     * testGetCategories test defined to check the status of getCategory method
     */
    @Test
	public void testGetCategories() throws Exception {
		
		Category cat = new Category();
		cat.setCategoryName("test");
		
		List<Category> catList = Arrays.asList(cat);
		
		Mockito.when(categoryService.getAllCategories()).thenReturn(catList);
		
		mvc.perform(get("/category/getCategories").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].categoryName", is(cat.getCategoryName())));
	}
	
    /**
     *
     * @throws Exception
     * test method testAddCategory to check add category 
     */
    @Test
	public void testAddCategory() throws Exception {
		
		Category cat = new Category();
		cat.setCategoryName("test");
		cat.setCategoryId(100L);
		
		Mockito.when(categoryService.addCategory(cat)).thenReturn(cat);
		String json = mapper.writeValueAsString(cat);
		mvc.perform(post("/category/addCategory").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.categoryName", is(cat.getCategoryName())));
	}

}
