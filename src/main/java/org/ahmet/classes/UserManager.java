package org.ahmet.classes;// UserManager.java
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<Integer, String> users = new HashMap<>();

    public void addUser(int id, String name) {
        if (users.containsKey(id)) {
            throw new IllegalArgumentException("User ID already exists.");
        }
        users.put(id, name);
    }

    public void removeUser(int id) {
        users.remove(id);
    }

    public String getUser(int id) {
        return users.get(id);
    }
}