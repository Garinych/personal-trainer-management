package com.sport.personaltrainerqueryservice.eventhandler;


import com.sport.events.AppointWorkoutEvent;
import com.sport.events.ConfirmWorkoutEvent;
import com.sport.events.SetWorkoutExercisesEvent;

public interface WorkoutSessionEventHandler {

    void on(AppointWorkoutEvent appointWorkoutEvent);

    void on(SetWorkoutExercisesEvent setWorkoutExercisesEvent);

    void on(ConfirmWorkoutEvent confirmWorkoutEvent);
}
