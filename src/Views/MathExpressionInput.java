/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dragos
 */
public class MathExpressionInput extends JPanel {
    
    private static MathExpressionInput instance;
    private JLabel expressionLabel;
    private JTextField expression;
    private JButton buildGraphicButton;
    
    private MathExpressionInput() {
        expressionLabel = new JLabel("Mathematical Expression :");
        expression = new JTextField(50);
        buildGraphicButton = new JButton("Build Graphic");
        
        this.add(expressionLabel);
        this.setLayout(new FlowLayout());
        this.add(expression);
        this.add(buildGraphicButton);
    }
    
    public JTextField getExpression() {
        return expression;
    }
    
    public static MathExpressionInput getInstance() {
        if(instance == null) {
            instance = new MathExpressionInput();
        }
        return instance;
    }
}
