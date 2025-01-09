package se.choccy.game;

import java.io.Serializable;

public class Castle extends AbstractMoveableItem implements Serializable {
    public Castle(Position position) {
        super(position, "Castle", "🏰");
    }

    @Override
    public String getDescription() {
        return "Mario 64 castle";
    }
}