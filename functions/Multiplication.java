package project.functions;

import project.Complex;

public class Multiplication extends Function {

    Complex c;
    Complex d;

    public Multiplication(Complex c) {
        this.c = c;
    }
    
    public Multiplication(Complex c, Complex d) {
        this.c = c;
        this.d = d;
    }

    public Complex evaluate() {
        return c.mul(d);
    }
    
    @Override
    public Complex evaluate(Complex z) {
        return z.mul(c);
    }
}
