package org.example;

import org.example.message.JSONMessage;
import org.example.message.Message;

public class JSONMessageCreator extends MessageCreator {
    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}
