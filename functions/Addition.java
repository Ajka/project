package project.functions;

import project.Complex;

public class Addition extends Function {

    Complex c;

    public Addition(Complex c) {
        this.c = c;
    }

    @Override
    public Complex evaluate(Complex z) {
        return z.add(c);
    }
}
