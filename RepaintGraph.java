package project;

import project.functions.Function;
import project.shapes.Dot;

public class RepaintGraph {

    MyPanel pattern;
    MyPanel image;
    Function f;

    public RepaintGraph(MyPanel pattern, MyPanel image, Function f) {
        this.pattern = pattern;
        this.image = image;
        this.f = f;
    }

    public void repaintgraph(Complex op) {
        for (int i = 0; i < pattern.dots.size(); i++) {
          Complex a=f.evaluate(pattern.dots.get(i).toComplex(),op);
          image.dots.set(i,a.toDot());
        }
        image.repaint();
    }
}
