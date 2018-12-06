package com.iit.edu.service;

import java.util.List;

import com.iit.edu.model.WorkoutActive;

/**
 *
 * @author shruti
 * interface WorkoutActiveService defined to check 
 */
public interface WorkoutActiveService {
	
    /**
     *
     * @param work
     * @return
     */
    public WorkoutActive startWorkout(WorkoutActive work);
	
    /**
     *
     * @param work
     * @return
     */
    public WorkoutActive endWorkout(WorkoutActive work);
	
    /**
     *
     * @return
     * method to list all active workouts 
     */
    public List<WorkoutActive> getAllWorkoutActive();
	
    /**
     *
     * @param workoutId
     * method deleteWorkoutActive to delete active workouts 
     * 
     */
    public void deleteWorkoutActive(Long workoutId);
	

}
