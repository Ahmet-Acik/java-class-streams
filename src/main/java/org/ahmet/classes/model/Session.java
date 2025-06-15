package org.ahmet.classes.model;

public class Session {
    private String sessionId;
    private String userId;

    public Session(String sessionId, String userId) {
        this.sessionId = sessionId;
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }
}