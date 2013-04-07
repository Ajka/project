package project.functions;

import project.Complex;

public class Division extends Function {

    Complex c;
    Complex d;
    
    public Division(Complex c) {
        this.c = c;
    }
    
    public Division(Complex c, Complex d) {
        this.c = c;
        this.d = d;
    }

    public Complex evaluate() {
        return c.div(d);
    }
    
    @Override
    public Complex evaluate(Complex z) {
        return z.div(c);
    }
}
