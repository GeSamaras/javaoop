package se.company.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import se.company.resource.NormalEmployee;
import se.company.resource.SuperEmployee;
import se.company.resource.SuperPower;
import se.company.resource.Team;


public class Menu {
    private Team team = new Team();
    private final Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("-----------------");
        System.out.println("| 1) Create a new empty team");
        System.out.println("| 2) Add normal employee to team");
        System.out.println("| 3) Add John, Jane and little Jr");
        System.out.println("| 4) Print out work being done");
        System.out.println("| 5) Add super employee to team");
        System.out.println("| 6) Add three super employee, with powers, to team");
        System.out.println("| 7) Salary report(not implemented)");
        System.out.println("| m) Print menu");
        System.out.println("| q) Quit");
        System.out.println("-----------------");
    }

    public void run() {
        printMenu();
        String choice;
        // starts choice prompt with the scanner inside
        while (!(choice = scanner.nextLine().trim()).equalsIgnoreCase("q")) {
            switch (choice) {
                case "1" -> {
                    team = new Team();
                    System.out.println(team);
                }
                case "2" -> addNormalEmployee();
                case "3" -> addPredefinedEmployees();
                case "4" -> System.out.println(team.work());
                case "5" -> addSuperEmployee();
                case "6" -> addThreeSuperEmployees();
                case "m" -> printMenu();
                default -> System.out.println("Invalid choice. Try again.");
            }
            printMenu();
        }
    }

    private void addNormalEmployee() {
        System.out.println("# Create new NormalEmployee");
        System.out.print(" Enter name: ");
        String name = scanner.nextLine();
        System.out.print(" Enter work: ");
        String work = scanner.nextLine();
        System.out.print(" Enter salary: ");
        int salary = Integer.parseInt(scanner.nextLine());
        team.addMember(new NormalEmployee(name, work, salary));
        System.out.println(team);
    }

    private void addPredefinedEmployees() {
        team.addMember(new NormalEmployee("John Doe", "IT", 30000));
        team.addMember(new NormalEmployee("Jane Doe", "Economic", 30000));
        team.addMember(new NormalEmployee("Little Jr", "Trainee", 10));
        System.out.println(team);
    }

    private void addSuperEmployee() {
        System.out.println("# Create new SuperEmployee");
        System.out.print(" Enter name: ");
        String name = scanner.nextLine();
        System.out.print(" Enter work: ");
        String work = scanner.nextLine();
        List<SuperPower> powers = new ArrayList<>();
        team.addMember(new SuperEmployee(name, work, powers));
        System.out.println(team);
    }

    private void addThreeSuperEmployees() {
        List<SuperPower> powers1 = List.of(new SuperPower("Flight", "Fly at supersonic speeds"),
            new SuperPower("Strength", "Really strong to lift a house"));
        List<SuperPower> powers2 = List.of(new SuperPower("Invisibility", "Become invisible to the naked eye"),
            new SuperPower("Strength", "Really strong to lift a house"));
        List<SuperPower> powers3 = List.of(new SuperPower("Strength", "He angry"),
            new SuperPower("Mega Strength", "Really strong, able to lift a planet"));
        team.addMember(new SuperEmployee("Clark Kent", "IT", powers1));
        team.addMember(new SuperEmployee("Jessica Jones", "Investigations", powers2));
        team.addMember(new SuperEmployee("Hulk", "Youtuber", powers3));
        System.out.println(team);
    }
}