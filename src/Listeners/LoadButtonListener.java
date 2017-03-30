/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Views.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dragos
 */
public class LoadButtonListener implements ActionListener {

    private JFileChooser loadDialog;
    private Canvas canvas;
    private FileNameExtensionFilter filter;
    private BufferedImage image;
    
    public LoadButtonListener() {
        loadDialog = new JFileChooser();
        canvas = Canvas.getInstance();
        filter = new FileNameExtensionFilter("image type", "jpg", "png", "jpeg", "gif");
        
        loadDialog.setFileFilter(filter);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int returnValue;
        File loadFile;
        
        try {
            returnValue = loadDialog.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                loadFile = loadDialog.getSelectedFile();
                image = ImageIO.read(loadFile);
                canvas.getGraphics().drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
