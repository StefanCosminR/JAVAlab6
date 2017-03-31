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
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

/**
 *
 * @author dragos
 */
public class SvgSaveButtonListener implements ActionListener {

    private Canvas canvas;
    private JFileChooser saveDialog;
    private FileNameExtensionFilter filter;
    private BufferedImage image;
    private BufferedImage svgImage;
    
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
        SVGGeneratorContext svgContext = SVGGeneratorContext.createDefault(document);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(svgContext, true);
        FileOutputStream saveFileStream = null;
        
        try {
            returnValue = saveDialog.showSaveDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION) {
                saveFile = saveDialog.getSelectedFile();
                image = canvas.getImage();
                saveFileStream = new FileOutputStream(saveFile);
                //svgGenerator.stream(saveFileStream);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if(saveFileStream != null) {
                try {
                    saveFileStream.close();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
}
