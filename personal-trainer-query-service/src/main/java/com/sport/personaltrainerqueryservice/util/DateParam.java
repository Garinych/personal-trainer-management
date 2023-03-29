package com.sport.personaltrainerqueryservice.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalField;

/**
 * Parameter class for dates
 * Allowed pattern: yyyy-MM-DD, e.g. 2016-12-06
 */
public class DateParam {

    private static final DateTimeFormatter DF = DateTimeFormatter.ISO_LOCAL_DATE;

    private final Date date;

    /**
     * Constructor
     * Parse string to date
     *
     * @param param String date parameter
     * @throws Exception exception
     */
    public DateParam(String param) throws Exception {

        try {
            date = Date.valueOf(LocalDate.parse(param, DF));
        } catch (DateTimeParseException ex) {
            throw new Exception("Error parsing date param");
        }
    }

    /**
     * Constructor
     *
     * @param date Date parameter
     */
    public DateParam(Date date) {

        this.date = date;
    }

    /**
     * get date value
     *
     * @return date value
     */
    public Date getDate() {
        return date;
    }

    /**
     * Date param to string
     */
    @Override
    public String toString() {
        return date.toString();
    }

}