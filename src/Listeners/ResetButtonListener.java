/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Views.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dragos
 */
public class ResetButtonListener implements ActionListener {

    private Canvas canvas;
    private Color canvasOriginalColor;
    
    public ResetButtonListener() {
        canvas = Canvas.getInstance();
        canvasOriginalColor = new Color(59, 114, 231);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Graphics graphics;
       
       graphics = canvas.getGraphics();
       graphics.setColor(canvasOriginalColor);
       graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
       
       graphics = canvas.getImage().getGraphics();
       graphics.setColor(canvasOriginalColor);
       graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
}
