package com.sport.events;

import java.sql.Date;
import java.util.Objects;

public class AppointWorkoutEvent extends AbstractWorkoutEvent {

    private final Integer trainerId;
    private final String trainerName;
    private final Integer apprenticeId;
    private final String apprenticeName;
    private final Date workoutDate;
    private final Integer session;

    public AppointWorkoutEvent(String workoutId, Integer trainerId, String trainerName, Integer apprenticeId, String apprenticeName, Date workoutDate, Integer session) {
        super(workoutId);
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.apprenticeId = apprenticeId;
        this.apprenticeName = apprenticeName;
        this.workoutDate = workoutDate;
        this.session = session;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public Integer getApprenticeId() {
        return apprenticeId;
    }

    public String getApprenticeName() {
        return apprenticeName;
    }

    public Date getWorkoutDate() {
        return workoutDate;
    }

    public Integer getSession() {
        return session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointWorkoutEvent that = (AppointWorkoutEvent) o;
        return trainerId.equals(that.trainerId) && apprenticeId.equals(that.apprenticeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId, apprenticeId);
    }

    @Override
    public String toString() {
        return "AppointWorkoutCommand{" +
                "workoutId=" + workoutId +
                ", trainerId=" + trainerId +
                ", trainerName='" + trainerName + '\'' +
                ", apprenticeId=" + apprenticeId +
                ", apprenticeName='" + apprenticeName + '\'' +
                ", workoutDate=" + workoutDate +
                ", session=" + session +
                '}';
    }
}
