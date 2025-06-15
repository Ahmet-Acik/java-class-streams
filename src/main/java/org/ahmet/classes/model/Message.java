package org.ahmet.classes.model;

import javax.annotation.Nonnull;

public class Message {
    @Nonnull
    private final String content;

    private final String sender;
    private final String receiver;
    private final long timestamp;

    public Message(@Nonnull String content, String sender, String receiver, long timestamp) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
    }

    @Nonnull
    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public long getTimestamp() {
        return timestamp;
    }
}