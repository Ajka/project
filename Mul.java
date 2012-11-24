package project;

public class Mul extends Function {
    private double eps=5.0;
    
    Mul(MyPanel pattern, MyPanel image) {
        super(pattern, image);
    }

    @Override
    void evaluate(double a, double b) {
        mult(image.dots.get(0), image.dots.get(1), a, b, pattern, image);
        image.repaint();
    }

    public void mult(Dot d1, Dot d2, double a, double b, MyPanel pattern, MyPanel image) {
        d1.multiplyDot(a, b);
        d2.multiplyDot(a, b);
        
        double x1 = d1.getX();
        double x2 = d2.getX();
        double y1 = d1.getY();
        double y2 = d2.getY();
        
        if (((Math.abs(x1) - Math.abs(x2)) > eps) || ((Math.abs(y1) - Math.abs(y2)) >eps)) {
            double px1 = pattern.dots.get(image.dots.indexOf(d1)).getX();
            double px2 = pattern.dots.get(image.dots.indexOf(d2)).getX();
            double py1 = pattern.dots.get(image.dots.indexOf(d1)).getY();
            double py2 = pattern.dots.get(image.dots.indexOf(d2)).getY();
            Dot d = new Dot(((px1 + px2) / 2), ((py1 + py2) / 2), d1.getR());
            pattern.dots.add(image.dots.indexOf(d2), d);
            image.dots = pattern.dots;
            image.repaint();

            mult(d1, d, a, b, pattern, image);
            mult(d, d2, a, b, pattern, image);

        }
    }
}
