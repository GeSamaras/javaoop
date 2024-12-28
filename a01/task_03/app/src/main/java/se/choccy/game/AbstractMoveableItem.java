package se.choccy.game;

public abstract class AbstractMoveableItem extends AbstractItem implements Moveable {
    public AbstractMoveableItem(Position position) {
        super(position);
    }

    @Override
    public void move(Position newPosition) {
        this.position = newPosition;
    }
}
