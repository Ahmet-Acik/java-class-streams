// Order.java
package org.ahmet.classes.model;

public class Order {
    private String id;
    private String status;
    private double totalPrice;

    public Order(String id, String status, double totalPrice) {
        this.id = id;
        this.status = status;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}