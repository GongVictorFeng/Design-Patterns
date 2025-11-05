package org.example.dynamic;

import org.example.Image;

import java.lang.reflect.Proxy;

//Factory to get image objects
public class DynamicImageFactory {
    //We'll provide proxy to caller instead of real object
    public static Image getImage(String filename) {
        //Using Java's Proxy API we create proxy instance
        return (Image) Proxy.newProxyInstance(DynamicImageFactory.class.getClassLoader(), new Class[]{Image.class}, new ImageInvocationHandler(filename));
    }
}
