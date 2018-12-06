package com.iit.edu.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author shruti
 * Class Workout is the pojo class that has workout attributes
 * This class connects the entities to the database
 * This class is used to create table workout_collection in the database
 */
@Entity
@Table(name="workout_collection")
public class Workout {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="workout_id")
	private Long workoutId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="category_id")
	private Category category;
	
	@Column(name="workout_title", length=128)
	private String workoutTitle;
	
	@Column(name="workout_note", length=256)
	private String workoutNote;
	
	@Column(name="calories_burn_per_min")
	private Float caloriesBurnPerMin;
	
    /**
     *
     * @return
     * getter method for workout id
     */
    public Long getWorkoutId() {
		return workoutId;
	}

    /**
     *
     * @param workoutId
     * setter method for workout id
     */
    public void setWorkoutId(Long workoutId) {
		this.workoutId = workoutId;
	}
	
    /**
     *
     * @return
     * This getCategory method returns the category
     */
    public Category getCategory() {
		return category;
	}

    /**
     *
     * @param category
     * The setter method for category
     */
    public void setCategory(Category category) {
		this.category = category;
	}

    /**
     *
     * @return
     * The getWorkoutTitle method returns the workout title
     */
    public String getWorkoutTitle() {
		return workoutTitle;
	}

    /**
     *
     * @param workoutTitle
     * Setter method for workoutTitle
     */
    public void setWorkoutTitle(String workoutTitle) {
		this.workoutTitle = workoutTitle;
	}

    /**
     *
     * @return
     * Getter method for getWorkoutNote
     */
    public String getWorkoutNote() {
		return workoutNote;
	}

    /**
     *
     * @param workoutNote
     * Setter method for workoutNote
     */
    public void setWorkoutNote(String workoutNote) {
		this.workoutNote = workoutNote;
	}

    /**
     *
     * @return
     * Getter method for getCaloriesBurnPerMin
     */
    public float getCaloriesBurnPerMin() {
		return caloriesBurnPerMin;
	}

    /**
     *
     * @param caloriesBurnPerMin
     * Setter method for caloriesBurnPerMin
     */
    public void setCaloriesBurnPerMin(float caloriesBurnPerMin) {
		this.caloriesBurnPerMin = caloriesBurnPerMin;
	}
	
	@Override
	public String toString() {
		return "Workout [workoutId=" + workoutId + ", category=" + category.toString()+ ", workoutTitle=" + workoutTitle
				+ ", workoutNote=" + workoutNote + ", caloriesBurnPerMin=" + caloriesBurnPerMin + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caloriesBurnPerMin == null) ? 0 : caloriesBurnPerMin.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((workoutId == null) ? 0 : workoutId.hashCode());
		result = prime * result + ((workoutNote == null) ? 0 : workoutNote.hashCode());
		result = prime * result + ((workoutTitle == null) ? 0 : workoutTitle.hashCode());
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
		Workout other = (Workout) obj;
		if (caloriesBurnPerMin == null) {
			if (other.caloriesBurnPerMin != null)
				return false;
		} else if (!caloriesBurnPerMin.equals(other.caloriesBurnPerMin))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (workoutId == null) {
			if (other.workoutId != null)
				return false;
		} else if (!workoutId.equals(other.workoutId))
			return false;
		if (workoutNote == null) {
			if (other.workoutNote != null)
				return false;
		} else if (!workoutNote.equals(other.workoutNote))
			return false;
		if (workoutTitle == null) {
			if (other.workoutTitle != null)
				return false;
		} else if (!workoutTitle.equals(other.workoutTitle))
			return false;
		return true;
	}
	

}
