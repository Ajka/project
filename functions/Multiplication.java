package project.functions;

import project.Complex;

public class Multiplication extends Function {

    Function f;
    Function g;  
        
    public Multiplication(Function f, Function g) {
        this.f = f;
        this.g = g;
    }
    
    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(z).mul(g.evaluate(z));
    }
}
