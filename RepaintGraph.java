package project;

import project.functions.Function;

public class RepaintGraph implements Panel{


    MyPanel image;
    Function f;

    public RepaintGraph(MyPanel image, Function f) {
     
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
