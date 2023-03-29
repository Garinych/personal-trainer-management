package com.sport.personaltrainercommandservice.commands;

import java.util.HashSet;
import java.util.Set;

import com.sport.personaltrainercommandservice.enums.Exercise;

public class SetWorkoutExercisesCommand extends AbstractWorkoutCommand {

    private final Set<Exercise> exercises;

    public SetWorkoutExercisesCommand(String workoutId, Set<Exercise> exercises) {
        super(workoutId);
        this.exercises = new HashSet<>(exercises);
    }

    public Set<Exercise> getExercises() {
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
