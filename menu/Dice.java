import java.util.Random;

public class Dice {
    private int sides;

    public Dice (int sides) {
        this.sides = sides;
    }

    public int roll () {
        Random random = new Random();
        // gets a random number from 0 up to the int specified
        // off by one, so we add 1 for it to not return 0
        return random.nextInt(sides) + 1;
    }

    public String getRoll() {
        int rollValue;
        rollValue = roll();
        return System.out.println(rollValue);
    } 
}
