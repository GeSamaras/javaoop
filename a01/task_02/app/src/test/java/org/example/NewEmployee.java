package org.example;

public class NewEmployee extends Employee {
    // have to be set as public so Menu can use them.
    public String name;
    public String work;
    public int salary;

    public NewEmployee(String name, String work, int salary) {
        this.name = name;
        this.work = work;
        this.salary = salary;
    }

    @Override
    public String work() {
        return "Employee: " + name + "is working on " + work;
    }
}
