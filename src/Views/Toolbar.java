package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stefanromanescu on 29/03/17.
 */
public class Toolbar extends JPanel {
    private JButton drawButton;
    private SpinnerModel sidesModel;
    private SpinnerModel shapesModel;
    private SpinnerModel strokeModel;
    private JSpinner sidesNumber;
    private JSpinner shapesNumber;
    private JSpinner strokeNumber;
    private JComponent sidesEditor;
    private JComponent shapesEditor;
    private JComponent strokeEditor;

    private void initToolbarComponents() {
        drawButton = new JButton("Draw");

        sidesModel = new SpinnerNumberModel(0, 0, 10, .1);
        shapesModel = new SpinnerNumberModel(0, 0, 10, .1);
        strokeModel = new SpinnerNumberModel(0, 0, 10, .1);

        sidesNumber = new JSpinner(sidesModel);
        shapesNumber = new JSpinner(shapesModel);
        strokeNumber = new JSpinner(strokeModel);

        sidesEditor = new JSpinner.NumberEditor(sidesNumber, "#,##0.###");
        shapesEditor = new JSpinner.NumberEditor(shapesNumber, "#,##0.###");
        strokeEditor = new JSpinner.NumberEditor(strokeNumber, "#,##0.###");

        sidesNumber.setEditor(sidesEditor);
        shapesNumber.setEditor(shapesEditor);
        strokeNumber.setEditor(strokeEditor);

    }

    private void setToolbarComponents() {
        this.setLayout(new FlowLayout());

        this.add(sidesNumber);
        this.add(shapesNumber);
        this.add(strokeNumber);
        this.add(drawButton);
    }

    Toolbar() {
        initToolbarComponents();
        setToolbarComponents();
    }
}
