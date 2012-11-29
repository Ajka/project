package project;

public class Add extends Function {

    double a;
    double b;

    public Add(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Add(Dot d) {
        this.a = d.getX();
        this.b = d.getY();
    }

    public void evaluate(Dot d) {
        d.movex(a);
        d.movey(b);
    }
}
