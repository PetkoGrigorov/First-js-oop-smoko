package ui;

import javax.swing.*;

public class ButtonsPanel extends JPanel{

    public ButtonsPanel() {
        JButton playButton = new JButton("Play");
        JButton restartButton = new JButton("Restart");
        JButton pauseButton = new JButton("Pause");
        this.add(playButton);
        this.add(restartButton);
        this.add(pauseButton);



    }
}
