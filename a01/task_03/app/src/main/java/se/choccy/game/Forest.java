package se.choccy.game;

import java.util.HashMap;
import java.util.Map;

public class Forest {
    private final int WIDTH = 10;
    private final int HEIGHT = 10;
    private Map<Position, Item> items = new HashMap<>();
    private AbstractMoveableItem player; 
    private AbstractMoveableItem hunter; 
    private AbstractMoveableItem home; 
    private boolean gameOver = false; // Default value, for clarity
    private StringBuilder status = new StringBuilder(); // Initialized directly

    public String getGamePlan() {
        StringBuilder gamePlan = new StringBuilder();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Position pos = new Position(x, y);
                if (player != null && pos.equals(player.getPosition())) {
                    gamePlan.append(player.getGraphic());
                } else if (hunter != null && pos.equals(hunter.getPosition())) {
                    gamePlan.append(hunter.getGraphic());
                } else if (home != null && pos.equals(home.getPosition())) {
                    gamePlan.append(home.getGraphic());
                } else {
                    gamePlan.append(items.containsKey(pos) ? items.get(pos).getGraphic() : "🟩");
                };
            }
            gamePlan.append("\n");
        }
        return gamePlan.toString();
    }


    // prints an empty forest
    public void Forest() {
        /* for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                System.out.print("X"); // for every row, print 10 columns
            }    
            System.out.println(); // and for every 10 colums, make a new row
        }  */   
        System.out.println("Forest has been created!");
    }    

    public void init() {
        items.clear();
        Forest();
        status.setLength(0);
    }    
    
    


    
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

    public boolean tryAddItem(Item item, Position position) {
        if (!items.containsKey(position)) {
            items.put(position, item);
            return true;
        }    
        return false;
    }    


    public void addPlayer(AbstractMoveableItem player) {
        this.player = player;
    }

    public void addHunter(AbstractMoveableItem hunter) {
        this.hunter = hunter;
    }

    public void addHomeItem(AbstractMoveableItem home) {
        this.home = home;
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

    public void movePlayer(Position relative) {
        if (player != null) {
            player.getPosition().move(relative);
            if (player.getPosition().equals(hunter.getPosition())) {
                gameOver = true;
                status.append("Game over! The hunter caught the player.\n");
            } else if (player.getPosition().equals(home.getPosition())) {
                gameOver = true;
                status.append("You won! The player reached home.\n");
            }
        }
    }


    public boolean isGameOver() {
        return gameOver;
    }

    public String getStatus() {
        return status.toString();
    }

}
