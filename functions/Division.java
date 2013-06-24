package project.functions;

import project.Complex;

public class Division extends Function {

    Function f;
    Function g;  
        
    public Division(Function f, Function g) {
        this.f = f;
        this.g = g;
    }
        
    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(z).div(g.evaluate(z));
    }
}
