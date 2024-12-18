package se.company.resource;


// starts the class interface 
public class Employee {
    protected String name;
    protected String work;
    protected int salary;

    // this. points back all the references used by other classes
    // back to this class' variables
    public Employee(String name, String work, int salary) {
        this.name = name;
        this.work = work;
        this.salary = salary;
    }

    public String work() {
        return ""; // Default work implementation
    }

    @Override
    public String toString() {
        return "Emp: " + name + " (" + work + ")";
    }
}
