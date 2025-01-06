package se.choccy.game;

public class Robot extends AbstractMoveableItem {
    public Robot(Position position) {
        super(position, "Robot", "🤖");
    }

    @Override
    public String toString() {
        return "Robot at " + getPosition();
    }
}
