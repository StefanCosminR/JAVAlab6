/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Views.Canvas;
import Views.MathExpressionInput;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

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
    private final int SCALE = 5;
    private final int FUNCTION_TEST_COUNT = 1000;
    private double xValues[];
    private double yValues[];
    
    public BuildGraphicButtonListener(MathExpressionInput expressionInput) {
        canvas = Canvas.getInstance();
        this.expressionInput = expressionInput;
        xValues = new double[FUNCTION_TEST_COUNT];
        yValues = new double[FUNCTION_TEST_COUNT];
    }
    
    private void drawAxis(Graphics2D g) {
        //draw OY axis
        g.drawLine(canvas.getWidth() / 2, 0, canvas.getWidth() / 2, canvas.getWidth());
        //draw OX axis
        g.drawLine(0, canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight() / 2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int test;
        double xValue, yValue;

        expression = expressionInput.getExpression().getText();
        canvasGraphics = (Graphics2D)canvas.getGraphics();
        canvasImageGraphics = canvas.getImage().createGraphics();
        
        try {
            exp = new ExpressionBuilder(expression).variable("x").build();

            drawAxis(canvasGraphics);
            drawAxis(canvasImageGraphics);
            canvasGraphics.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
            canvasImageGraphics.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);

            xValue = yValue = -(canvas.getHeight() / 2 / SCALE);
            for(test = 0; test < FUNCTION_TEST_COUNT; ++test) {
                xValues[test] = xValue;
                xValue += 1.0 / SCALE;
                
                exp.setVariable("x", yValue);
                yValues[test] = exp.evaluate();
                yValue += 1.0 / SCALE;
                
                xValues[test] *= SCALE;
                yValues[test] *= SCALE;
            }
            
            for(test = 0; test < FUNCTION_TEST_COUNT - 1; ++test) {
                canvasGraphics.drawLine((int)xValues[test], (int)yValues[test], (int)xValues[test + 1], (int)yValues[test + 1]);
                canvasImageGraphics.drawLine((int)xValues[test], (int)yValues[test], (int)xValues[test + 1], (int)yValues[test + 1]);
            }
        }
        catch (Exception ex) {
            expressionInput.getExpression().setText(ex.getMessage());
        }
    }
    
}
