package com.sport.personaltrainercommandservice.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AppointWorkoutDTO {

    private String workoutId;
    private Integer trainerId;
    private String trainerName;
    private Integer apprenticeId;
    private String apprenticeName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date workoutDate;
    private Integer session;
}
