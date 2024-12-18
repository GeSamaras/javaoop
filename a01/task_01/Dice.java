
import java.util.Random;

public class Dice {
    private final int sides; // Number of sides on the dice
    private final Random random;
 
    public Dice(int sides) {
        this.sides = sides;
        this.random = new Random(); 
    }
 
    public int roll() {
        return random.nextInt(sides) + 1; // Generate a number between 1 and 'sides'
    }
}
