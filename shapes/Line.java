package project.shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import project.Complex;
import project.MyPanel;
import project.MyTimerTask;
import project.functions.Function;

public class Line implements Shape {

    public Complex c1;
    public Complex c2;

    public Line(Complex c1, Complex c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawLine((int) c1.getRe(), (int) c1.getIm(), (int) c2.getRe(), (int) c2.getIm());
    }

    @Override
    public void drawImage(Function f, MyPanel image, double x, double y) {
        Graphics g = image.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(150, 150);
        g2.scale(x, y);

        Complex tmp1 = f.evaluate(this.c1);
        int p = 10;
        
        for (int t = 0; t <= p; t++) {
            double re = ((p - t) * this.c1.getRe() / p + t * this.c2.getRe() / p);
            double im = ((p - t) * this.c1.getIm() / p + t * this.c2.getIm() / p);
            Complex tmp2 = f.evaluate(new Complex(re, im));
            Line tmpLine = new Line(tmp1, tmp2);
            tmpLine.paint(g2);
            tmp1 = tmp2;
        }

    }

    @Override
    public void drawCont(Function f, MyPanel image) {
        int delay = 100;
        Timer timer = new Timer(); 
        MyTimerTask draw = new MyTimerTask(image, f, this);
        timer.schedule(draw, 0, delay);
    }

}
