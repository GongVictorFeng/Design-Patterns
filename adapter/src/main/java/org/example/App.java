package org.example;

public class App 
{
    public static void main( String[] args )
    {
        //Using Class/Two-way adapter
        EmployeeClassAdapter adapter = new EmployeeClassAdapter();
        populateEmployeeData(adapter);

        BusinessCardDesigner designer = new BusinessCardDesigner();
        String card = designer.designCard(adapter);
        System.out.println(card);

        System.out.println("*********************************************************************");
        //Using Object Adapter
        Employee employee = new Employee();
        populateEmployeeData(employee);
        EmployeeObjectAdapter ObjectAdapter = new EmployeeObjectAdapter(employee);
        System.out.println(designer.designCard(ObjectAdapter));
    }

    private static void populateEmployeeData(Employee employee) {
        employee.setFullName("Elliot Anderson");
        employee.setJobTitle("Security Engineer");
        employee.setOfficeLocation("AllSafe Cybersecurity, New York City, New York");
    }
}
