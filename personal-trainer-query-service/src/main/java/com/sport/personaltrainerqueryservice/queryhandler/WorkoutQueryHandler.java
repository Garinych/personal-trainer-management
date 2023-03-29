package com.sport.personaltrainerqueryservice.queryhandler;

import com.sport.personaltrainerqueryservice.queries.FindWorkoutSessionViewByApprenticeIdAndWorkoutDateBetweenQuery;
import com.sport.personaltrainerqueryservice.querymodel.WorkoutSessionView;
import java.util.List;

public interface WorkoutQueryHandler {

  List<WorkoutSessionView> findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(
      FindWorkoutSessionViewByApprenticeIdAndWorkoutDateBetweenQuery query);

}
