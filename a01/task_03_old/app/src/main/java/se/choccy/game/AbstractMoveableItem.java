package se.choccy.game;

import java.io.Serializable;

public abstract class AbstractMoveableItem extends AbstractItem implements Serializable {
    protected Position position;    

    public AbstractMoveableItem(Position position, String description, String graphic) {
        super(position, description, graphic);
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "";
    }

    
    public void move(Position newPosition) {
        this.position = newPosition;
    }
}
