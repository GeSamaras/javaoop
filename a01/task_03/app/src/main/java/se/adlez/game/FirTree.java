package se.adlez.game;

import java.io.Serializable;

public class FirTree extends AbstractItem implements Serializable{
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
