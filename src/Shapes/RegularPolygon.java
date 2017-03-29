/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import java.awt.Polygon;

/**
 *
 * @author dragos
 */
public class RegularPolygon extends Polygon {

    public RegularPolygon(int xOrigin, int yOrigin, int radius, int sides) {
        double x, y;
        double alpha = 2 * Math.PI / sides;
        
        for(int i = 0; i < sides; ++i) {
            x = xOrigin + radius * Math.cos(alpha * i);
            y = yOrigin + radius * Math.sin(alpha * i);
            this.addPoint((int) x, (int) y);
        }
    }
    
}
