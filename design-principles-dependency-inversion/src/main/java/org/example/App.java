package org.example;

import java.io.FileWriter;
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
        try(PrintWriter writer = new PrintWriter(new FileWriter("test_meg.txt"))) {
            printer.writeMessage(msg, new JSONFormatter(), writer);
        }
    }
}
