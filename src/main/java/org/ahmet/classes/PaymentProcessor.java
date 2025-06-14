// PaymentProcessor.java
package org.ahmet.classes;

public class PaymentProcessor {
    public boolean validatePayment(double amount) {
        return amount > 0;
    }

    public String processPayment(double amount) {
        if (!validatePayment(amount)) {
            throw new IllegalArgumentException("Invalid payment amount.");
        }
        return "Payment of $" + amount + " processed successfully.";
    }
}