package org.example;

//Abstract handler
public abstract class Employee implements LeaveApprover {

    private final String role;
    private final LeaveApprover successor;

    public Employee(String role, LeaveApprover successor) {
        this.role = role;
        this.successor = successor;
    }

    public abstract boolean processRequest(LeaveApplication application);

    @Override
    public void processLeaveApplication(LeaveApplication application) {
        if (!processRequest(application) && successor != null) {
            successor.processLeaveApplication(application);
        }
    }

    @Override
    public String getApproverRole() {
        return role;
    }
}
