package Views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

/**
 * Created by stefanromanescu on 31/03/17.
 */
public class InterpolationPoints extends JPanel {
    private static InterpolationPoints instance;
    private JLabel coordinatesLabel;
    private JTextField coordinates;
    private JButton buildGraphicButton;

    private InterpolationPoints() {
        coordinatesLabel = new JLabel("Points for interpolation :");
        coordinates = new JTextField(50);
        buildGraphicButton = new JButton("Build Graphic");

        this.setLayout(new FlowLayout());
        this.add(coordinatesLabel);
        this.add(coordinates);
        this.add(buildGraphicButton);
    }

    public static InterpolationPoints getInstance() {
        if(instance == null) {
            instance = new InterpolationPoints();
        }
        return instance;
    }
}
