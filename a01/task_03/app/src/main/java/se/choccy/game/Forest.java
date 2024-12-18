package se.choccy.game;

import java.util.HashMap;
import java.util.Map;

public class Forest {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

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
        if (items.containsKey(position)) {
            return false; // Cannot place item, position already occupied
        }
        
        // Add the item to the map at the specified position
        items.put(position, items);
        return true; // Successfully added the item
    }
    



}
