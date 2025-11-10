package org.example;

//A concrete handler
public class Director extends Employee {
    public Director(LeaveApprover successor) {
        super("Director", successor);
    }

    @Override
    public boolean processRequest(LeaveApplication application) {
        if (application.getType() == LeaveApplication.Type.PTO) {
            application.approve(getApproverRole());
            return true;
        }
        return false;
    }
}
