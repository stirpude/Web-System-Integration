package com.iit.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.iit.edu.model.Workout;

/**
 *
 * @author shruti
 * interface WorkoutService 
 */
@CacheConfig(cacheNames={"workout"})
public interface WorkoutService {
	
    /**
     *
     * @return
     * returns all cacheable workout
     */
    @Cacheable
	public List<Workout> getAllWorkouts();
	
    /**
     *
     * @param work
     * @return
     * 
     */
    public Workout addWorkout(Workout work);
	
    /**
     *
     * @param work
     */
    public void deleteWorkout(Workout work);

    /**
     *
     * @param id
     * @return
     */
    public Optional<Workout> findWorkoutById(long id);
}
