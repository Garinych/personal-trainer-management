package com.sport.personaltrainerqueryservice.service;

import com.sport.personaltrainerqueryservice.dto.WorkoutSessionViewDTO;
import com.sport.personaltrainerqueryservice.queries.FindWorkoutSessionViewByApprenticeIdAndWorkoutDateBetweenQuery;
import com.sport.personaltrainerqueryservice.querymodel.WorkoutSessionView;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutSessionQueryService {

  // QueryGateway allow as to execute query on different nodes in the cluster and get one result
  private final QueryGateway queryGateway;

  public CompletableFuture<List<WorkoutSessionViewDTO>> findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(
      int apprenticeId, Date start, Date end) {
    return queryGateway.query(
            new FindWorkoutSessionViewByApprenticeIdAndWorkoutDateBetweenQuery(
                apprenticeId, start, end), ResponseTypes.multipleInstancesOf(WorkoutSessionView.class))
        .thenApply(r -> r.stream()
            .map(WorkoutSessionViewDTO::new)
            .toList());
  }
}
