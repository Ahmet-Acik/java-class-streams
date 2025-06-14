package org.ahmet.classes;

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

            public String processMessage(String helloWorld) {
                if (helloWorld == null) {
                    throw new IllegalArgumentException("Input cannot be null.");
                }
                return "Processed: " + helloWorld;
            }
        }