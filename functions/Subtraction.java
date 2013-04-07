package project.functions;

import project.Complex;

public class Subtraction extends Function {

    Complex c;
    Complex d;

    public Subtraction(Complex c) {
        this.c = c;
    }
   
    public Subtraction(Complex c, Complex d) {
        this.c = c;
        this.d = d;
    }

    public Complex evaluate() {
        return c.sub(d);
    }   
    
    @Override
    public Complex evaluate(Complex z) {
        return z.sub(c);
    }
}
