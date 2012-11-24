package project;

import java.awt.Color;
import java.awt.Graphics;

public class Dot {

    private double x;
    private double y;
    private double r;
    
    public Dot(){
        this.x=0;
        this.y=0;
        this.r=7;
    }

    public Dot(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
   
    public Dot(Dot d) {
        this.x = d.getX();
        this.y = d.getY();
        this.r = d.getR();
    }

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

    public void paintDot(Graphics g) {
        Color c = Color.BLACK;
        g.setColor(c);
        g.fillOval((int)x, (int)y, (int)r, (int)r);      
    }

    public void movex(double length) {       
        this.x +=length ;
    }

    public void movey(double length) {       
        this.y += length;
    }

    public void multiplyDot (double a, double b) {
        double real = x * a - y * b;
        double imag = x * b + y * a;
        this.x = real;
        this.y = imag;
    }

    public boolean inDot(double x, double y) {
        return (x >= this.x - r / 2) && (x <= this.x + r / 2) 
                && (y >= this.y - r / 2) && (y <= this.y + r / 2);
    }
}