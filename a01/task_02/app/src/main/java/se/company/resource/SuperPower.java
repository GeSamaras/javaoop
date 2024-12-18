package se.company.resource;


public class SuperPower {
    private final String name;
    private final String description;

    public SuperPower(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }
}
