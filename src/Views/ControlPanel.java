package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stefanromanescu on 29/03/17.
 */
public class ControlPanel extends JPanel {
    private JButton saveButton;
    private JButton loadButton;
    private JButton resetButton;

    private void initControlPanelComponents() {
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        resetButton = new JButton("Reset");
    }

    private void setControlPanelComponents() {
        this.setLayout(new FlowLayout());

        this.add(saveButton);
        this.add(loadButton);
        this.add(resetButton);
    }

    ControlPanel() {
        initControlPanelComponents();
        setControlPanelComponents();
    }
}
