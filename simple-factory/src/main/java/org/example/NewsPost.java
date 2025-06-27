package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsPost extends Post {
    private String headline;
    private String newsTime;
}
