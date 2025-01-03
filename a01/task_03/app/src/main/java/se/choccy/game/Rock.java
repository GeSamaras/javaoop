package se.choccy.game;

public class Rock extends AbstractItem {
    public Rock(Position position) {
        super(position, "Rock", "🪨");
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public String getGraphic() {
        return "🪨";
    }

    public String getDescription() {
        return "Method for rock 🪨";
    }

    @Override
    public String toString() {
        return "Rock 🪨";
    }
}
