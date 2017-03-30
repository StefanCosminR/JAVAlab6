/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Views.Canvas;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dragos
 */
public class SaveButtonListener implements ActionListener {

    private JFileChooser saveDialog;
    private FileNameExtensionFilter filter;
    private Canvas canvas;
    private BufferedImage image;
    
    public SaveButtonListener() {
        saveDialog = new JFileChooser();
        filter = new FileNameExtensionFilter("image type", "jpg", "png", "jpeg", "gif");
        canvas = Canvas.getInstance();
        
        saveDialog.setFileFilter(filter);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int returnValue;
        File saveFile;
        
        try {
            returnValue = saveDialog.showSaveDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                saveFile = saveDialog.getSelectedFile();
                image = canvas.getImage();
                ImageIO.write(image, "png", saveFile);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
