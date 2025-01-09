package se.choccy;

import java.util.Scanner;

import se.choccy.game.AbstractMoveableItem;
import se.choccy.game.FirTree;
import se.choccy.game.Forest;
import se.choccy.game.ForestToFile;
import se.choccy.game.ForestToJson;
import se.choccy.game.Item;
import se.choccy.game.Position;
import se.choccy.game.Rock;

public class Menu {
    private final Scanner scanner = new Scanner(System.in, "UTF-8");
    Forest forest = new Forest();
    Item rock = new Rock(null);
    Item tree = new FirTree(null);
    AbstractMoveableItem player;
    AbstractMoveableItem hunter;
    AbstractMoveableItem home;


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
            | 8) Save game to file
            | 9) Load game from file
            | p) Print game as JSON
            | s) save game as JSON 
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

                case "4" -> {
                if (forest == null) {
                    System.out.println("Create a forest first!");
                } else {
                    System.out.println(forest.listItems());
                }
                break;
                }
                case "5" -> {
                if (forest == null) {
                    System.out.println("Create a forest first!");
                } else {
                    forest.addRandomItems();
                    System.out.println("Added 5 trees and 5 rocks randomly.");
                }
                break;
                }
                case "6" -> {
                if (forest == null) {
                    System.out.println("Create a forest first!");
                } else {
                    // forest.addMoveableItems();
                    forest.addPlayerItem(player);
                    forest.addHunterItem(hunter);
                    forest.addHomeItem(home);
                    System.out.println("Added player, hunter, and the home.");
                }
                break;
                }
                case "7" -> {
                    playGame();
                    break;
                }
                case "8" -> {
                    saveGame();
                    break;
                }
                case "9" -> {
                    loadGame();
                    break;
                }
                case "p" -> {
                    printAsJson();
                    break;
                }
                case "s" -> {
                    saveAsJson();
                    break;
                }
                case "q" -> {
                    System.out.println("Byee!");
                    break;
                }
                case "0" -> printMenu();
                default -> System.out.println("Invalid choice. Try again.");
            }
            printMenu();
        }
    }


    // option 3, starts a scanner and uses the choice to call
    // which item should be printed in the map.
    private void addItem(Scanner scanner, Forest forest) {
        System.out.print("Add FirTree 🌲 (1) or Rock 🪨 (2): Enter your choice: ");
        String itemType = scanner.nextLine();
        System.out.print("Set position x y (separate by space): Enter your choice: ");
        
        
        // x and y will be sent as arguments to the Position class
        // first they're parsed into integers from String
        // The array 
        String[] positionInput = scanner.nextLine().split(" ");
        int x = Integer.parseInt(positionInput[0]);
        int y = Integer.parseInt(positionInput[1]);

        // instantiates a new Position method, and the Item is decided
        // in a ternary operator. If its "1" then its tree, otherwise
        // its rock.
        Position position = new Position(x, y);
        Item item = itemType.equals("1") ? new FirTree(position) : new Rock(position);
        
        // call "tryAddItem", passing these new instances of item and
        // position as the arguments. Then the method checks if its
        // out of bounds, already occupied, if not then it adds the item.
        if (forest.tryAddItem(item, position)) {
            System.out.printf("Added item to the forest: %s (%d, %d)%n", item, x, y);
        } else {
            System.out.println("Position already occupied!");
        }
    }

    

    private void playGame() {
        String choice;
        do {
            System.out.println(forest.getGamePlan());
            System.out.println(forest.getStatus());
            System.out.println("Move player left=a, right=d, up=w, down=s, quit=q.");
            choice = scanner.nextLine();
            switch (choice) {
                // left, right, up and down
                case "a": forest.movePlayer(new Position(0, -1)); break;
                case "d": forest.movePlayer(new Position(0, 1)); break;
                case "w": forest.movePlayer(new Position(-1, 0)); break;
                case "s": forest.movePlayer(new Position(1, 0)); break;
                case "q": System.out.println("Exiting game."); break;
                default: System.out.println("Invalid move! Try again.");
            }
        } while (!choice.equals("q") && !forest.isGameOver());
    }

    private void saveGame() {
        ForestToFile.save(forest, "forest.ser");
    }

    private void loadGame() {
        Forest loaded = ForestToFile.load("forest.ser");
        if (loaded != null) forest = loaded;
    }
    
    private void saveAsJson() {
        ForestToJson.saveAsJson(forest, "forest.json");
    }

    private void printAsJson() {
        System.out.println(ForestToJson.toJson(forest));
    }

}
