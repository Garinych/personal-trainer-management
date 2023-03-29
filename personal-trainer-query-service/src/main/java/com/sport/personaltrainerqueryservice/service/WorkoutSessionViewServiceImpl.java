package com.sport.personaltrainerqueryservice.service;

import com.sport.events.AbstractWorkoutEvent;
import com.sport.events.AppointWorkoutEvent;
import com.sport.events.ConfirmWorkoutEvent;
import com.sport.events.SetWorkoutExercisesEvent;
import com.sport.personaltrainerqueryservice.querymodel.WorkoutSessionView;
import com.sport.personaltrainerqueryservice.repository.WorkoutSessionViewRepository;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutSessionViewServiceImpl implements WorkoutSessionViewService {

  public final WorkoutSessionViewRepository workoutSessionViewRepository;

  @Override
  public void updateApprenticeWorkoutView(AbstractWorkoutEvent workoutEvent) {
    WorkoutSessionView workoutView = null;
    if (workoutEvent instanceof AppointWorkoutEvent) {
      workoutView = new WorkoutSessionView();
      final AppointWorkoutEvent appointWorkoutEvent = (AppointWorkoutEvent) workoutEvent;
      workoutView.setWorkoutId(appointWorkoutEvent.getWorkoutId());
      workoutView.setApprenticeId(appointWorkoutEvent.getApprenticeId());
      workoutView.setApprenticeName(appointWorkoutEvent.getApprenticeName());
      workoutView.setTrainerId(appointWorkoutEvent.getTrainerId());
      workoutView.setTrainerName(appointWorkoutEvent.getTrainerName());
      workoutView.setWorkoutDate(appointWorkoutEvent.getWorkoutDate());
      workoutView.setSession(appointWorkoutEvent.getSession());

    } else if (workoutEvent instanceof SetWorkoutExercisesEvent) {
      final SetWorkoutExercisesEvent setWorkoutExercisesEvent =
          (SetWorkoutExercisesEvent) workoutEvent;
      workoutView =
          workoutSessionViewRepository.findByWorkoutId(setWorkoutExercisesEvent.getWorkoutId());
      workoutView.setExercises(setWorkoutExercisesEvent.getExercises());

    } else if (workoutEvent instanceof ConfirmWorkoutEvent) {
      final ConfirmWorkoutEvent confirmWorkoutEvent = (ConfirmWorkoutEvent) workoutEvent;
      workoutView =
          workoutSessionViewRepository.findByWorkoutId(confirmWorkoutEvent.getWorkoutId());
      workoutView.setConfirm();
    }
    if (workoutView != null) {
      workoutSessionViewRepository.save(workoutView);
    }
  }

  @Override
  public List<WorkoutSessionView> findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(
      Integer apprenticeId, Date start, Date end) {
    return workoutSessionViewRepository.findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(
        apprenticeId, start, end);
  }

}
