package com.sport.personaltrainercommandservice.api;

import com.sport.personaltrainercommandservice.commands.AppointWorkoutCommand;
import com.sport.personaltrainercommandservice.commands.ConfirmWorkoutCommand;
import com.sport.personaltrainercommandservice.commands.SetWorkoutExercisesCommand;
import com.sport.personaltrainercommandservice.dto.AppointWorkoutDTO;
import com.sport.personaltrainercommandservice.dto.SetWorkoutExercisesDTO;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorkoutController {

  private final CommandGateway commandGateway;

  @PostMapping("/workout")
  public AppointWorkoutDTO appointWorkout(
      @Validated @RequestBody AppointWorkoutDTO appointWorkoutDTO)
      throws ExecutionException, InterruptedException {

    final String workoutId = UUID.randomUUID().toString();
    appointWorkoutDTO.setWorkoutId(workoutId);

    commandGateway.send(new AppointWorkoutCommand(workoutId, appointWorkoutDTO.getTrainerId(),
        appointWorkoutDTO.getTrainerName(), appointWorkoutDTO.getApprenticeId(),
        appointWorkoutDTO.getApprenticeName(),
        appointWorkoutDTO.getWorkoutDate(), appointWorkoutDTO.getSession())).get();

    return appointWorkoutDTO;
  }

  @PostMapping("/workout/{workoutId}/exercises")
  public CompletableFuture<String> setWorkoutExercises(
      @PathVariable String workoutId,
      @Validated @RequestBody SetWorkoutExercisesDTO setWorkoutExercisesDTO) {

    return commandGateway.send(
        new SetWorkoutExercisesCommand(workoutId, setWorkoutExercisesDTO.getExercises()));
  }

  @PostMapping("/workout/{workoutId}/confirm")
  public CompletableFuture<Void> setWorkout(@PathVariable String workoutId) {
    return commandGateway.send(new ConfirmWorkoutCommand(workoutId));
  }

}
