package org.example;

import org.example.message.Message;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        printMessage(new JSONMessageCreator());
        printMessage(new TextMessageCreator());
    }

    public static void printMessage(MessageCreator creator) {
        Message msg = creator.getMessage();
        System.out.println(msg);
    }
}
