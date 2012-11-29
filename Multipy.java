package project;

public class Multipy extends Function {

    double a;
    double b;

    public Multipy(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Multipy(Dot d) {
        this.a = d.getX();
        this.b = d.getY();
    }

    public void evaluate(Dot d) {
        d.multiplyDot(a, b);
    }
}
