package com.iit.edu.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author shruti
 * Class WorkoutActivePK interface implements class Serializable
 */
public class WorkoutActivePK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private LocalDate startDate;
	private LocalTime startTime;
	
    /**
     *
     * @return
     * getter method for startTime
     */
    public LocalTime getStartTime() {
		return startTime;
	}

    /**
     *
     * @param startTime
     * setter method for startTime
     */
    public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

    /**
     *
     * @return
     * getter method for startDate
     */
    public LocalDate getStartDate() {
		return startDate;
	}

    /**
     *
     * @param startDate
     */
    public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public int hashCode() {
        return (int) startDate.hashCode() + startTime.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof WorkoutActivePK)) return false;
        if (obj == null) return false;
        WorkoutActivePK pk = (WorkoutActivePK) obj;
        return pk.startTime == startTime && pk.startDate == startDate;
    }

}
