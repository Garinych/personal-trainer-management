# Personal Trainer Management

## Purpose of this application, is to show the simple realisation of a CQRS pattern using the Event Sourcing pattern and AXON Framework

## to run we need:

    1. Run Axon server, you can downloade it from this link - https://download.axoniq.io/axonserver/AxonServer.zip
    2. Start two services:
        * First - personal-trainer-command-service
        * Second - personal-trainer-query-service

## API examples for Command side:

#### 1) AppointWorkout POST endpoint - localhost:8080/workout

#### RequestBody:
    {
        "trainerId": 1,
        "trainerName": "trainer 1",
        "apprenticeId": 2,
        "apprenticeName": "apprentice 1",
        "workoutDate": "2023-03-23",
        "session": 2
    }

#### 2) SetWorkoutExercises POST endpoint - localhost:8080/workout/{workoutId}/exercises

#### RequestBody:
    {
        "exercises": ["SQUATTING", "PUSH_UP"]
    }

#### 3) ConfirmWorkout POST endpoint - localhost:8080/workout/{workoutId}/confirm

#### RequestBody:
    {
        "trainerId": 1,
        "trainerName": "trainer 1",
        "apprenticeId": 2,
        "apprenticeName": "apprentice 1",
        "workoutDate": "2023-03-23",
        "session": 2
    }

## API examples for Query side:

#### WorkoutSessionView GET endpoint for query "FindWorkoutSessionViewByApprenticeIdAndWorkoutDateBetweenQuery" - localhost:8081/workout-sessions/apprentice/{apprenticeId}/start/2023-03-21/end/2023-03-24

#### ResponseBody:
    [
        {
            "workoutId": "0f476bc9-9d8f-466e-8897-4629cb58ad7a",
            "apprenticeId": 2,
            "apprenticeName": "apprentice 1",
            "trainerId": 1,
            "trainerName": "trainer 1",
            "workoutDate": "2023-03-23",
            "session": 2,
            "exercises": [],
            "confirm": false
        }
    ]