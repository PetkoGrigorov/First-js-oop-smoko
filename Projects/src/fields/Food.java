package fields;

import meta.Position;
import state.GameBoard;
import tools.Tools;

import java.awt.*;

public class Food extends BoardField {

    private final Color tileColor = Color.GREEN;
    private static Food instance;

    private Food(Position position) {
        this.position = position;
    }

    public static Food getInstance() {
        if (instance == null) {
            instance = new Food(Tools.getValidRandomPosition());
        }
        return instance;
    }


    @Override
    public Color getTileColor() {
        return this.tileColor;
    }

    public static void setFoodOnBoard() {
        GameBoard board = GameBoard.getInstance();
            board.setBoardTile(instance);

    }

}
