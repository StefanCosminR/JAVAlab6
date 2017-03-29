package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stefanromanescu on 29/03/17.
 */
public class Canvas extends JPanel {

    private Color canvasColor;
    
    Canvas() {
        canvasColor = new Color(59, 114, 231); 
        this.setBackground(canvasColor);
      }
}
