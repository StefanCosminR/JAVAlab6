package Views;


import Jama.Matrix;
import Listeners.CanvasMouseAdapter;
import Shapes.RegularPolygon;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.JPanel;
import java.awt.*;
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

    private MathExpressionInput expressionInput;
    private String expression;
    private Graphics2D canvasGraphics;
    private Graphics2D canvasImageGraphics;
    private Expression exp;
    private final int SCALE = 20;
    private final int FUNCTION_TEST_COUNT = 1000;
    private double xValues[];
    private double yValues[];

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
        // g.setColor(color);
        // g.fillPolygon(polygon);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillPolygon(polygon);
        g2.setStroke(new BasicStroke(2.0f));
    }

    public void drawShapeAt(int x, int y) {

        int randomColor = random.nextInt(0xFFFFFF);
        int radius = this.getHeight() / 2 - random.nextInt(this.getHeight() / 2 - 1);
        int sides = random.nextInt(7) + 3;
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

    public void drawShapeAtRandom(int sides, double stroke) {
        int randomX = (int) Math.floor(Math.random() * this.getWidth());
        int randomY = (int) Math.floor(Math.random() * this.getHeight());

        int randomColor = random.nextInt(0xFFFFFF);
        int radius = this.getHeight() / 2 - random.nextInt(this.getHeight() / 2 - 1);
        RegularPolygon polygon = new RegularPolygon(randomX, randomY, radius, sides);
        Color color = new Color(randomColor);

        drawPolygon(this.getGraphics(), color, polygon);
        drawPolygon(image.getGraphics(), color, polygon);
    }

    public void drawLineBetweenPoints(Integer... points){

        double x[] = {4.1168, 4.19236, 4.20967, 4.46908};
        double y[] = {0.213631, 0.214232, 0.21441, 0.218788};

        double f[] = findPolynomialFactors (x, y);

//        for (int i = 0; i < 4; i++)
//            System.out.println (f[i]);

        /*
        ArrayList<Integer> scores = new ArrayList<Integer>(10);
        Random r = new Random();
        for(int i = 0; i < 10; ++i) {
            scores.add(r.nextInt(20));
        }
        int y1;
        int y2;
        for (int i = 0; i < scores.size() - 1; i++) {
            y1 = (scores.get(i)) * 10;
            y2 = (scores.get(i + 1)) * 10;
            g2.drawLine(i * 10, y1, (i + 1) * 10, y2);
        }
        */
    }

    private double[] findPolynomialFactors (double[] x, double[] y)
            throws RuntimeException {
        int n = x.length;

        double[][] data = new double[n][n];
        double[] rhs = new double[n];

        for (int i = 0; i < n; i++) {
            double v = 1;
            for (int j = 0; j < n; j++) {
                data[i][n - j - 1] = v;
                v *= x[i];
            }

            rhs[i] = y[i];
        }

        Matrix m = new Matrix(data);
        Matrix b = new Matrix(rhs, n);

        m.solve(b).print(5, 5);
        Matrix s = m.solve(b);

        return s.getRowPackedCopy();
    }

    public void drawFunctionGraph(String expression) {
        int test;
        double xValue, yValue;

        xValues = new double[FUNCTION_TEST_COUNT];
        yValues = new double[FUNCTION_TEST_COUNT];

        expressionInput = MathExpressionInput.getInstance();

        canvasGraphics = (Graphics2D)this.getGraphics();
        canvasImageGraphics = this.getImage().createGraphics();

        try {
            exp = new ExpressionBuilder(expression).variable("x").build();

            drawAxis(canvasGraphics);
            drawAxis(canvasImageGraphics);
            canvasGraphics.translate(this.getWidth() / 2, this.getHeight() / 2);
            canvasImageGraphics.translate(this.getWidth() / 2, this.getHeight() / 2);

            xValue = yValue = -(this.getHeight() / 2 / SCALE);
            for(test = 0; test < FUNCTION_TEST_COUNT; ++test) {
                xValues[test] = xValue;
                xValue += 1.0 / SCALE;

                exp.setVariable("x", yValue);
                yValues[test] = exp.evaluate();
                yValue += 1.0 / SCALE;

                xValues[test] *= SCALE;
                yValues[test] *= -SCALE;
            }

            for(test = 0; test < FUNCTION_TEST_COUNT - 1; ++test) {
                canvasGraphics.drawLine((int)xValues[test], (int)yValues[test], (int)xValues[test + 1], (int)yValues[test + 1]);
                canvasImageGraphics.drawLine((int)xValues[test], (int)yValues[test], (int)xValues[test + 1], (int)yValues[test + 1]);
            }
        }
        catch (Exception ex) {
            expressionInput.getExpression().setText(ex.getMessage());
        }
    }

    private void drawAxis(Graphics2D g) {
        //draw OY axis
        g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getWidth());
        //draw OX axis
        g.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
    }

    public BufferedImage getImage() {
        return image;
    }

}