package project.functions;

import project.Complex;

public class Power extends Function {

    Function f;
    Function g;
           
    public Power(Function f, Function g) {
        this.f = f;
        this.g = g;
    }
    
    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(z).pow(g.evaluate(z));
    }
}
