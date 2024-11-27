package org.example.dataprogram;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EmployeeData employeeData = new EmployeeData();

        try {
            // Step 1: Create a new Employee and insert it into the database
            System.out.println("\nCreating a new employee");
            Employee emp1 = new Employee("Kaya", "Skaut", 100000, new Date());
            employeeData.createEmployee(emp1);
            System.out.println("Employee added to the database.");

            // Step 2: Retrieve and display the employee by ID
            System.out.println("\nRetrieving employee by ID");
            Employee fetchedEmployee = employeeData.getEmployeeById(14);
            if (fetchedEmployee != null) {
                System.out.println("Retrieved Employee: " + fetchedEmployee);
            } else {
                System.out.println("No employee found with ID 1.");
            }

            // Step 3: Retrieve and display all employees
            System.out.println("\nRetrieving all employees");
            employeeData.getAllEmployees().forEach(System.out::println);

            // Step 4: Update an employee's details
            System.out.println("\nUpdating employee");
            if (fetchedEmployee != null) {
                fetchedEmployee.setPosition("Senior Manager");
                fetchedEmployee.setSalary(85000);
                employeeData.updateEmployee(fetchedEmployee);
                System.out.println("Updated Employee: " + employeeData.getEmployeeById(fetchedEmployee.getId()));
            }

            // Step 5: Delete the employee from the database
            System.out.println("\nDeleting employee");
            int idToDelete = 14;
            if (employeeData.getEmployeeById(idToDelete) != null) {
                employeeData.deleteEmployee(idToDelete);
                System.out.println("Employee with ID " + idToDelete + " was deleted.");
            } else {
                System.out.println("No employee found with ID " + idToDelete + ".");
            }

// Step 6: Display all employees after deletion
            System.out.println("\nDisplaying all employees after deletion");
            employeeData.getAllEmployees().forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("An error occurred:");
            e.printStackTrace();
        }
    }
}