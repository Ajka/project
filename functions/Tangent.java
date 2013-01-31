package project.functions;

import project.Complex;

public class Tangent extends Function {

    @Override
    public Complex evaluate(Complex z) {
        return z.tan();
    }
}
