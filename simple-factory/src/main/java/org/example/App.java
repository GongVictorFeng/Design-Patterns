package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Post post = PostFactory.createPost("news");
        System.out.println(post);
    }
}
