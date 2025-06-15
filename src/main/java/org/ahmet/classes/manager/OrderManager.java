// OrderManager.java
package org.ahmet.classes.manager;

import org.ahmet.classes.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderManager {
    private List<Order> orders;

    public OrderManager(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> filterByStatus(String status) {
        return orders.stream()
                .filter(order -> status.equals(order.getStatus()))
                .collect(Collectors.toList());
    }

    public double calculateTotalRevenue() {
        return orders.stream()
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }

    public List<String> getOrderIds() {
        return orders.stream()
                .map(Order::getId)
                .collect(Collectors.toList());
    }
}