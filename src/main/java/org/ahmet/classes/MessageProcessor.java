package org.ahmet.classes;

// MessageProcessor.java
public class MessageProcessor {
    public String filterMessage(String message, String keyword) {
        if (message == null || keyword == null) {
            return null;
        }
        return message.contains(keyword) ? message : null;
    }

    public String transformMessage(String message) {
        if (message == null) {
            return null;
        }
        return message.toUpperCase();
    }
}