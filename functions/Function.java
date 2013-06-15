package project.functions;

import java.awt.Graphics;
import project.Complex;
import project.MyPanel;
import java.util.Timer;
import project.MyTimerTask;
import project.shapes.Line;

public abstract class Function {

    public abstract Complex evaluate(Complex z);

    public void drawImage(Line l, MyPanel image) {

        Graphics g = image.getGraphics();
        g.translate(150, 150);

        Complex tmp1 = this.evaluate(l.c1);
        int p = 10;

        for (int t = 0; t <= p; t++) {
            double re = ((p - t) * l.c1.getRe() / p + t * l.c2.getRe() / p);
            double im = ((p - t) * l.c1.getIm() / p + t * l.c2.getIm() / p);
            Complex tmp2 = this.evaluate(new Complex(re, im));

            Line tmpLine = new Line(tmp1, tmp2);
            tmpLine.paint(g);

            tmp1 = tmp2;

        }

    }

    public void drawImage2(Line l, MyPanel image) {
        int delay = 100;
        Timer timer = new Timer();

        Graphics g = image.getGraphics();

        g.translate(150, 150);
        MyTimerTask draw = new MyTimerTask(l, image, this);
        timer.schedule(draw, 0, delay);
    }
}
