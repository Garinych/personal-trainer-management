package com.sport.personaltrainerqueryservice.queries;


import java.sql.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetweenQuery {

    private Integer apprenticeId;
    private Date start;
    private Date end;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetweenQuery that = (FindApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetweenQuery) o;
        return apprenticeId.equals(that.apprenticeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apprenticeId);
    }

    @Override
    public String toString() {
        return "FindApprenticeWorkoutViewByApprenticeIdAndWorkoutDateBetween{" +
                "apprenticeId=" + apprenticeId +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
