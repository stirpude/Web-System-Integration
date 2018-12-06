package com.iit.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iit.edu.dao.WorkoutActiveRepository;
import com.iit.edu.model.WorkoutActive;
import com.iit.edu.service.WorkoutActiveService;

/**
 *
 * @author shruti
 * class WorkoutActiveServiceImpl implements WorkoutActiveService class 
 * methods startWorkout,endWorkout,getAllWorkoutActive,deleteWorkoutActive are overriden
 */
@Service("workoutActiveService")
@Transactional 
public class WorkoutActiveServiceImpl implements WorkoutActiveService {

	@Autowired
	private WorkoutActiveRepository workoutActiveRepository;
	
	@Override
	public WorkoutActive startWorkout(WorkoutActive work) {
		work.setStatus(true);
		work.toString();
		return workoutActiveRepository.save(work);
		
	}

	@Override
	public WorkoutActive endWorkout(WorkoutActive work) {
		work.setStatus(false);
		return workoutActiveRepository.save(work);
	}

	@Override
	public List<WorkoutActive> getAllWorkoutActive() {
		return workoutActiveRepository.findAll();
	}

	@Override
	public void deleteWorkoutActive(Long workoutId) {
		List<WorkoutActive> woList = workoutActiveRepository.findRecordsByWorkoutId(workoutId);
		for(WorkoutActive woa: woList) {
			System.out.println(woa.toString());
		}
		workoutActiveRepository.deleteAll(woList);
		
	}

}
