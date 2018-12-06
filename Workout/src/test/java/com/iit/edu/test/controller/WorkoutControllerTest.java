package com.iit.edu.test.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
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
import com.iit.edu.controller.WorkoutController;
import com.iit.edu.model.Category;
import com.iit.edu.model.Workout;
import com.iit.edu.model.WorkoutActive;
import com.iit.edu.service.WorkoutActiveService;
import com.iit.edu.service.WorkoutService;

/**
 *
 * @author shruti
 * class WorkoutControllerTest defined to test workout
 */
@RunWith(SpringRunner.class)
@WebMvcTest(WorkoutController.class)
public class WorkoutControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private WorkoutService workoutservice;
	
	@MockBean
	private WorkoutActiveService workoutActiveService;
	
	@Autowired
	private ObjectMapper mapper;
	
	Workout wo;

    /**
     *method setUp to seed data that runs before test cases 
     */
    @Before
	public void setUp() {
		wo = new Workout();
		wo.setWorkoutTitle("Yoga");
		wo.setCaloriesBurnPerMin(50L);
		wo.setWorkoutNote("Yoga is good for health");
		
		
		List<Workout> woList = Arrays.asList(wo);
		Mockito.when(workoutservice.getAllWorkouts()).thenReturn(woList);
	}
	
    /**
     *
     * @throws Exception
     * test case to check status of workouts
     * 
     */
    @Test
	public void testGetAllWorkouts() throws Exception {
		mvc.perform(get("/workout/getAllWorkouts").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$[0].workoutTitle", is(wo.getWorkoutTitle())));
	}
	
    /**
     *
     * @throws Exception
     * test case to add workout successfully
     */
    @Test
	public void testAddWorkout() throws Exception {
		Workout wo = new Workout();
		wo.setWorkoutTitle("Yoga");
		wo.setCaloriesBurnPerMin(50L);
		wo.setWorkoutNote("Yoga is good for health");
		wo.setWorkoutId(100L);
		wo.setCategory(new Category());
		
		Mockito.when(workoutservice.addWorkout(wo)).thenReturn(wo);
		
		mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(wo);
		System.out.println("Json :"+json);
		mvc.perform(post("/workout/addWorkout").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.workoutTitle", is(wo.getWorkoutTitle())));
	}
	
    /**
     *
     * @throws Exception
     * unit test case to check the start workout 
     */
    @Test
	public void testStartWorkout() throws Exception {
		WorkoutActive wo = new WorkoutActive();
		wo.setStartDate(LocalDate.now());
		wo.setStartTime(LocalTime.now());
		wo.setStatus(true);
		
		Mockito.when(workoutActiveService.startWorkout(wo)).thenReturn(wo);
		String json = mapper.writeValueAsString(wo);
		
		mvc.perform(post("/workout/startWorkout").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.startDate", is(wo.getStartDate().toString())));
	}

    /**
     *
     * @throws Exception
     * unit test to check end workout
     */
    @Test
	public void testEndWorkout() throws Exception {
		WorkoutActive wo = new WorkoutActive();
		wo.setEndDate(LocalDate.now());
		wo.setEndTime(LocalTime.now());
		wo.setStatus(false);
		Mockito.when(workoutActiveService.endWorkout(wo)).thenReturn(wo);
		String json = mapper.writeValueAsString(wo);
		
		mvc.perform(post("/workout/endWorkout").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.endDate", is(wo.getEndDate().toString())));
	}
}
