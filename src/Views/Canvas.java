package Views;


import Listeners.CanvasMouseAdapter;
import Shapes.RegularPolygon;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by stefanromanescu on 29/03/17.
 */
public class Canvas extends JPanel {

    private static Canvas canvas;
    private BufferedImage image;
    private Color canvasColor;
    private Random random;
    
    private Canvas() {
        random = new Random();
        canvasColor = new Color(59, 114, 231);
        image = new BufferedImage(1000, 730, BufferedImage.TYPE_INT_ARGB);
        
        this.setPreferredSize(new Dimension(1000, 730));
        this.setBackground(canvasColor);
        this.addMouseListener(new CanvasMouseAdapter());        
    }
        
    public static Canvas getInstance() {
        if(canvas == null) {
            canvas = new Canvas();
        }
        return canvas;
    }
    
    private void drawPolygon(Graphics g, Color color, RegularPolygon polygon) {
        g.setColor(color);
        g.fillPolygon(polygon);
    }
    
    public void drawShapeAt(int x, int y) {
        int randomColor = random.nextInt(0xFFFFFF);
        int radius = this.getHeight() / 2 - random.nextInt(this.getHeight() / 2 - 1);
        int sides = random.nextInt(10);
        RegularPolygon polygon = new RegularPolygon(x, y, radius, sides);
        Color color = new Color(randomColor);
        
        drawPolygon(this.getGraphics(), color, polygon);
        drawPolygon(image.getGraphics(), color, polygon);
    }
    
    public void drawShapeAt(int x, int y, int sides) {
        int randomColor = random.nextInt(0xFFFFFF);
        int radius = this.getHeight() / 2 - random.nextInt(this.getHeight() / 2 - 1);
        RegularPolygon polygon = new RegularPolygon(x, y, radius, sides);
        Color color = new Color(randomColor);
        
        drawPolygon(this.getGraphics(), color, polygon);
        drawPolygon(image.getGraphics(), color, polygon);
    }
    
    public BufferedImage getImage() {
        return image;
    }
    
}
