package project.functions;

import project.Complex;
import project.MyPanel;
import project.shapes.Line;

public abstract class Function {

    public abstract Complex evaluate(Complex z);

    public void drawImage(Line l, MyPanel image) {
        int n = 10;
        Complex tmp1 = l.c1;

        for (int t = 0; t < n; t++) {
            double re = (n - t) * l.c1.getRe() / n + t * l.c2.getRe() / n;
            double im = (n - t) * l.c1.getIm() / n + t * l.c2.getIm() / n;
            Complex tmp2 = this.evaluate(new Complex(re, im));

            Line tmpLine = new Line(tmp1, tmp2);
            tmpLine.paint(image.getGraphics());

            tmp1 = tmp2;

        }

    }
}
