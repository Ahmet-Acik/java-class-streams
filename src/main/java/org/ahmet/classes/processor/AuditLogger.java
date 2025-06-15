package org.ahmet.classes.processor;// AuditLogger.java
import java.util.ArrayList;
import java.util.List;

public class AuditLogger {
    private List<String> logs = new ArrayList<>();

    public void logEvent(String event) {
        if (event == null || event.isEmpty()) {
            throw new IllegalArgumentException("Event cannot be null or empty.");
        }
        logs.add(event);
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }
}