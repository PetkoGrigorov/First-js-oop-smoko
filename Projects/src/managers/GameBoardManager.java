package managers;

import ui.ApplicationContainer;

import javax.swing.*;

public class GameBoardManager {

public void init() {
    JFrame windowFrame = new JFrame();
    windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    windowFrame.setSize(1050, 500);
    windowFrame.add(new ApplicationContainer());
    windowFrame.setVisible(true);

}


}
