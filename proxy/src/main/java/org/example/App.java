package org.example;

import javafx.geometry.Point2D;
import org.example.dynamic.DynamicImageFactory;

public class App
{
    public static void main( String[] args )
    {
        Image img = ImageFactory.getImage("A1.bmp");
        img.setLocation(new Point2D(10,10));
        System.out.println("Image location :" + img.getLocation());
        System.out.println("Rendering image now......");
        img.render();
        System.out.println("****************************************");
        Image dImg = DynamicImageFactory.getImage("B1.bmp");
        dImg.setLocation(new Point2D(-10,0));
        System.out.println(dImg.getLocation());
        dImg.render();
    }
}
