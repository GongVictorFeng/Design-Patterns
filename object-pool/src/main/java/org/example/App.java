package org.example;

public class App 
{
    public static ObjectPool<Image> bitmapObjectPool = new ObjectPool<>(() -> new Bitmap("logo.bmp"), 5);
    public static void main( String[] args )
    {
        Image b1 = bitmapObjectPool.get();
        b1.setLocation(new Point2D(10, 10));
        Image b2 = bitmapObjectPool.get();
        b2.setLocation(new Point2D(-10, 0));

        b1.draw();
        b2.draw();

        bitmapObjectPool.release(b1);
        bitmapObjectPool.release(b2);
    }
}
