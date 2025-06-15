// InventoryManager.java
package org.ahmet.classes.service;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addItem(String item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(String item, int quantity) {
        if (!inventory.containsKey(item) || inventory.get(item) < quantity) {
            throw new IllegalArgumentException("Insufficient stock or item not found.");
        }
        inventory.put(item, inventory.get(item) - quantity);
    }

    public int checkStock(String item) {
        return inventory.getOrDefault(item, 0);
    }
}