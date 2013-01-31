package project.functions;

import project.Complex;

public class Power extends Function {

    Complex c;

    public Power(Complex c) {
        this.c = c;
    }

    @Override
    public Complex evaluate(Complex z) {
        return z.pow(c);
    }
}
