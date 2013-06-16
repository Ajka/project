package project;

import java.awt.Graphics;
import java.util.TimerTask;
import project.functions.Function;
import project.shapes.Line;

public class MyTimerTask extends TimerTask {

    Line l;
    MyPanel image;
    Function f;
    private int i = 0;
    Graphics g;
    int p = 10;
    int n = 50;

    public MyTimerTask(Line l, MyPanel image, Function f) {
        this.l = l;
        this.image = image;
        this.f = f;
        g = image.getGraphics();
        g.translate(150, 150);

    }

    public void run() {

        if (i <= n) {
           g.clearRect(-150, -150, 300, 300);
for(Line l : image.set.lines){
            Complex tmp1 = f.evaluate(l.c1);
            double re1 = ((n - i) * l.c1.getRe() / n + i * tmp1.getRe() / n);
            double im1 = ((n - i) * l.c1.getIm() / n + i * tmp1.getIm() / n);
            tmp1.setRe(re1);
            tmp1.setIm(im1);

            for (int t = 0; t <= p; t++) {
                double re = ((p - t) * l.c1.getRe() / p + t * l.c2.getRe() / p);
                double im = ((p - t) * l.c1.getIm() / p + t * l.c2.getIm() / p);

                Complex tmp2 = f.evaluate(new Complex(re, im));
                double re2 = ((n - i) * re / n + i * tmp2.getRe() / n);
                double im2 = ((n - i) * im / n + i * tmp2.getIm() / n);
                tmp2.setRe(re2);
                tmp2.setIm(im2);

                Line tmpLine = new Line(tmp1, tmp2);
                tmpLine.paint(g);

                tmp1 = tmp2;
            }
            
        }
            i++;
            
        } else {
            this.cancel();
        }
    }
}
