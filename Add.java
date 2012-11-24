package project;

public class Add extends Function {
    Add(MyPanel pattern,MyPanel image){
        super(pattern,image);
    }

    @Override
    void evaluate(double a, double b) {
         for (int i = 0; i < pattern.dots.size(); i++) {
            image.dots.get(i).movex(a);
            image.dots.get(i).movey(b);
        }
        image.repaint();
    }
    
}
