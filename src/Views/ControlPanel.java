package Views;


import Listeners.LoadButtonListener;
import Listeners.ResetButtonListener;
import Listeners.SaveButtonListener;
import Listeners.SvgSaveButtonListener;
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
    private JButton svgSaveButton;

    private void initControlPanelComponents() {
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        resetButton = new JButton("Reset");
        svgSaveButton = new JButton("SVG Save");
    }

    private void setControlPanelComponents() {
        this.setLayout(new FlowLayout());

        saveButton.addActionListener(new SaveButtonListener());
        this.add(saveButton);
        loadButton.addActionListener(new LoadButtonListener());
        this.add(loadButton);
        resetButton.addActionListener(new ResetButtonListener());
        this.add(resetButton);
        svgSaveButton.addActionListener(new SvgSaveButtonListener());
        this.add(svgSaveButton);
    }

    private ControlPanel() {
        initControlPanelComponents();
        setControlPanelComponents();
    }

    public static ControlPanel getInstance() {
        if(instance == null) {
            instance = new ControlPanel();
        }
        return instance;
    }
}
