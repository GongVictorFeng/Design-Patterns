package org.example;

public class EmployeeObjectAdapter implements Customer {

    private final Employee adaptee;

    public EmployeeObjectAdapter(Employee employee) {
        adaptee = employee;
    }

    @Override
    public String getName() {
        return adaptee.getFullName();
    }

    @Override
    public String getDesignation() {
        return adaptee.getJobTitle();
    }

    @Override
    public String getAddress() {
        return adaptee.getOfficeLocation();
    }
}
