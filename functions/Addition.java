package project.functions;

import project.Complex;

public class Addition extends Function {

    Complex c;
    Complex d;
    
    public Addition(Complex c) {
        this.c = c;
    }
    
    public Addition(Complex c,Complex d) {
        this.c = c;
        this.d = d;
    }
    
   
    public Complex evaluate() {
        return c.add(d);
    }

    @Override
    public Complex evaluate(Complex z) {
        return z.add(c);
    }
}
