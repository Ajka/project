package project.functions;

import project.Complex;

public class Exponentiation extends Function {

    Function f;
    
    public Exponentiation(Function f){
        this.f = f;
    }
    
    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(z).exp();
    }
}
