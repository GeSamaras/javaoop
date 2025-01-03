package se.choccy.game;

public class Robot extends AbstractMoveableItem {
    public Robot(Position position) {
        super(position, "defaultDescription1", "defaultDescription2");
    }

    @Override
    public String toString() {
        return "Robot at " + getPosition();
    }
}
