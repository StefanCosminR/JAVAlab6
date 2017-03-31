package Listeners;

import Views.Canvas;
import Views.InterpolationPointsInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by stefanromanescu on 31/03/17.
 */
public class BuildGraphicInterpolationButtonListener implements ActionListener {

    Canvas canvas;
    InterpolationPointsInput interpolationPointsInput;


    public BuildGraphicInterpolationButtonListener(InterpolationPointsInput interpolationPointsInput) {
        canvas = Views.Canvas.getInstance();
        this.interpolationPointsInput = interpolationPointsInput;
    }

    private ArrayList<Double> parseInput() {
        ArrayList<Double> input = new ArrayList<>();
        String expression = interpolationPointsInput.getCoordinates().getText();
        Scanner sc = new Scanner(expression);
        while(sc.hasNextDouble()){
            input.add(sc.nextDouble());
        }
        return input;
    }

    private boolean checkValidInput(ArrayList<Double> input) {
        return input.size() % 2 == 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Double> in = parseInput();
        if(checkValidInput(in)) {
            canvas.drawLineBetweenPoints(parseInput());
        }
    }
}
