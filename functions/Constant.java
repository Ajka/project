package project.functions;

import project.Complex;

public class Constant extends Function{
    Complex c;

    public Constant(Complex c) {
        this.c = c;
    }   

    @Override
    public Complex evaluate(Complex z) {
        return c;
    }
    
}
