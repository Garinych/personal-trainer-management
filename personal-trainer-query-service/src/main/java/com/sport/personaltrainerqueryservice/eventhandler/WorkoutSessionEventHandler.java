package com.sport.personaltrainerqueryservice.eventhandler;


import com.sport.personaltrainerecentscommon.AppointWorkoutEvent;
import com.sport.personaltrainerecentscommon.ConfirmWorkoutEvent;
import com.sport.personaltrainerecentscommon.SetWorkoutExercisesEvent;

public interface WorkoutSessionEventHandler {

    void on(AppointWorkoutEvent appointWorkoutEvent);

    void on(SetWorkoutExercisesEvent setWorkoutExercisesEvent);

    void on(ConfirmWorkoutEvent confirmWorkoutEvent);
}
