package se.choccy.game;

public class Castle extends AbstractMoveableItem {
    public Castle(Position position) {
        super(position, "Castle", "🏰");
    }

    @Override
    public String getDescription() {
        return "Mario 64 castle";
    }
}