/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Views.Canvas;
import Views.MathExpressionInput;
import net.objecthunter.exp4j.Expression;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dragos
 */
public class BuildGraphicButtonListener implements ActionListener {

    private Canvas canvas;
    private MathExpressionInput expressionInput;
    private String expression;
    private Graphics2D canvasGraphics;
    private Graphics2D canvasImageGraphics; 
    private Expression exp;
    private final int SCALE = 20;
    private final int FUNCTION_TEST_COUNT = 1000;
    private double xValues[];
    private double yValues[];
    
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
