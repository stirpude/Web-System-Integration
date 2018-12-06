package com.iit.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iit.edu.model.Workout;

/**
 *
 * @author shruti 
 * The interface WorkoutRepository extends JpaRepository
 * 
 */
@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
