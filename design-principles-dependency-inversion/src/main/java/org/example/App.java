package org.example;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Message msg = new Message("This is a message again");
        MessagePrinter printer = new MessagePrinter();
        try(PrintWriter writer = new PrintWriter("test_msg.txt")) {
            printer.writeMessage(msg, new JSONFormatter(), writer);
        }
    }
}
