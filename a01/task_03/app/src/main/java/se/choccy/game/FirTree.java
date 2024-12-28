package se.choccy.game;

public class FirTree extends AbstractItem {
    private Position position;

    public FirTree(Position position) {
        super(position, "FirTree", "🌲");
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public String toString() {
        return "FirTree🎄";
    }
}
