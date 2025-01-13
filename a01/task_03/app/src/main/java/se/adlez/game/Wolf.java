package se.adlez.game;

import java.io.Serializable;

public class Wolf extends AbstractMoveableItem implements Serializable {
    public Wolf(Position position) {
        super(position, "Wolf", "🐺");
    }

    @Override
    public String toString() {
        return "The Dawg";
    }
}
