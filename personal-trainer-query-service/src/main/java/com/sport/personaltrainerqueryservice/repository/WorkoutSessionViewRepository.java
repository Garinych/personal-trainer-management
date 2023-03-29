package com.sport.personaltrainerqueryservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sport.personaltrainerqueryservice.querymodel.WorkoutSessionView;

@Repository
public interface WorkoutSessionViewRepository extends CrudRepository<WorkoutSessionView, Integer> {

    WorkoutSessionView findByWorkoutId(String workoutId);
    List<WorkoutSessionView> findApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween(final Integer apprenticeId, final Date start, final Date end);
}
