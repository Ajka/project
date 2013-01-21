package project.functions;

import project.Complex;

public class Multiplication extends Function {

    Complex c;

    public Multiplication(Complex c) {
        this.c = c;
    }

    @Override
    public Complex evaluate(Complex z) {
        return z.mul(c);
    }
}
