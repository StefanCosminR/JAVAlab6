package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stefanromanescu on 29/03/17.
 */
public class MainFrame extends JFrame {
    public  MainFrame () {
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().add(new ControlPanel(), BorderLayout.SOUTH);
    }
}
