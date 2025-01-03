package se.choccy.game;

import java.util.Map;

public class Forest<Item, AbstractMoveableItem> {
    private final int WIDTH = 10;
    private final int HEIGHT = 10;


    private Map<Position, Item> items;
    private AbstractMoveableItem player, hunter, home;
    
    private boolean gameOver = false; // Default value, for clarity
    private StringBuilder status = new StringBuilder(); // Initialized directly

    public void addItem(Item item, Position position) {
        // Check if the position is within the bounds of the forest grid
        if (position.getX() < 0 || position.getX() >= WIDTH || 
            position.getY() < 0 || position.getY() >= HEIGHT) {
            System.out.println("Position is out of bounds"); // Position is out of bounds
        }
        
        // Check if the position is already occupied by another item
        if (!items.containsKey(position)) {
            // Add the item to the map at the specified position
            items.put(position, item);
        } else {
            System.out.println("Cannot place item!");
        }
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
                Position pos = new Position(x, y);
                Item item = items.get(pos);
                if (item != null){
                    // gamePlan.append(item.getGraphic);  
                } else {
                    gamePlan.append("🟩");
                }
            }
            gamePlan.append("\n");
        }
        return gamePlan.toString();
    }

    // method grabs the "player" instance from abstract
    // checks if current position already has "player"
    // if not, then call .put and add it to the position 
    public void addPlayerItem(AbstractMoveableItem player) {
        if (this.player == null && !items.containsKey(player)) {
            this.player = player;
            //items.put(player.getPosition(), player);
        } else {
            System.out.println("Player cannot be put");
        }
    }


}
