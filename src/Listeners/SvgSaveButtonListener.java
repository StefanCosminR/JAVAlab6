/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Views.Canvas;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author dragos
 */
public class SvgSaveButtonListener implements ActionListener {

    private Canvas canvas;
    private JFileChooser saveDialog;
    private FileNameExtensionFilter filter;
    private BufferedImage image;
    
    public SvgSaveButtonListener() {
        canvas = Canvas.getInstance();
        saveDialog = new JFileChooser();
        filter = new FileNameExtensionFilter("SVG", "svg");
        
        saveDialog.setFileFilter(filter);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int returnValue;
        File saveFile;
        
        DOMImplementation domImplementation = GenericDOMImplementation.getDOMImplementation();
        Document document = domImplementation.createDocument(null, "svg", null);        
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
        
        FileOutputStream saveFileStream = null;
        OutputStreamWriter outputStream = null;
        
        try {
            svgGenerator.setSVGCanvasSize(canvas.getSize());
            returnValue = saveDialog.showSaveDialog(null);
            
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                saveFile = saveDialog.getSelectedFile();
                image = canvas.getImage();
                svgGenerator.drawImage(image, 0, 0, null);
                saveFileStream = new FileOutputStream(saveFile);
                outputStream = new OutputStreamWriter(saveFileStream, "UTF-8");
                svgGenerator.stream(outputStream, true);
                outputStream.flush();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
               if(saveFileStream != null) {               
                    saveFileStream.close();
                }
                if(outputStream != null) {
                    outputStream.close();
                }
            }
            catch (IOException ex) {
                    ex.printStackTrace();
            }
        }
    }
    
}
