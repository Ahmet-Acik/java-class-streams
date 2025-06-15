// NotificationService.java
package org.ahmet.classes.processor;

public class NotificationService {
    public void sendEmail(String email, String message) {
        if (email == null || message == null) {
            throw new IllegalArgumentException("Email or message cannot be null.");
        }
        System.out.println("Email sent to " + email + ": " + message);
    }

    public void sendSMS(String phoneNumber, String message) {
        if (phoneNumber == null || message == null) {
            throw new IllegalArgumentException("Phone number or message cannot be null.");
        }
        System.out.println("SMS sent to " + phoneNumber + ": " + message);
    }
}