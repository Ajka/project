package project.functions;

import project.Complex;

public class Sine extends Function {

    @Override
    public Complex evaluate(Complex z) {
        return z.sin();
    }
}
