/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Views.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author dragos
 */
public class CanvasMouseAdapter extends MouseAdapter {
    
    private Canvas canvas;
    
    public CanvasMouseAdapter(Canvas canvas) {
        this.canvas = canvas;
    }
    
    public void mouseClicked(MouseEvent e) {
        canvas.drawShapeAt(e.getX(), e.getY());
    }
}
