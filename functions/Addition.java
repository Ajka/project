package project.functions;

import project.Complex;

public class Addition extends Function{
    
    Function f;
    Function g;
    
    public Addition(Function f,Function g) {
        this.f = f;
        this.g = g;
    }   

    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(z).add(g.evaluate(z));
    }
}
