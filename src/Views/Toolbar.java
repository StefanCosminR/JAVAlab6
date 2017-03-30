package Views;


import Listeners.DrawButtonListener;

import javax.swing.*;
import java.awt.FlowLayout;

/**
 * Created by stefanromanescu on 29/03/17.
 */
public class Toolbar extends JPanel {

    private static Toolbar instance;

    private JButton drawButton;
    private JSpinner sidesNumber;
    private JSpinner shapesNumber;
    private JSpinner strokeNumber;
    private JLabel sidesModelLabel;
    private JLabel shapeModelLabel;
    private JLabel strokeModelLabel;

    private void initToolbarComponents() {
        drawButton = new JButton("Draw");

        SpinnerModel sidesModel = new SpinnerNumberModel(0, 0, 10, 1);
        SpinnerModel shapesModel = new SpinnerNumberModel(0, 0, 10, 1);
        SpinnerModel strokeModel = new SpinnerNumberModel(0, 0, 10, .1);

        sidesNumber = new JSpinner(sidesModel);
        shapesNumber = new JSpinner(shapesModel);
        strokeNumber = new JSpinner(strokeModel);

        JComponent sidesEditor = new JSpinner.NumberEditor(sidesNumber, "#,##0.###");
        JComponent shapesEditor = new JSpinner.NumberEditor(shapesNumber, "#,##0.###");
        JComponent strokeEditor = new JSpinner.NumberEditor(strokeNumber, "#,##0.###");

        sidesNumber.setEditor(sidesEditor);
        shapesNumber.setEditor(shapesEditor);
        strokeNumber.setEditor(strokeEditor);
        
        sidesModelLabel = new JLabel("Sides");
        shapeModelLabel = new JLabel("Shapes");
        strokeModelLabel = new JLabel("Stroke");
    }

    private void setToolbarComponents() {
        this.setLayout(new FlowLayout());

        this.add(sidesModelLabel);
        this.add(sidesNumber);
        this.add(shapeModelLabel);
        this.add(shapesNumber);
        this.add(strokeModelLabel);
        this.add(strokeNumber);
        drawButton.addActionListener(new DrawButtonListener(this));
        this.add(drawButton);
    }

    private Toolbar() {
        initToolbarComponents();
        setToolbarComponents();
    }

    public static Toolbar getInstance() {
        if(instance == null) {
            instance = new Toolbar();
        }
        return instance;
    }

    public Integer getSidesNumber() {
        return (Integer) this.sidesNumber.getValue();
    }

    public Integer getShapesNumber() {
        return (Integer) this.shapesNumber.getValue();
    }

    public Double getStrokeNumber() {
        return (Double) this.strokeNumber.getValue();
    }
}
