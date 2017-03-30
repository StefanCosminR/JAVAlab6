package Listeners;

import Views.Canvas;
import Views.Toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stefanromanescu on 29/03/17.
 */
public class DrawButtonListener implements ActionListener {

    Toolbar toolbar;
    Canvas canvas;

    public DrawButtonListener(Toolbar toolbar) {
        this.toolbar = toolbar;
        canvas = Canvas.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer sides = toolbar.getSidesNumber();
        Integer shapes = toolbar.getShapesNumber();
        Double stroke = toolbar.getStrokeNumber();

        for(int i = 0; i < shapes; ++i) {

            canvas.drawShapeAtRandom(sides, stroke);
        }

    }
}
