package fields;

import meta.Position;

import java.awt.*;

public abstract class BoardField {
    protected Position position;
    protected Color tileColor;

    public Position getPosition() {
        return this.position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract Color getTileColor();


}
