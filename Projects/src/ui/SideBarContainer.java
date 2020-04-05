package ui;

import javax.swing.*;
import java.awt.*;

public class SideBarContainer extends JPanel {

    public SideBarContainer() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        this.add(new CountPanel());
        this.add(new ButtonsPanel());




    }
}
