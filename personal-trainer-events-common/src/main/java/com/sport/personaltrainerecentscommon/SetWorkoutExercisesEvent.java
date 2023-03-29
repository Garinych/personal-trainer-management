package com.sport.personaltrainerecentscommon;

import java.util.Set;


public class SetWorkoutExercisesEvent extends AbstractWorkoutEvent {

    private final Set<String> exercises;

    public SetWorkoutExercisesEvent(String workoutId, Set<String> exercises) {
        super(workoutId);
        this.exercises = exercises;
    }

    public Set<String> getExercises() {
        return exercises;
    }

    @Override
    public String toString() {
        return "SetWorkoutExercisesCommand{" +
                "workoutId=" + workoutId +
                ", exercises=" + exercises +
                '}';
    }
}
