package org.ahmet.classes.model;

public class QueueItem {
    private String id;
    private int priority;

    public QueueItem(String id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }
}