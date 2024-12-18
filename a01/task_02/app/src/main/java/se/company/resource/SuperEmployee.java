package se.company.resource;


import java.util.List;

public class SuperEmployee extends Employee {
    private final List<SuperPower> powers;

    public SuperEmployee(String name, String work, List<SuperPower> powers) {
        super(name, work, 0); // Super employees work for free
        this.powers = powers;
    }

    @Override
    public String work() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sup: ").append(name).append(" is saving the day in ").append(work).append(".\n");
        for (SuperPower power : powers) {
            sb.append("    Using superpower: ").append(power.getName())
              .append(" - ").append(power.getDescription()).append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "Sup: " + name + " (" + work + ") - " + powers;
    }
}
