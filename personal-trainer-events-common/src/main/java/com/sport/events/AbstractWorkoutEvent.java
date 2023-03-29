package com.sport.events;

import java.util.Objects;

public abstract class AbstractWorkoutEvent {

    protected final String workoutId;

    protected AbstractWorkoutEvent(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractWorkoutEvent that = (AbstractWorkoutEvent) o;
        return workoutId.equals(that.workoutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId);
    }

}
