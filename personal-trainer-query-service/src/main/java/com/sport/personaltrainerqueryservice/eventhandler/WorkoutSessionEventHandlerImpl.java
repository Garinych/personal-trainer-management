package com.sport.personaltrainerqueryservice.eventhandler;

import com.sport.events.AppointWorkoutEvent;
import com.sport.events.ConfirmWorkoutEvent;
import com.sport.events.SetWorkoutExercisesEvent;
import com.sport.personaltrainerqueryservice.service.WorkoutSessionViewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("orders")
@RequiredArgsConstructor
public class WorkoutSessionEventHandlerImpl implements WorkoutSessionEventHandler {

  private final WorkoutSessionViewServiceImpl apprenticeWorkoutViewService;

  @EventHandler
  @Override
  public void on(AppointWorkoutEvent appointWorkoutEvent) {
    apprenticeWorkoutViewService.updateApprenticeWorkoutView(appointWorkoutEvent);
  }

  @EventHandler
  @Override
  public void on(SetWorkoutExercisesEvent setWorkoutExercisesEvent) {
    apprenticeWorkoutViewService.updateApprenticeWorkoutView(setWorkoutExercisesEvent);
  }

  @EventHandler
  @Override
  public void on(ConfirmWorkoutEvent confirmWorkoutEvent) {
    apprenticeWorkoutViewService.updateApprenticeWorkoutView(confirmWorkoutEvent);
  }

}
