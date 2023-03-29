package com.sport.personaltrainercommandservice.commands;

import java.util.Objects;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class AbstractWorkoutCommand {

    @TargetAggregateIdentifier
    protected final String workoutId;

    protected AbstractWorkoutCommand(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getWorkoutId() {
        return workoutId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractWorkoutCommand that = (AbstractWorkoutCommand) o;
        return workoutId.equals(that.workoutId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId);
    }

}
