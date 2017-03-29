/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Views.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dragos
 */
public class ResetButtonListener implements ActionListener {

    private Canvas canvas;

    public ResetButtonListener() {
        canvas = Canvas.getInstance();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       canvas.getGraphics().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
    
}
