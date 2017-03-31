/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author dragos
 */
public class IOPanel extends JPanel {
    
    private static IOPanel instance;
    private ControlPanel controlPanel;
    private MathExpressionInput expression;
    
    private IOPanel() {
        controlPanel = ControlPanel.getInstance();
        expression = MathExpressionInput.getInstance();
        
        this.setLayout(new BorderLayout());
        this.add(expression, BorderLayout.NORTH);
        this.add(controlPanel, BorderLayout.SOUTH);
    }
    
    public static IOPanel getInstance() {
        if(instance == null) {
            instance = new IOPanel();
        }
        return instance;
    }
    
}
