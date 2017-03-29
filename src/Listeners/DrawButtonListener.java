package Listeners;

import Views.Toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stefanromanescu on 29/03/17.
 */
public class DrawButtonListener implements ActionListener {

    Toolbar view;

    public DrawButtonListener(Object o) {
        view = (Toolbar) o;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Integer sides = view.getSidesNumber();
        Integer shapes = view.getShapesNumber();
        Double stroke = view.getStrokeNumber();

        for(int i = 0; i < shapes; ++i) {
            System.out.println(sides);
        }

    }
}
