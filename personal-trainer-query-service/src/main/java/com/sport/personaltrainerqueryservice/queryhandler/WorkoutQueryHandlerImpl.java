package com.sport.personaltrainerqueryservice.queryhandler;

import com.sport.personaltrainerqueryservice.queries.FindWorkoutSessionViewByApprenticeIdAndWorkoutDateBetweenQuery;
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

  /**
   * Use the AnnotationQueryHandlerAdapter to subscribe the annotated class to the query bus.
   */
  @QueryHandler
  @Override
  public List<WorkoutSessionView> findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(
      FindWorkoutSessionViewByApprenticeIdAndWorkoutDateBetweenQuery query) {
    return workoutSessionViewService.findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(
        query.getApprenticeId(), query.getStart(), query.getEnd());
  }
}
