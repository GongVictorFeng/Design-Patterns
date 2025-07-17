package org.example;

//Represents our abstract reusable
public interface Image extends Portable {
    void draw();
    Point2D getLocation();
    void setLocation(Point2D location);
}
