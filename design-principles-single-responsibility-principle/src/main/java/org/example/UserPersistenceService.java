package org.example;

public class UserPersistenceService {
    private final Store  store = new Store();

    public void SaveUser(User user) {
        store.store(user);
    }
}
