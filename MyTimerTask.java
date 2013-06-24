package project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.TimerTask;
import project.functions.Function;
import project.shapes.Line;
import project.shapes.SetOfLines;

public class MyTimerTask extends TimerTask {
 
    MyPanel image;
    ArrayList<Line> lines = new ArrayList<Line>();
    Function f;
    private int i = 0;
    Graphics g;
    Graphics2D g2;
    int p = 10;
    int n = 50;

    public MyTimerTask(MyPanel image, Function f, SetOfLines set) {
        this.image = image;
        this.f = f;
        this.lines = set.lines;
        g = image.getGraphics();
        g2 = (Graphics2D) g;
        g2.translate(150, 150);
        g2.scale(1,-1);

    }
    
    public MyTimerTask(MyPanel image, Function f, Line l) {
        this.image = image;
        this.f = f;
        this.lines.add(l);
        g = image.getGraphics();
        g2 = (Graphics2D) g;
        g2.translate(150, 150);
        g2.scale(1,-1);

    }
    
    public void run() {

        if (i <= n) {
            g2.clearRect(-150, -150, 300, 300);
            for (Line l : lines) {
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
                    tmpLine.paint(g2);

                    tmp1 = tmp2;
                }

            }
            i++;

        } else {
            this.cancel();
        }
    }
}
