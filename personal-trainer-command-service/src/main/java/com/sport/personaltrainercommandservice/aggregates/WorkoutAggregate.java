package com.sport.personaltrainercommandservice.aggregates;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import com.sport.events.AppointWorkoutEvent;
import com.sport.events.ConfirmWorkoutEvent;
import com.sport.events.SetWorkoutExercisesEvent;
import com.sport.personaltrainercommandservice.commands.AppointWorkoutCommand;
import com.sport.personaltrainercommandservice.commands.ConfirmWorkoutCommand;
import com.sport.personaltrainercommandservice.commands.SetWorkoutExercisesCommand;
import java.util.stream.Collectors;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


@Aggregate
public class WorkoutAggregate {

    // @AggregateIdentifier used to identify commands, and need to be unique for all commands events
    @AggregateIdentifier
    private String workoutId;
    private boolean workoutConfirmed;


    protected WorkoutAggregate() {
        // Required by Axon to build a default Aggregate prior to Event Sourcing
    }

    @CommandHandler
    public WorkoutAggregate(AppointWorkoutCommand appointWorkoutCommand) {

        apply(new AppointWorkoutEvent(appointWorkoutCommand.getWorkoutId(), appointWorkoutCommand.getTrainerId(),
                appointWorkoutCommand.getTrainerName(), appointWorkoutCommand.getApprenticeId(), appointWorkoutCommand.getApprenticeName(),
                appointWorkoutCommand.getWorkoutDate(), appointWorkoutCommand.getSession()));
    }

    @CommandHandler
    public WorkoutAggregate(SetWorkoutExercisesCommand workoutExercisesCommand) {

        apply(new SetWorkoutExercisesEvent(workoutExercisesCommand.getWorkoutId(),
                workoutExercisesCommand.getExercises().stream().map(Enum::toString).collect(Collectors.toSet())));

    }

    @CommandHandler
    public WorkoutAggregate(ConfirmWorkoutCommand confirmWorkoutCommand) {

        apply(new ConfirmWorkoutEvent(confirmWorkoutCommand.getWorkoutId()));
    }

    @EventSourcingHandler
    public void on(AppointWorkoutEvent event) {
        this.workoutId = event.getWorkoutId() + "-AppointWorkoutEvent";
        this.workoutConfirmed = false;
    }

    @EventSourcingHandler
    public void on(SetWorkoutExercisesEvent event) {
        this.workoutId = event.getWorkoutId() + "-SetWorkoutExercisesEvent";
        this.workoutConfirmed = false;
    }

    @EventSourcingHandler
    public void on(ConfirmWorkoutEvent event) {
        this.workoutId = event.getWorkoutId() + "-ConfirmWorkoutEvent";
        this.workoutConfirmed = true;
    }

}
