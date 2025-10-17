package org.example;

import javafx.geometry.Point2D;

//Concrete class provides the actual functionalities
public class BitmapImage implements Image {

    private Point2D location;
    private final String name;

    public BitmapImage(String filename) {
        //Loads image from file on disk
        System.out.println("Loaded from disk: " + filename);
        name = filename;
    }
    @Override
    public void setLocation(Point2D point2D) {
        location = point2D;
    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public void render() {
        //renders to screen
        System.out.println("Rendered " + this.name);
    }
}
