package project.functions;

import project.Complex;

public class Tangent extends Function {

    Function f;
    
    public Tangent(Function f){
        this.f = f;
    }
    
    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(z).tan();
    }
}
