package project.functions;

import project.Complex;

public class Power extends Function {

    Complex c;
    Complex d;

    public Power(Complex c) {
        this.c = c;
    }
    
    public Power(Complex c, Complex d) {
        this.c = c;
        this.d = d;
    }

    public Complex evaluate() {
        return c.pow(d);
    }

    @Override
    public Complex evaluate(Complex z) {
        return z.pow(c);
    }
}
