package com.growthdiary.sessionlog.history.requests;

import com.growthdiary.sessionlog.history.historysort.SortDirection;

public class SortRequest {

    private final String property;

    private final SortDirection sortDirection;

    public SortRequest(String property, SortDirection sortDirection) {
        this.property = property;
        this.sortDirection = sortDirection;
    }

    public String getProperty() {
        return this.property;
    }

    public SortDirection getSortDirection() {
        return this.sortDirection;
    }
}
