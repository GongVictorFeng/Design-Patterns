package org.example;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public class Message {
    private final String msg;
    private final LocalDateTime timestamp;

    public Message(String msg) {
        this.msg = msg;
        this.timestamp = LocalDateTime.now(ZoneId.of("UTC"));
    }
}
