package org.example;

import java.util.ArrayList;

public class Team {
    private final ArrayList<Employee> member = new ArrayList<>();
    public ArrayList<Employee> Team() {
        return member;
    }
    
    // goes in the employee class and adds emp to the
    // arraylist member when called
    public void add(Employee emp) {
        member.add(emp);
    }

    @Override
    public String toString() {
        return "";
    }

    public String work() {
        String employeeWork = "# TEAM is working:\n";
        // gets every employee in the ArrayList, calls their
        // work() method and builds the string to be printed.
        for (Employee emp : member) {
            employeeWork += "  Emp: " + emp.name + " is working on a report in " + emp.work + ".\n";
        }
        return employeeWork;
    }
}
