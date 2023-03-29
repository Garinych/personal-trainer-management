package com.sport.personaltrainerqueryservice.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.sport.personaltrainerqueryservice.querymodel.WorkoutSessionView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutSessionViewDTO {

    private String workoutId;
    private Integer apprenticeId;
    private String apprenticeName;
    private Integer trainerId;
    private String trainerName;
    private Date workoutDate;
    private Integer session = 0;
    private Set<String> exercises = new HashSet<>();
    private Boolean confirm = false;

    public WorkoutSessionViewDTO(WorkoutSessionView workoutSessionView) {
        this.workoutId = workoutSessionView.getWorkoutId();
        this.apprenticeId = workoutSessionView.getApprenticeId();
        this.apprenticeName = workoutSessionView.getApprenticeName();
        this.trainerId = workoutSessionView.getTrainerId();
        this.trainerName = workoutSessionView.getTrainerName();
        this.workoutDate = workoutSessionView.getWorkoutDate();
        this.session = workoutSessionView.getSession();
        this.exercises = workoutSessionView.getExercises();
        this.confirm = workoutSessionView.getConfirm();
    }
}
