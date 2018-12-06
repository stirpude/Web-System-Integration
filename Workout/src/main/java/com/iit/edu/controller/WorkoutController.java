package com.iit.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iit.edu.model.Workout;
import com.iit.edu.model.WorkoutActive;
import com.iit.edu.service.WorkoutActiveService;
import com.iit.edu.service.WorkoutService;

/**
 *
 * @author shruti
 * Class WorkoutController controls the workout view
 * The class WorkoutController has three methods has seven methods to get all workouts,add workouts,delete workouts,start workouts and end workouts
 * 
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/workout")
public class WorkoutController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private WorkoutActiveService workoutActiveService;
	
    /**
     *
     * @return
     * The method getAllWorkouts displays all the workouts in application
     * The method uses get request method to display the list
     */
    @RequestMapping(value = "/getAllWorkouts", method = RequestMethod.GET)
	public List<Workout> getAllWorkouts() {
		List<Workout> workouts = workoutService.getAllWorkouts();
		return workouts;
	}
	
    /**
     *
     * @param work
     * @return
     * The addWorkout method adds the workout to the database
     */
    @RequestMapping(value = "/addWorkout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Workout addWorkout(@RequestBody Workout work) {
		Workout wo = workoutService.addWorkout(work);
		return wo;
	}
	
    /**
     *
     * @param id
     * @return
     * The findWorkout method prints the workout id 
     */
    @RequestMapping(value ="/getWorkoutById/{workoutId}", method = RequestMethod.GET) 
	public Workout findWorkout(@PathVariable("workoutId") int id) {
		System.out.println("ID : "+id+workoutService.findWorkoutById(id).isPresent());
		if(workoutService.findWorkoutById(id).isPresent()) {
			return workoutService.findWorkoutById(id).get();
		}
		return null;
	}
	
    /**
     *
     * @param work
     * The deleteWorkout method deletes the workout from the database
     */
    @RequestMapping(value = "/deleteWorkout", method = RequestMethod.POST)
	public void deleteWorkout(@RequestBody Workout work) {
		workoutActiveService.deleteWorkoutActive(work.getWorkoutId());
		workoutService.deleteWorkout(work);
	}
	
    /**
     *
     * @param work
     * @return
     * The startWorkout method is used to start the workout and count the time
     */
    @RequestMapping(value = "/startWorkout", method = RequestMethod.POST)
	public WorkoutActive startWorkout(@RequestBody WorkoutActive work) {
		return workoutActiveService.startWorkout(work);
		
	}
	
    /**
     *
     * @param work
     * @return
     * The endWorkout method is called when user wants to end the workout
     * 
     */
    @RequestMapping(value = "/endWorkout", method = RequestMethod.POST)
	public WorkoutActive endWorkout(@RequestBody WorkoutActive work) {
		return workoutActiveService.endWorkout(work);
		
	}
	
    /**
     *
     * @return
     * The getAllWorkoutActive is used to display all active workouts
     */
    @RequestMapping(value = "/getAllWorkoutActive", method = RequestMethod.GET)
	public List<WorkoutActive> getAllWorkoutActive() {
		List<WorkoutActive> listOfActiveWorkouts = workoutActiveService.getAllWorkoutActive();
		if(listOfActiveWorkouts != null && !listOfActiveWorkouts.isEmpty()) {
			return listOfActiveWorkouts;
		}
		return null;
	}
}
