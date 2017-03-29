package Views;


import Listeners.CanvasMouseAdapter;
import Shapes.RegularPolygon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Created by stefanromanescu on 29/03/17.
 */
public class Canvas extends JPanel {

    private Color canvasColor;
    private Random random;
    private Graphics graphics;
    
    Canvas() {
        random = new Random();
        canvasColor = new Color(59, 114, 231); 
        
        this.setBackground(canvasColor);
        this.addMouseListener(new CanvasMouseAdapter(this));
    }
        
    public void drawShapeAt(int x, int y) {
        int randomColor = random.nextInt(0xFFFFFF);
        int radius = this.getHeight() / 2 - random.nextInt(this.getHeight() / 2 - 1);
        int sides = random.nextInt(10);
        
        graphics = this.getGraphics();
        graphics.setColor(new Color(randomColor));
        graphics.fillPolygon(new RegularPolygon(x, y, radius, sides));
    }
    
    public void drawShapeAt(int x, int y, int sides) {
        int randomColor = random.nextInt(0xFFFFFF);
        int radius = this.getHeight() / 2 - random.nextInt(this.getHeight() / 2 - 1);
        
        graphics = this.getGraphics();
        graphics.setColor(new Color(randomColor));
        graphics.fillPolygon(new RegularPolygon(x, y, radius, sides));
     }
}
