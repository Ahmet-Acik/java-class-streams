// OrderProcessor.java
package org.ahmet.classes;

import java.util.List;

public class OrderProcessor {
    public double calculateTotalPrice(List<Double> prices) {
        return prices.stream().mapToDouble(Double::doubleValue).sum();
    }

    public double applyDiscount(double totalPrice, double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage.");
        }
        return totalPrice - (totalPrice * discountPercentage / 100);
    }
}