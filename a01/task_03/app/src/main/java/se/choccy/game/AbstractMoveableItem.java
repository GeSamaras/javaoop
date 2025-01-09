package se.choccy.game;

public abstract class AbstractMoveableItem extends AbstractItem  {
    protected Position position;    

    public AbstractMoveableItem(Position position, String description, String graphic) {
        super(position, description, graphic);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public String toString() {
        return "";
    }

    
    public void move(Position newPosition) {
        this.position = newPosition;
    }
}
