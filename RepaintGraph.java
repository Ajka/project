package project;

public class RepaintGraph {

    MyPanel pattern;
    MyPanel image;
    Function f;

    public RepaintGraph(MyPanel pattern, MyPanel image, Function f) {
        this.pattern = pattern;
        this.image = image;
        this.f = f;
    }

    public void repaintgraph() {
        for (int i = 0; i < pattern.dots.size(); i++) {
            image.dots.add(f.evaluate(pattern.dots.get(i)));
          //  f.evaluate(image.dots.get(i));
        }
        image.repaint();
    }
}
