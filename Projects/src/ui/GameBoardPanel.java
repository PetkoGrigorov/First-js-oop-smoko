package ui;

import fields.*;
import meta.Position;
import state.GameBoard;
import tools.Tools;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
import java.util.List;

public class GameBoardPanel extends JPanel {

    private GameBoard board;
    boolean isGameOver = false;

    public GameBoardPanel() {


        List<Unit> snakeBody = Snake.getInstance().getBody();
        Food food = Food.getInstance();
        gameBoardPanelInit();


        setFocusable(true);
        requestFocusInWindow();

            addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (isGameOver) {
                        return;
                    }
                    int SnakeHeadHorizontalMove;
                    int SnakeHeadVerticalMove;

                    int keyCode = e.getKeyCode();
                    if (keyCode == KeyEvent.VK_RIGHT) {
                        SnakeHeadHorizontalMove = 1;
                        SnakeHeadVerticalMove = 0;
                        moveSnake(SnakeHeadHorizontalMove, SnakeHeadVerticalMove, food, snakeBody);
                    } else if (keyCode == KeyEvent.VK_LEFT) {
                        SnakeHeadHorizontalMove = -1;
                        SnakeHeadVerticalMove = 0;
                        moveSnake(SnakeHeadHorizontalMove, SnakeHeadVerticalMove, food, snakeBody);
                    } else if (keyCode == KeyEvent.VK_UP) {
                        SnakeHeadVerticalMove = -1;
                        SnakeHeadHorizontalMove = 0;
                        moveSnake(SnakeHeadHorizontalMove, SnakeHeadVerticalMove, food, snakeBody);
                    } else if (keyCode == KeyEvent.VK_DOWN) {
                        SnakeHeadVerticalMove = 1;
                        SnakeHeadHorizontalMove = 0;
                        moveSnake(SnakeHeadHorizontalMove, SnakeHeadVerticalMove, food, snakeBody);
                    }

                    updateUI();
                }
            });
    }

    public void gameBoardPanelInit() {
        this.board = GameBoard.getInstance();
        for (int i = 0; i < board.BOARD_ROWS; i++) {
            for (int j = 0; j < board.BOARD_COLS; j++) {
                board.setBoardTile(null, new Position(i, j));
            }
        }

        List<Unit> snakeBody = Snake.getInstance().getBody();
        snakeBody.removeAll(snakeBody);
        System.out.println("Size:" + snakeBody.size());
        snakeBody.add(new Unit(Tools.getValidRandomPosition()));
        System.out.println("Size:" + snakeBody.size());
        this.board.setBoardTile(snakeBody.get(0));
        board.setBoardTile(Food.getInstance());
        Wall.setWallOnBoard();
    }


    private void moveSnake(int horizontal, int vertical, Food food, List<Unit> snakeBody) {
        Unit snakeHead = snakeBody.get(0);
        Position previousUnitPosition = new Position(snakeHead.getPosition());
        int v = (previousUnitPosition.getRow() + vertical);
        int h = (previousUnitPosition.getCol() + horizontal);
        if (v < 0) {
            v = board.BOARD_ROWS - 1;
        }
        if (v > board.BOARD_ROWS - 1) {
            v = 0;
        }
        if (h < 0) {
            h = board.BOARD_COLS - 1;
        }
        if (h > board.BOARD_COLS - 1) {
            h = 0;
        }
        snakeHead.setPosition(new Position(v, h));
        if ((snakeHead.getPosition().getRow() == food.getPosition().getRow()) && (snakeHead.getPosition().getCol() == food.getPosition().getCol())) {
            Snake.getInstance().snakeGrows(previousUnitPosition);
            board.setBoardTile(snakeBody.get(1), snakeBody.get(1).getPosition());
            food.setPosition(Tools.getValidRandomPosition());
            board.setBoardTile(food, food.getPosition());
        } else if (board.getBoardTile(new Position(v, h)) != null) {
            this.isGameOver = true;
        } else {
            for (int i = 1; i < snakeBody.size(); i++) {
                Position currentPosition = new Position(snakeBody.get(i).getPosition());
                snakeBody.get(i).setPosition(previousUnitPosition);
                previousUnitPosition = new Position(currentPosition);
                board.setBoardTile(snakeBody.get(i), snakeBody.get(i).getPosition());
            }
            board.setBoardTile(null, previousUnitPosition);
        }
        board.setBoardTile(snakeHead, snakeHead.getPosition());
    }

    public void paint(Graphics g) {
        for (int row = 0; row < this.board.BOARD_ROWS; row++) {
            for (int col = 0; col < this.board.BOARD_COLS; col++) {
                render(g, new Position(row, col));
            }
        }
    }

    private void render(Graphics g, Position position) {
        if (GameBoard.getInstance().getBoardTile(position) != null) {
            renderBoardField(g, position);
        } else if (isGameOver) {
            drawEnd(g);
        } else {
            renderTile(g, position);
        }
    }

    private void renderTile(Graphics g, Position position) {
        int x = position.getCol() * this.board.BOARD_TILE_SIDE;
        int y = position.getRow() * this.board.BOARD_TILE_SIDE;
        g.setColor(Color.lightGray);
        g.fillRect(x, y, this.board.BOARD_TILE_SIDE, this.board.BOARD_TILE_SIDE);
//        g.setColor(Color.BLACK);
//        g.drawRect(x, y, this.board.BOARD_TILE_SIDE, this.board.BOARD_TILE_SIDE);
    }

    private void renderBoardField(Graphics g, Position position) {
        int x = (position.getCol() * this.board.BOARD_TILE_SIDE);
        int y = (position.getRow() * this.board.BOARD_TILE_SIDE);
        Color color = board.getBoardTile(position).getTileColor();
        g.setColor(color);
        Position snakePosition = Snake.getInstance().getBody().get(0).getPosition();
        if (snakePosition.getRow() ==  position.getRow() && snakePosition.getCol() == position.getCol()) {
            g.fillOval(x, y, this.board.BOARD_TILE_SIDE, this.board.BOARD_TILE_SIDE);
        } else {
            g.fillRect(x, y, this.board.BOARD_TILE_SIDE, this.board.BOARD_TILE_SIDE);
        }

    }

    private void drawEnd(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 72));
        int x = (int) board.BOARD_TILE_SIDE * (board.BOARD_COLS / 25);
        int y = (int) board.BOARD_TILE_SIDE * (board.BOARD_ROWS / 2);
        g.drawString("Game Over", x, y);
    }
}
