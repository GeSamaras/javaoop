package se.company.resource;


public class NormalEmployee extends Employee {
    public NormalEmployee(String name, String work, int salary) {
        super(name, work, salary);
    }
    @Override
    public String work() {
        return "Emp: " + name + " is working on a report in " + work + ".";
    }
}
