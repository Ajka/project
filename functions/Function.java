package project.functions;

import java.awt.Graphics;
import java.awt.Graphics2D;
import project.Complex;
import project.MyPanel;
import java.util.Timer;
import project.MyTimerTask;
import project.shapes.Line;

public abstract class Function {

    public abstract Complex evaluate(Complex z);

    public void drawImage(Line l, MyPanel image, double x, double y) {

        Graphics g = image.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(150, 150);
        g2.scale(x,y);

        Complex tmp1 = this.evaluate(l.c1);
        int p = 10;

        for (int t = 0; t <= p; t++) {
            double re = ((p - t) * l.c1.getRe() / p + t * l.c2.getRe() / p);
            double im = ((p - t) * l.c1.getIm() / p + t * l.c2.getIm() / p);
            Complex tmp2 = this.evaluate(new Complex(re, im));

            Line tmpLine = new Line(tmp1, tmp2);
            tmpLine.paint(g2);

            tmp1 = tmp2;

        }

    }

    public void drawImage2(Line l, MyPanel image) {
        int delay = 100;
        Timer timer = new Timer(); 
        MyTimerTask draw = new MyTimerTask(image, this);
        timer.schedule(draw, 0, delay);
    }
}
