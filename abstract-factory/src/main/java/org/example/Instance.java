package org.example;

//Represents an abstract product
public interface Instance {
    enum Capacity {micro, small, large}
    void start();
    void stop();
    void attachStorage(Storage storage);
}
