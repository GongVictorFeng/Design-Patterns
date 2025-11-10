package org.example;

//A concrete handler
public class Manager extends Employee {
    public Manager(LeaveApprover successor) {
        super("Manager", successor);
    }

    @Override
    public boolean processRequest(LeaveApplication application) {
        switch (application.getType()) {
            case Sick:
                application.approve(getApproverRole());
                return true;
            case LOP:
                if (application.getNoOfDays() <= 5) {
                    application.approve(getApproverRole());
                    return true;
                }
        }
        return false;
    }
}
