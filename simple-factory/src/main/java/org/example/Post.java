package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// Abstract post class. Represents a generic post on a website
@Getter
@Setter
public abstract class Post {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime publishedOn;
}
