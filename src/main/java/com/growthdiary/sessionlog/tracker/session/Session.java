package com.growthdiary.sessionlog.tracker.session;

import com.growthdiary.sessionlog.tracker.details.Details;
import com.growthdiary.sessionlog.tracker.feedback.Feedback;
import com.growthdiary.sessionlog.tracker.time.Time;
import jakarta.persistence.*;

/**
 * Main entity to represent a user learning session
 */
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "details_id")
    private Details details;

    @OneToOne
    @JoinColumn(name = "time_id")
    private Time time;

    @ManyToOne
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    /* Default no-argument constructor required by Hibernate
     * Used during database queries
     */
    public Session() {
    }

    public Session(Details details, Time time, Feedback feedback) {
        this.details = details;
        this.time = time;
        this.feedback = feedback;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Details getDetails() { return this.details; }

    public Time getTime() {
        return this.time;
    }

    public Feedback getFeedback() {
        return this.feedback;
    }
}