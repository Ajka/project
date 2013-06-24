package project.shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Timer;
import project.Complex;
import project.MyPanel;
import project.MyTimerTask;
import project.functions.Function;

public class SetOfLines implements Shape {
    public ArrayList<Line> lines = new ArrayList<Line>();

    public SetOfLines() {
        double x = -50.0;
        double y = 50.0;

        for (int i = 0; i < 11; i++) {
            Complex c1 = new Complex(x, y);
            Complex c2 = new Complex(x, y - 100);
            Line l = new Line(c1, c2);
            lines.add(l);
            x += 10;
        }

        for (int i = 0; i < 11; i++) {
            Complex c1 = new Complex(x - 10, y);
            Complex c2 = new Complex(x - 110, y);
            Line l = new Line(c1, c2);
            lines.add(l);
            y -= 10;
        }

    }

    public SetOfLines(ArrayList<Line> l) {
        lines.addAll(l);
    }

    public void addLine(Line l) {
        lines.add(l);
    }

    @Override
    public void paint(Graphics g) {
        for (Line l : lines) {
            l.paint(g);
        }
    }

    @Override
    public void drawImage(Function f, MyPanel image, double x, double y) {
        Graphics g = image.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(150, 150);
        g2.scale(x, y);

        for (Line l : lines) {
            Complex tmp1 = f.evaluate(l.c1);
            int p = 10;
            for (int t = 0; t <= p; t++) {
                double re = ((p - t) * l.c1.getRe() / p + t * l.c2.getRe() / p);
                double im = ((p - t) * l.c1.getIm() / p + t * l.c2.getIm() / p);
                Complex tmp2 = f.evaluate(new Complex(re, im));
                Line tmpLine = new Line(tmp1, tmp2);
                tmpLine.paint(g2);
                tmp1 = tmp2;
            }
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
