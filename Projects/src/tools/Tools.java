package tools;

import fields.BoardField;
import fields.Snake;
import fields.Unit;
import meta.Position;
import state.GameBoard;

import java.util.List;

public class Tools {

    public static Position getValidRandomPosition() {

        int row = getRandomRow();
        int col = getRandomCol();

        while (GameBoard.getInstance().getMatrix()[row][col] != null) {
            row = getRandomRow();
            col = getRandomCol();
        }
        return new Position(row, col);

    }

    public static int getRandomRow() {
        int row = (int) (Math.random()*GameBoard.getInstance().BOARD_ROWS);
        return row;

    }

    public static int getRandomCol() {
        int col = (int) (Math.random()*GameBoard.getInstance().BOARD_COLS);
        return col;
    }

}
