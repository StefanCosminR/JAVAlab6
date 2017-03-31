/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 *
 * @author dragos
 */
public class IOPanel extends JPanel {
    
    private static IOPanel instance;
    private ControlPanel controlPanel;
    private MathExpressionInput expression;
    private InterpolationPoints interpolationPoints;
    
    private IOPanel() {
        controlPanel = ControlPanel.getInstance();
        expression = MathExpressionInput.getInstance();
        interpolationPoints = InterpolationPoints.getInstance();
        
        this.setLayout(new BorderLayout());
        this.add(interpolationPoints, BorderLayout.NORTH);
        this.add(expression, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.SOUTH);
    }
    
    public static IOPanel getInstance() {
        if(instance == null) {
            instance = new IOPanel();
        }
        return instance;
    }
    
}
