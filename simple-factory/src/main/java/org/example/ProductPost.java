package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPost extends Post {
    private String imageUrl;
    private String name;
}
