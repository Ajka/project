package project.functions;

import project.Complex;

public class Sine extends Function {
    
    Function f;
    
    public Sine(Function f){
        this.f = f;
    }
    
    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(z).sin();
    }
}
