package project.functions;

import project.Complex;

public class Logarithm extends Function {

    @Override
    public Complex evaluate(Complex z) {
        return z.log();
    }
}
