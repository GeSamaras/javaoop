package se.company.resource;


import java.util.ArrayList;
import java.util.List;

public class Team {
    private final List<Employee> members = new ArrayList<>();

    public void addMember(Employee employee) {
        members.add(employee);
    }

    public String work() {
        StringBuilder sb = new StringBuilder("# TEAM is working:\n");
        for (Employee member : members) {
            sb.append("  ").append(member.work()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        if (members.isEmpty()) {
            return "# TEAM:\n (empty team)";
        }
        StringBuilder sb = new StringBuilder("# TEAM:\n");
        for (Employee member : members) {
            sb.append("  ").append(member.toString()).append("\n");
        }
        return sb.toString();
    }
}
