import java.util.Random;

public class Dice {
    private int sides;
    private int lastRoll;

    private String[] diceGraphics = {"⚀", "⚁", "⚂", "⚃", "⚄", "⚅"};

    public Dice (int sides) {
        this.sides = sides;
        this.lastRoll = 1;
    }

    public int roll () {
        Random random = new Random();
        lastRoll = random.nextInt(sides) + 1;
        return lastRoll;
    }

    @Override
    public String toString() {
        //return "[" + lastRoll + "]";
        return diceGraphics[lastRoll - 1];
    }

    public int getValue() {
        return lastRoll;
    }
}
