package se.choccy.game;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Forest implements Serializable {
    private final int WIDTH = 10;
    private final int HEIGHT = 10;
    private Map<Position, Item> items = new HashMap<>();
    AbstractMoveableItem player = new Robot(new Position(1, 1));
    AbstractMoveableItem hunter = new Wolf(new Position(8, 5));
    AbstractMoveableItem home = new Castle(new Position(3, 3));
    private boolean gameOver = false; // Default value, for clarity
    private StringBuilder status = new StringBuilder(); // Initialized directly

    public String getGamePlan() {
        StringBuilder gamePlan = new StringBuilder();
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
        // spawns a new position for every single loop call
                Position pos = new Position(x, y);
                if (player != null && pos.equals(player.getPosition())) {
                    gamePlan.append(player.getGraphic());
                } else if (hunter != null && pos.equals(hunter.getPosition())) {
                    gamePlan.append(hunter.getGraphic());
                } else if (home != null && pos.equals(home.getPosition())) {
                    gamePlan.append(home.getGraphic());
                } else {
        // unless its one of the player objects, this will draw a
        // green block in the forest
                    gamePlan.append(items.containsKey(pos) ? items.get(pos).getGraphic() : "🟩");
                };
            }
        // starts new row
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
        this.items = new HashMap<>();
        this.status = new StringBuilder();
        this.gameOver = false;
        System.out.println("Forest has been created!");
    }    

    public void init() {
        items.clear();
        Forest();
        status.setLength(0);
    }    
    
    
    
    public void addItem(Item item, Position position) {
        // Check if the position is within the bounds of the forest grid
        // in this case, row 1 col 1, would be "0, 0"
        // and the last possible cell is "9, 9"
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

/* 
    public void addPlayerItem(AbstractMoveableItem player) {
        this.player = player;
        items.put(player.getPosition(), player);
    } */



    public String listItems() {
        StringBuilder list = new StringBuilder();
        items.forEach((pos, item) -> list.append(String.format("(%d, %d) %s%n", pos.getX(), pos.getY(), item)));
        return list.toString();
    }


    // method grabs the "player" instance from abstract
    // checks if current position already has "player"
    // if not, then call .put and add it to the position 
    public void addPlayerItem(AbstractMoveableItem player) {
        if (this.player == null) {
            this.player = player;
            items.put(player.getPosition(), player);
        } else {
            System.out.println("Player cannot be put");
        }
    }

    public void addHunterItem(AbstractMoveableItem hunter) {
        if (hunter == null) {
            this.hunter = hunter;
            items.put(hunter.getPosition(), hunter);
        } else {
            System.out.println("Hunter already in map!");
        }
    }

    public void addHomeItem(AbstractMoveableItem home) {
        if (home == null) {
            this.home = home;
            items.put(home.getPosition(), home);
        } else {
            System.out.println("Home already in map");
        }
    }

    public void addRandomItems() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            addItemRandomly(new FirTree(null));
            addItemRandomly(new Rock(null));
        }
    }

    private void addItemRandomly(Item item) {
        Random random = new Random();
        while (!tryAddItem(item, new Position(random.nextInt(WIDTH), random.nextInt(HEIGHT)))) {
            // Keep trying until an empty position is found
        }
    }

    public void addMoveableItems() {
        tryAddItem(new Robot(new Position(1, 1)), new Position(1, 1));
        tryAddItem(new Wolf(new Position(8, 5)), new Position(8, 5));
        tryAddItem(new Castle(new Position(3, 4)), new Position(3, 4));
    }

    public boolean tryAddItem(Item item, Position position) {
        if (!items.containsKey(position)) {
            items.put(position, item);
            return true;
        }    
        return false;
    }    

    
    public void movePlayer(Position relative) {
        if (gameOver) return;
        /* if (player == null) {
            status.append("Player not found! Add the player to the forest first.\n");
            return;
        } */

        Position playerPos = player.getPosition();
        Position newPos = new Position(playerPos);
        newPos.move(relative);

        // Check if player reaches home
        if (newPos.equals(home.getPosition())) {
            gameOver = true;
            status.append("Player reached home! Game is over!\n");
            System.out.println("Player reached home! Game is over!\n");

            return;
        }

        // Check if position is free
        if (!items.containsKey(newPos)) {
            items.remove(playerPos);
            playerPos.move(relative);
            items.put(playerPos, player);
            status.append("Player moved successfully!\n");
        } else if (items.get(newPos) == hunter) {
            System.out.println("Player walked onto the Wolf and disappeared, argh! Game is over!\n");
            gameOver = true;
        } else {
            System.out.println("Player could not move!\n");
        }

        // Move hunter
        moveHunter();
    }

    private void moveHunter() {
        if (gameOver) return;

        Position hunterPos = hunter.getPosition();
        Position playerPos = player.getPosition();
        Position newHunterPos = new Position(hunterPos);

        // hunter logic gets the player's current position coordinate
        // if x is moved to the right, wolf does so as well
        // same for all other directions
        // literally impossible to win if castle is far enough
        // hunter moves twice a turn in this implementation

        // if (playerPos.getX() > hunterPos.getX()) newHunterPos.move(new Position(1, 0));
        // else if (playerPos.getX() < hunterPos.getX()) newHunterPos.move(new Position(-1, 0));
        if (playerPos.getY() > hunterPos.getY()) newHunterPos.move(new Position(0, 1));
        else if (playerPos.getY() < hunterPos.getY()) newHunterPos.move(new Position(0, -1));

        if (newHunterPos.equals(playerPos)) {
            System.out.println("Hunter caught the player, argh! Game is over!\n");
            gameOver = true;
        } else {
            items.remove(hunterPos);
            hunterPos.move(new Position(newHunterPos.getX() - hunterPos.getX(), newHunterPos.getY() - hunterPos.getY()));
            items.put(hunterPos, hunter);
            status.append("Hunter is coming closer...\n");
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getStatus() {
        return status.toString();
    }

}
