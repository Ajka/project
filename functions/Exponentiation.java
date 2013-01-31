package project.functions;

import project.Complex;

public class Exponentiation extends Function {

    @Override
    public Complex evaluate(Complex z) {
        return z.exp();
    }
}
