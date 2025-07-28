package org.example;

import lombok.Getter;

import java.time.Duration;

//Unshared concrete flyweight
@Getter
public class UserBannedErrorMessage implements ErrorMessage {
    //All states are defined here
    private final String caseId;

    private final String remarks;

    private final Duration banDuration;

    private String msg;

    public UserBannedErrorMessage(String caseId) {
        //load case info from DB
        this.caseId = caseId;
        remarks = "You violated terms of use.";
        banDuration = Duration.ofDays(2);
        msg = "You are BANNED. Sorry. \nMore information: \n";
        msg += this.caseId + "\n";
        msg += remarks + "\n";
        msg += "Banned For:" + banDuration.toHours() + " Hours";
    }

    @Override
    public String getText(String code) {
        return msg;
    }
}
