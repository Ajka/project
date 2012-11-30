package project;

public class Multiply implements  Function {

    double a;
    double b;

    public Multiply(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Multiply(Dot d) {
        this.a = d.getX();
        this.b = d.getY();
    }

    public Dot evaluate(Dot d) {
        Dot dot = new Dot(d.getX(), d.getY(), d.getR());
        dot.multiplyDot(a, b);
        return dot;
        
    }
}
