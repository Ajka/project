package project.functions;

import project.Complex;

public class Subtraction extends Function {

    Function f;
    Function g;
    
    public Subtraction(Function f, Function g) {
        this.f = f;
        this.g = g;
    }
    
    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(z).sub(g.evaluate(z));
    }
}
