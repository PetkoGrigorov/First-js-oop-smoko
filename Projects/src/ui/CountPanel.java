package ui;

import fields.BoardField;
import fields.Snake;
import managers.GameBoardManager;
import state.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CountPanel extends JPanel {

    public CountPanel() {

        Snake snakebody = Snake.getInstance();
        JLabel label = new JLabel("0");
        label.setFont(new Font("Verdana", 1, 45));
        this.add(label);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                int count = 0;
//                while (true) {
//                    label.setText("" + count);
//                    count++;
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

                int n = snakebody.getBody().size();
                label.setText("" + n);
            }
        });

        thread1.start();

    }


}
