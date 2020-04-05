package fields;

import meta.Position;

import java.awt.*;

public class Unit extends BoardField {

    private final Color tileColor = Color.BLUE;

    public Unit(Position position) {
        this.position = position;
    }

    @Override
    public Color getTileColor() {
        return this.tileColor;
    }

}
