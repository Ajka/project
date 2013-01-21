package project.functions;

import project.Complex;

public class Subtraction extends Function {

    Complex c;

    public Subtraction(Complex c) {
        this.c = c;
    }

    @Override
    public Complex evaluate(Complex z) {
        return z.sub(c);
    }
}
