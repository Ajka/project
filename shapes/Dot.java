package project.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import project.Complex;
import project.MyPanel;
import project.functions.Function;

public class Dot implements Shape {

    private double x;
    private double y;
    private double r = 7;

    public Dot(Complex c) {
        this.x = c.getRe();
        this.y = c.getIm();
    }

    public Dot() {
        this.x = 0;
        this.y = 0;
        this.r = 7;
    }

    public Dot(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void paint(Graphics g) {
        Color c = Color.BLACK;
        Graphics2D g2 = (Graphics2D) g;
        g2.scale(1, -1);
        g2.setColor(c);
        g2.fillOval((int) x - (int) r / 2, (int) y - (int) r / 2, (int) r, (int) r);
    }

    public Complex toComplex() {
        Complex c = new Complex();
        c.setRe(x);
        c.setIm(y);
        return c;

    }

    @Override
    public void drawImage(Function f, MyPanel image, double x, double y) {
        Complex c = f.evaluate(image.centre);
        Dot d = new Dot(c);
        Graphics g = image.getGraphics();
        g.translate(150, 150);
        d.paint(g);
    }

    @Override
    public void drawCont(Function f, MyPanel image) {Complex c = f.evaluate(image.centre);
        Dot d = new Dot(c);
        Graphics g = image.getGraphics();
        g.translate(150, 150);
        d.paint(g);;
    }
}