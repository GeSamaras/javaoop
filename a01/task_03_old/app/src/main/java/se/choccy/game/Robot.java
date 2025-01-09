package se.choccy.game;

import java.io.Serializable;

public class Robot extends AbstractMoveableItem implements Serializable {
    public Robot(Position position) {
        super(position, "Robot", "🤖");
    }

    @Override
    public String toString() {
        return "Robot at " + getPosition();
    }
}
