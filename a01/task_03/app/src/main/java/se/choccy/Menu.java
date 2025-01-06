package se.choccy;

import java.util.Scanner;

import se.choccy.game.FirTree;
import se.choccy.game.Forest;
import se.choccy.game.Item;
import se.choccy.game.Position;
import se.choccy.game.Rock;

public class Menu {
    private final Scanner scanner = new Scanner(System.in, "UTF-8");
    Forest forest = new Forest();
    Item rock = new Rock(null);
    Item tree = new FirTree(null);


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
                case "1" -> {
                    forest.init();
                    System.out.println("Forest created");
                }
                case "2" -> {
                    if (forest == null) {
                        System.out.println("Forest not created yet.");
                    } else {
                        System.out.println(forest.getGamePlan());
                    }
                } 
                case "3" -> {
                    if (forest == null) {
                        System.out.println("Create a forest first!");
                    } else {
                        addItem(scanner, forest);
                    }
                }

                case "0" -> printMenu();
                default -> System.out.println("Invalid choice. Try again.");
            }
            printMenu();
        }
    }

    private void addItem(Scanner scanner, Forest forest) {
        System.out.print("Add FirTree 🌲 (1) or Rock 🪨 (2): Enter your choice: ");
        String itemType = scanner.nextLine();
        System.out.print("Set position x y (separate by space): Enter your choice: ");
        
        
        String[] positionInput = scanner.nextLine().split(" ");
        int x = Integer.parseInt(positionInput[0]);
        int y = Integer.parseInt(positionInput[1]);

        Position position = new Position(x, y);
        Item item = itemType.equals("1") ? new FirTree(position) : new Rock(position);
        if (forest.tryAddItem(item, position)) {
            System.out.printf("Added item to the forest: %s (%d, %d)%n", item, x, y);
        } else {
            System.out.println("Position already occupied!");
        }
    }
}


