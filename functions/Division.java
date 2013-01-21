package project.functions;

import project.Complex;

public class Division extends Function {

    Complex c;

    public Division(Complex c) {
        this.c = c;
    }

    @Override
    public Complex evaluate(Complex z) {
        return z.div(c);
    }
}
