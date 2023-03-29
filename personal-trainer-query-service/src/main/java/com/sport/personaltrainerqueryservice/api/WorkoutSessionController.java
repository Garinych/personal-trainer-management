package com.sport.personaltrainerqueryservice.api;

import com.sport.personaltrainerqueryservice.dto.WorkoutSessionViewDTO;
import com.sport.personaltrainerqueryservice.service.WorkoutSessionQueryService;
import com.sport.personaltrainerqueryservice.util.DateParam;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorkoutSessionController {

  private final WorkoutSessionQueryService workoutSessionQueryService;

  @GetMapping("/workout-sessions/apprentice/{apprenticeId}/start/{startDate}/end/{endDate}")
  public CompletableFuture<List<WorkoutSessionViewDTO>> findApprenticeWorkoutSessionsBetweenDates(
      @PathVariable("apprenticeId") Integer apprenticeId,
      @PathVariable("startDate") DateParam starDate,
      @PathVariable("endDate") DateParam endDate) {

    return workoutSessionQueryService.findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(
        apprenticeId, starDate.getDate(), endDate.getDate());
  }
}
