package com.sport.personaltrainerqueryservice.queryhandler;

import java.util.List;

import com.sport.personaltrainerqueryservice.queries.FindApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetweenQuery;
import com.sport.personaltrainerqueryservice.querymodel.WorkoutSessionView;

public interface WorkoutQueryHandler {

    List<WorkoutSessionView> findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(FindApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetweenQuery query);

}