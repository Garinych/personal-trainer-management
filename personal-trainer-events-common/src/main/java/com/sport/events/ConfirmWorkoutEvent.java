package com.sport.events;

public class ConfirmWorkoutEvent extends AbstractWorkoutEvent {

    public ConfirmWorkoutEvent(String workoutId) {
        super(workoutId);
    }

    public String getWorkoutId() {
        return workoutId;
    }

    @Override
    public String toString() {
        return "ConfirmWorkoutCommand{" +
                "workoutId=" + workoutId +
                '}';
    }
}
