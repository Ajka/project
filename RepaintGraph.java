package project;

import project.functions.Function;
import project.shapes.Dot;

public class RepaintGraph implements Panel{

    MyPanel pattern;
    MyPanel image;
    Function f;

    public RepaintGraph(MyPanel pattern, MyPanel image, Function f) {
        this.pattern = pattern;
        this.image = image;
        this.f = f;
    }

    public void repaintgraph(Complex op) {
        for (int i = 0; i < dots.size(); i++) {
          Complex a=f.evaluate(dots.get(i).getPattern(),op);
          dots.get(i).setImage(a);
        }
        image.repaint();
    }
}
