package org.example;

import java.util.HashMap;
import java.util.Map;

//Stores data in memory
public class Store {
    private static final Map<String, User> STORAGE = new HashMap<>();
    //Adds user to the memory hash map
    public void store(User user) {
        synchronized(STORAGE) {
            STORAGE.put(user.getName(), user);
        }
    }

    //Returns user with given id if present in map else null
    public User getUser(String name) {
        synchronized (STORAGE) {
            return STORAGE.get(name);
        }
    }
}
