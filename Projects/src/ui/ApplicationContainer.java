package ui;

import javax.swing.*;

public class ApplicationContainer extends JPanel {

    public ApplicationContainer() {

        BoxLayout applicationBoxLayout      = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(applicationBoxLayout);

        GameBoardPanel gamePanel = new GameBoardPanel();
        SideBarContainer sideBarContainer = new SideBarContainer();

        this.add(gamePanel);
        this.add(sideBarContainer);
    }

}
