package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogPost extends Post {
    private String author;
    private String[] tags;
}
