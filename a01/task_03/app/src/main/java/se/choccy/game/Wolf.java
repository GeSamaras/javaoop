package se.choccy.game;

public class Wolf extends AbstractMoveableItem {
    public Wolf(Position position) {
        super(position, "Wolf", "🐺");
    }

    @Override
    public String toString() {
        return "The Dawg";
    }
}
