package se.choccy.game;

import java.util.HashMap;
import java.util.Map;

public class Forest<Item, AbstractMoveableItem> {
    private final int WIDTH = 10;
    private final int HEIGHT = 10;

    private Map<Position, Item> items = new HashMap<>();
    private AbstractMoveableItem player, hunter, home;
    
    private boolean gameOver = false; // Default value, for clarity
    private StringBuilder status = new StringBuilder(); // Initialized directly

    public boolean addItem(Item items, Position position) {
        // Check if the position is within the bounds of the forest grid
        if (position.getX() < 0 || position.getX() >= WIDTH || 
            position.getY() < 0 || position.getY() >= HEIGHT) {
            return false; // Position is out of bounds
        }
        
        // Check if the position is already occupied by another item
        if (items.equals(position)) {
            return false; // Cannot place item, position already occupied
        }
        
        // Add the item to the map at the specified position
        // items.put(position, items);
        return true; // Successfully added the item
    }

    public void Forest() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                System.out.print("X"); // for every row, print 10 columns
            }
            System.out.println(); // and for every 10 colums, make a new row
        }
    }

    public void init() {
        Forest();
    }

    public String getGamePlan() {
        StringBuilder gamePlan = new StringBuilder();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                gamePlan.append("🌲");
            }
            gamePlan.append("\n");
        }
        return gamePlan.toString();
    }
}
