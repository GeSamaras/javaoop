package se.choccy;

import java.util.Scanner;

import se.choccy.game.Forest;

public class Menu {
    private final Scanner scanner = new Scanner(System.in, "UTF-8");
    Forest forest = new Forest<>();


    public void printMenu() {
        System.out.println("""
                -----------------
                | 1) Create an empty forest
                | 2) Print the forest
                | 3) Add items (tree, rock) to the forest
                | 4) List all items in the forest
                | 5) Add 5 trees and 5 stones to the forest
                | 6) Add player, hunter and the home
                | 7) Play game
                | m) Print menu
                | qQ) Quit
                -----------------""");
    }

    public void run() {
        printMenu();
        System.out.println("Enter your choice: ");
        String choice;
        // starts choice prompt with the scanner in one line
        while (!(choice = scanner.nextLine().trim()).equalsIgnoreCase("q")) {
            switch (choice) {
                case "1" -> forest.init();
                case "2" -> System.out.println(forest.getGamePlan());
                case "0" -> printMenu();
                default -> System.out.println("Invalid choice. Try again.");
            }
            printMenu();
        }
    }
}


