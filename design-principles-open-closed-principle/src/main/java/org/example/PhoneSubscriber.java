package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PhoneSubscriber {
    private Long subscriberId;
    private String address;
    private Long phoneNumber;
    private int baseRate;

    //For demonstration purpose
    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(subscriberId);
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return (double) (totalDuration * baseRate) /100;
    }
}
