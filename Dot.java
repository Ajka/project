package project;

import java.awt.Color;
import java.awt.Graphics;

public class Dot {

    private int x;
    private int y;
    private int r;

    public Dot(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public void setR(int w) {
        this.r = w;
    }

    public void paintDot(Graphics g) {
        Color c = Color.BLACK;
        g.setColor(c);
        g.fillOval(x, y, r, r);
    }

    public void movex(int l) {
        int move = x + l;
        this.x = move;
    }

    public void movey(int l) {
        int move = y + l;
        this.y = move;
    }

    public void multilp(int a, int b) {
        int real = x * a - y * b;
        int imag = x * b + y * a;
        this.x = real;
        this.y = imag;
    }

    public boolean inDot(int x, int y) {
        return (x >= this.x) && (x <= this.x + this.r) && (y >= this.y)
                && (y <= this.y + this.r);
    }
}