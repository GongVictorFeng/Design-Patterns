package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//Class used to construct the product
@Getter
@Setter
public class User {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Address address;
}
