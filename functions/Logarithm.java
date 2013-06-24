package project.functions;

import project.Complex;

public class Logarithm extends Function {

    Function f;
    
    public Logarithm(Function f){
        this.f = f;
    }
    
    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(z).log();
    }
}
