package com.sport.personaltrainerqueryservice.service;

import java.util.Date;
import java.util.List;

import com.sport.personaltrainerecentscommon.AbstractWorkoutEvent;
import com.sport.personaltrainerqueryservice.querymodel.WorkoutSessionView;

public interface WorkoutSessionViewService {
    List<WorkoutSessionView> findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(final Integer apprenticeId, final Date start, final Date end);

    void updateApprenticeWorkoutView(AbstractWorkoutEvent workoutEvent);
}
