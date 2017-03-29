package Views;


import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

/**
 * Created by stefanromanescu on 29/03/17.
 */
public class ControlPanel extends JPanel {

    private static ControlPanel instance;

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

    private ControlPanel() {
        initControlPanelComponents();
        setControlPanelComponents();
    }

    public ControlPanel getInstance() {
        if(instance == null) {
            instance = new ControlPanel();
        }
        return instance;
    }
}
