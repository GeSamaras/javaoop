package org.example;

public class Employee {
    public String name;
    public String work;
    public int salary;

    public void Employee(String name, String work, int salary) {
        this.name = name;
        this.work = work;
        this.salary = salary;
    }

    public String toString() {
        return "Employee: " + name;
    }

    public String work() {
        return "";
    }
}
