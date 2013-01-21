package project;

import project.functions.Function;

public class RepaintGraph implements Panel {

    MyPanel image;
    Function f;

    public RepaintGraph(MyPanel image, Function f) {

        this.image = image;
        this.f = f;
    }

    public void repaintgraph(Complex op) {
        for (ValueImage pair : pairs) {
            pair.evaluate(f, op);
        }
        image.repaint();
    }
}
