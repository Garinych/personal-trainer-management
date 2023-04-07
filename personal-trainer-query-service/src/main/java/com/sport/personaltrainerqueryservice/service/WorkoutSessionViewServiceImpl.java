package com.sport.personaltrainerqueryservice.service;

import com.sport.personaltrainerecentscommon.AbstractWorkoutEvent;
import com.sport.personaltrainerecentscommon.AppointWorkoutEvent;
import com.sport.personaltrainerecentscommon.ConfirmWorkoutEvent;
import com.sport.personaltrainerecentscommon.SetWorkoutExercisesEvent;
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

    if (workoutEvent instanceof final AppointWorkoutEvent appointWorkoutEvent) {

      workoutView = new WorkoutSessionView();
      workoutView.setWorkoutId(appointWorkoutEvent.getWorkoutId());
      workoutView.setApprenticeId(appointWorkoutEvent.getApprenticeId());
      workoutView.setApprenticeName(appointWorkoutEvent.getApprenticeName());
      workoutView.setTrainerId(appointWorkoutEvent.getTrainerId());
      workoutView.setTrainerName(appointWorkoutEvent.getTrainerName());
      workoutView.setWorkoutDate(appointWorkoutEvent.getWorkoutDate());
      workoutView.setSession(appointWorkoutEvent.getSession());

    } else if (workoutEvent instanceof final SetWorkoutExercisesEvent setWorkoutExercisesEvent) {

      workoutView = workoutSessionViewRepository.findByWorkoutId(setWorkoutExercisesEvent.getWorkoutId());
      workoutView.setExercises(setWorkoutExercisesEvent.getExercises());

    } else if (workoutEvent instanceof final ConfirmWorkoutEvent confirmWorkoutEvent) {

      workoutView = workoutSessionViewRepository.findByWorkoutId(confirmWorkoutEvent.getWorkoutId());
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
