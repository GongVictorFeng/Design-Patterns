package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Message m = new TextMessage("The <FORCE> is strong with this one!");
        System.out.println(m.getContent());

        Message decorator = new HtmlEncodedMessage(m);
        System.out.println(decorator.getContent());

        //recursive decoration
        decorator = new Base64EncodedMessage(decorator);
        System.out.println(decorator.getContent());
    }
}
