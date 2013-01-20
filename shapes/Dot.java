package project.shapes;

import java.awt.Color;
import java.awt.Graphics;
import project.Complex;

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

    /* public Dot(Dot d) {
     this.x = d.getX();
     this.y = d.getY();
     this.r = d.getR();
     }*/
    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void setR(double w) {
        this.r = w;
    }

    public void paint(Graphics g) {
        Color c = Color.BLACK;
        g.setColor(c);
        g.fillOval((int) x - (int) r / 2, (int) y - (int) r / 2, (int) r, (int) r);
    }

    public Complex toComplex() {
        Complex c = new Complex();
        c.setRe(x);
        c.setIm(y);
        return c;

    }

    public boolean inDot(double x, double y) {
        return (x >= this.x - r / 2) && (x <= this.x + r / 2)
                && (y >= this.y - r / 2) && (y <= this.y + r / 2);
    }
}