package com.growthdiary.sessionlog.tracker.models;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
public class Time {

    private LocalDate startDate;
    private LocalTime startTime;
    private LocalDate endDate;
    private LocalTime endTime;
    private Long duration;

    /*
     * A no-args constructor is required by Hibernate when inserting data into the database
     */
    public Time() {}

    public Time(LocalDate startDate,
                LocalDate endDate,
                LocalTime startTime,
                LocalTime endTime,
                Long duration) {
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
        this.duration = duration;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getDuration() {
        return this.duration;
    }
}