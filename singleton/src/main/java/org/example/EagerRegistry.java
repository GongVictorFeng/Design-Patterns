package org.example;

// This class uses eager initialization of singleton instance
public class EagerRegistry {

    private final static EagerRegistry instance = new EagerRegistry();

    private EagerRegistry() {}

    public static EagerRegistry getInstance() {
        return instance;
    }
}
