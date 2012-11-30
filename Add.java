package project;

public class Add implements Function {

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

    public Dot evaluate(Dot d) {
        Dot dot = new Dot(d.getX(), d.getY(), d.getR());
        dot.movex(a);
        dot.movey(b);
        return dot;
    }
}
