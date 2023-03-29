package com.sport.personaltrainercommandservice.commands;

public class ConfirmWorkoutCommand extends AbstractWorkoutCommand {

    public ConfirmWorkoutCommand(String workoutId) {
        super(workoutId);
    }

    @Override
    public String toString() {
        return "ConfirmWorkoutCommand{" +
                "workoutId=" + workoutId +
                '}';
    }
}
