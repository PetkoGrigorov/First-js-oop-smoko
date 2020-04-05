package fields;

import meta.Position;
import state.GameBoard;
import tools.Tools;

import java.awt.*;

public class Wall extends BoardField {

    private final Color tileColor = Color.RED;

    public Wall(Position position) {
        this.position = position;
    }

    @Override
    public Color getTileColor() {
        return this.tileColor;
    }

    public static void setWallOnBoard() {
        GameBoard board = GameBoard.getInstance();
        int n = Tools.getRandomRow();
        for (int i = 0; i < n; i++) {
            Wall wall = new Wall(Tools.getValidRandomPosition());
            board.setBoardTile(wall, wall.getPosition());
        }

    }
}
