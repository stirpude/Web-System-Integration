package com.iit.edu.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iit.edu.model.WorkoutActive;
import com.iit.edu.model.WorkoutActivePK;

/**
 *
 * @author shruti
 * WorkoutActiveRepository is an interface that extends to JpaRepository
 */
@Repository
public interface WorkoutActiveRepository extends JpaRepository<WorkoutActive, WorkoutActivePK>{

    /**
     *
     * @param id
     * @return
     * The method findRecordsByWorkoutId lists workout id
     */
    @Query(value="SELECT * FROM workout_active w where w.workout_id = :id",nativeQuery=true) 
    List<WorkoutActive> findRecordsByWorkoutId(@Param("id") Long id);
}
