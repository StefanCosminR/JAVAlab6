package Views;

import Listeners.BuildGraphicInterpolationButtonListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

/**
 * Created by stefanromanescu on 31/03/17.
 */
public class InterpolationPointsInput extends JPanel {
    private static InterpolationPointsInput instance;
    private JLabel coordinatesLabel;
    private JTextField coordinates;
    private JButton buildGraphicButton;

    private InterpolationPointsInput() {
        coordinatesLabel = new JLabel("Points for interpolation :");
        coordinates = new JTextField(50);
        buildGraphicButton = new JButton("Build Graphic");

        this.setLayout(new FlowLayout());
        this.add(coordinatesLabel);
        this.add(coordinates);
        buildGraphicButton.addActionListener(new BuildGraphicInterpolationButtonListener(this));
        this.add(buildGraphicButton);
    }

    public JTextField getCoordinates() {
        return coordinates;
    }

    public static InterpolationPointsInput getInstance() {
        if(instance == null) {
            instance = new InterpolationPointsInput();
        }
        return instance;
    }
}
