package fields;

import meta.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake extends BoardField {

   private static Snake instance;
    private List<Unit> body;

    private Snake() {
        this.body = new ArrayList<Unit>() {
        };

    }

    public static Snake getInstance() {
        if (instance == null) {
            instance = new Snake();
        }
        return instance;
    }

    public List<Unit> getBody() {
        return this.body;
    }

    public void snakeGrows(Position position) {
        this.body.add(1, new Unit(position));

    }

    @Override
    public Color getTileColor() {
        return null;
    }
}
