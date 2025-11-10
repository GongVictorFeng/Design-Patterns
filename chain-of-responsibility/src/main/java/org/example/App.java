package org.example;

import org.example.LeaveApplication.Type;

import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {
        LeaveApplication application = LeaveApplication.getBuilder().withType(Type.Sick)
                                        .from(LocalDate.now()).to(LocalDate.now().plusDays(10))
                                        .build();
        System.out.println(application);
        System.out.println("**************************************************");
        LeaveApprover approver = createChain();
        approver.processLeaveApplication(application);
        System.out.println(application);
    }

    private static LeaveApprover createChain() {
        Director director = new Director(null);
        Manager manager = new Manager(director);
        return new ProjectLead(manager);
    }
}
