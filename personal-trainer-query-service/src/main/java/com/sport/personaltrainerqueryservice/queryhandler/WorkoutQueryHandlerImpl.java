package com.sport.personaltrainerqueryservice.queryhandler;

import com.sport.personaltrainerqueryservice.queries.FindApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetweenQuery;
import com.sport.personaltrainerqueryservice.querymodel.WorkoutSessionView;
import com.sport.personaltrainerqueryservice.service.WorkoutSessionViewServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutQueryHandlerImpl implements WorkoutQueryHandler {

  private final WorkoutSessionViewServiceImpl workoutSessionViewService;

  @QueryHandler
  @Override
  public List<WorkoutSessionView> findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(
      FindApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetweenQuery query) {
    return workoutSessionViewService.findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(
        query.getApprenticeId(), query.getStart(), query.getEnd());
  }
}
