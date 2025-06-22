package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// base class - closed for modification
public abstract class Subscriber {
    private Long subscriberId;
    private String address;
    private Long phoneNumber;
    private int baseRate;

    public abstract double calculateBill(); // extension
}
