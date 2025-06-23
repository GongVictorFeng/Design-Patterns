package org.example;

public class TextFormatter implements Formatter{
    @Override
    public String format(Message message) {
        return message.getTimestamp()+":"+message.getMsg();
    }
}
