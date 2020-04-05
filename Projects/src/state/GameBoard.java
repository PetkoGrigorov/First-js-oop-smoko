package state;

import fields.BoardField;
import fields.Snake;
import meta.Position;

public class GameBoard {
    private static GameBoard instance;
    public final int BOARD_TILE_SIDE       = 20;
    public final int BOARD_ROWS = 20;
    public final int BOARD_COLS = 20;

    private BoardField[][] matrix;

    private GameBoard() {
        this.initGameBoard();
    }

    public static GameBoard getInstance() {
        if (instance == null) {
            instance = new GameBoard();
        }
        return instance;
    }

    private void initGameBoard() {
        this.matrix = new BoardField[BOARD_ROWS][BOARD_COLS];
    }

    public void setBoardTile(BoardField e, Position position) {
        this.matrix[position.getRow()][position.getCol()] = e;
    }

    public void setBoardTile(BoardField e) {
        this.matrix[e.getPosition().getRow()][e.getPosition().getCol()] = e;
    }


    public BoardField getBoardTile(Position position) {
        return this.matrix[position.getRow()][position.getCol()];
    }

    public void clearBoardTile(Position position) {
        this.matrix[position.getRow()][position.getCol()] = null;
    }

    public BoardField[][] getMatrix() {
        return this.matrix;
    }





}
