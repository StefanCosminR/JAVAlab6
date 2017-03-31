/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Views.Canvas;
import Views.MathExpressionInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dragos
 */
public class BuildGraphicButtonListener implements ActionListener {

    private Canvas canvas;
    private MathExpressionInput expressionInput;
    
    public BuildGraphicButtonListener(MathExpressionInput mathExpressionInput) {
        canvas = Canvas.getInstance();
        this.expressionInput = mathExpressionInput;
    }
        

    
    @Override
    public void actionPerformed(ActionEvent e) {
        String expression = expressionInput.getExpression().getText();
        canvas.drawFunctionGraph(expression);
    }
    
}
