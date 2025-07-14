package org.example;
/**
 * (Ref.Google I/O 2k8 Joshua Bloch)
 * Since Java 1.5 uses enum, we can create singleton.
 * It handles serialization using Java's in-built mechanism and still ensure single instance
 *  */
public enum RegistryEnum {
    INSTANCE;
    public void getConfiguration() {};
}
