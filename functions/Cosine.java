package project.functions;

import project.Complex;

public class Cosine extends Function {

    Function f;
    
    public Cosine(Function f){
        this.f = f;
    }
    
    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(z).cos();
    }
}