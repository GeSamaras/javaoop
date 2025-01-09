package se.choccy.game;

import java.io.Serializable;


public abstract class AbstractItem implements Item, Serializable {
    protected Position position;
    protected String description;
    protected String graphic;

    public AbstractItem(Position position, String description, String graphic) {
        this.position = position;
        this.description = description;
        this.graphic = graphic;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getGraphic() {
        return graphic;
    }

    @Override
    public String toString() {
        return description + " " + graphic;
    }
}
