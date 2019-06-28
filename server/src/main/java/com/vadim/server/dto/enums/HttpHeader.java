package com.vadim.server.dto.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HttpHeader {

    X_TOTAL_COUNT("X-Total-Count"),
    X_NEW_MATCHES_COUNT("X-New-Matches-Count"),
    X_7PM_COUNTDOWN("X-forum-Countdown"),
    X_TERMS_AND_CONDITIONS_ACCEPTED("X-Terms-And-Conditions-Accepted");

    private String value;

    HttpHeader(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }
}
