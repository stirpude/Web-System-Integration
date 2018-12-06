package com.iit.edu.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author shruti
 * Class WorkoutActive serves for checking the active workouts
 * Database table workout_active is created using this pojo class
 * 
 */
@Entity
@Table(name="workout_active")
@IdClass(WorkoutActivePK.class)
public class WorkoutActive {
	
	@OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "workout_id")
	private Workout workout;
	
	@Id
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Id
	@Column(name="start_time")
	private LocalTime startTime;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name="end_time")
	private LocalTime endTime;
	
	@Column(name="comment", length=64)
	private String comment;
	
	@Column(name="status")
	private boolean status;
	
    /**
     *
     * @return
     * Getter method for workouts
     */
    public Workout getWorkout() {
		return workout;
	}

    /**
     *
     * @param workout
     * Setter method for workout id
     */
    public void setWorkoutId(Workout workout) {
		this.workout = workout;
	}

    /**
     *
     * @return
     * Getter method for startDate
     */
    public LocalDate getStartDate() {
		return startDate;
	}

    /**
     *
     * @param startDate
     * Setter method for startDate
     */
    public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

    /**
     *
     * @return
     * getter method for getStartTime
     */
    public LocalTime getStartTime() {
		return startTime;
	}

    /**
     *
     * @param startTime
     * Setter method for startTime
     */
    public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

    /**
     *
     * @return
     * Method getEndDate returns end date
     */
    public LocalDate getEndDate() {
		return endDate;
	}

    /**
     *
     * @param endDate
     * Setter of endDate
     */
    public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

    /**
     *
     * @return
     * Method getEndTime returns endTime
     */
    public LocalTime getEndTime() {
		return endTime;
	}

    /**
     *
     * @param endTime
     * setEndTime method sets endTime
     */
    public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

    /**
     *
     * @return
     * Getter method for comment
     */
    public String getComment() {
		return comment;
	}

    /**
     *
     * @param comment
     * Setter method for comment
     */
    public void setComment(String comment) {
		this.comment = comment;
	}

    /**
     *
     * @return
     * Method for checking status
     */
    public boolean isStatus() {
		return status;
	}

    /**
     *
     * @param status
     * Setter for status
     */
    public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "WorkoutActive [workoutId=" + workout.toString() + ", startDate=" + startDate + ", startTime=" + startTime
				+ ", endDate=" + endDate + ", endTime=" + endTime + ", comment=" + comment + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((workout == null) ? 0 : workout.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkoutActive other = (WorkoutActive) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (status != other.status)
			return false;
		if (workout == null) {
			if (other.workout != null)
				return false;
		} else if (!workout.equals(other.workout))
			return false;
		return true;
	}

}
