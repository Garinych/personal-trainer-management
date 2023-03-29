package com.sport.personaltrainerqueryservice.querymodel;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
public class WorkoutSessionView {

    @Id
    private String workoutId;
    private Integer apprenticeId;
    private String apprenticeName;
    private Integer trainerId;
    private String trainerName;
    private Date workoutDate;
    private Integer session;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private Set<String> exercises = new HashSet<>();
    private Boolean confirm = false;

    public WorkoutSessionView(String workoutId, Integer apprenticeId, String apprenticeName, Integer trainerId, String trainerName, Date workoutDate, Integer session) {
        this.workoutId = workoutId;
        this.apprenticeId = apprenticeId;
        this.apprenticeName = apprenticeName;
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.workoutDate = workoutDate;
        this.session = session;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    public Integer getApprenticeId() {
        return apprenticeId;
    }

    public void setApprenticeId(Integer apprenticeId) {
        this.apprenticeId = apprenticeId;
    }

    public String getApprenticeName() {
        return apprenticeName;
    }

    public void setApprenticeName(String apprenticeName) {
        this.apprenticeName = apprenticeName;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public Date getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(Date workoutDate) {
        this.workoutDate = workoutDate;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public Set<String> getExercises() {
        return exercises;
    }

    public void setExercises(Set<String> exercises) {
        this.exercises = exercises;
    }

    public Boolean getConfirm() {
        return confirm;
    }

    public void setConfirm() {
        this.confirm = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutSessionView that = (WorkoutSessionView) o;
        return workoutId.equals(that.workoutId) && apprenticeId.equals(that.apprenticeId) && trainerId.equals(that.trainerId) && confirm.equals(that.confirm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId, apprenticeId, trainerId, confirm);
    }

    @Override
    public String toString() {
        return "ApprenticeWorkout{" +
                "workoutId=" + workoutId +
                ", apprenticeId=" + apprenticeId +
                ", apprenticeName='" + apprenticeName + '\'' +
                ", trainerId=" + trainerId +
                ", trainerName='" + trainerName + '\'' +
                ", workoutDate=" + workoutDate +
                ", session=" + session +
                ", exercises=" + exercises +
                ", confirm=" + confirm +
                '}';
    }
}
