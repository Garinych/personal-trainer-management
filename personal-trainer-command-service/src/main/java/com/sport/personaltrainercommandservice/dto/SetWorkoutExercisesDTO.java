package com.sport.personaltrainercommandservice.dto;

import java.util.HashSet;
import java.util.Set;

import com.sport.personaltrainercommandservice.enums.Exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SetWorkoutExercisesDTO {

    private Set<Exercise> exercises = new HashSet<>();
}
