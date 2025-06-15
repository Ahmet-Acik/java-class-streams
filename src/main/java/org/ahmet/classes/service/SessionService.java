// SessionManager.java
package org.ahmet.classes.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionService {
    private Map<String, String> sessions = new HashMap<>();

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public boolean validateSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    public void terminateSession(String sessionId) {
        sessions.remove(sessionId);
    }
}