import fields.Food;
import fields.Snake;
import fields.Unit;
import managers.GameBoardManager;
import meta.Position;
import state.GameBoard;
import ui.GameBoardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.Panel;
import java.util.List;

public class Application extends JPanel {
    public static String[][] arr = new String[10][10];

    public static void main(String[] args) throws InterruptedException {

            new GameBoardManager().init();




    }



}
