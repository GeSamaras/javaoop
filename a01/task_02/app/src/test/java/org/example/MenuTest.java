package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuTest {
    Scanner scanner = new Scanner(System.in);
    String choice;
    Team team = new Team();
    
    public static String printMenu() {
        return """
                 -----------------
                | 1) Create a new empty team
                | 2) Add normal employee to team
                | 3) Add John, Jane and little Jr
                | 4) Print out work being done
                | 5) Add super employee to team
                | 6) Add three super employee, with powers, to team
                | 7) Salary report
                | m) Print menu
                | qQ) Quit
                -----------------
                """;
    }

    public String getChoice() {
        System.out.println("Enter your choice");
        return scanner.nextLine();
    }

    public void menuOptions() {
        do { 
            choice = getChoice();
            switch (choice) {
                case "1" -> {
                    Team team = new Team();
                    System.out.println(team);
                }
                case "2" -> addNewNormalEmployee();
                case "3" -> addTemplateMembers();
                case "4" -> printMenu();
                case "5" -> printMenu();
                case "6" -> printMenu();
                case "7" -> printMenu();
                case "m" -> printMenu();
                default -> System.out.println("invalid input");
            }
        } while (!choice.equalsIgnoreCase("q"));
    }

    public void addNewNormalEmployee() {
        System.out.println("Create new NormalEmployee");
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter their work: ");
        String work = scanner.nextLine();
        
        System.out.println("Enter salary: ");
        int salary = Integer.parseInt(scanner.nextLine());
        team.add(new NewEmployee(name, work, salary));
        System.out.println(team);
    }

    public void addTemplateMembers() {
        team.add(new NewEmployee("Jane Doe", "IT", 3000));
        team.add(new NewEmployee("Ligma", "Shoelace", 400000));
        team.add(new NewEmployee("Pizza Maker", "Streamer", 3000000));
        System.out.println(team);
    }

    public void addNewSuper() {
        List<SuperPower> powers = new ArrayList<>();
        team.add(new SuperEmployee("Batman", "IT", (ArrayList<SuperPower>) powers));
    }

    public void createSuperEmployee() {
        System.out.println("Enter Super's name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Super's name: ");
        String work = scanner.nextLine();

        List<SuperPower> powers = new ArrayList<>();
        team.add(new SuperEmployee(name, work, (ArrayList<SuperPower>) powers));
    }

    
}
