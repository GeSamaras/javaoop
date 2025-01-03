package se.choccy.game;

public class FirTree extends AbstractItem {
    private final Position treePosition;

    public FirTree(Position position) {
        super(position, "FirTree", "🌲");
        this.treePosition = position;
    }

    @Override
    public Position getPosition() {
        return treePosition;
    }

    @Override
    public String toString() {
        return "FirTree🎄";
    }
}
