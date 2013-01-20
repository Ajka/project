package project.functions;

import project.Complex;

public class Multiplication implements Function {

    @Override
    public Complex evaluate(Complex c, Complex op) {
        return c.mul(op);
    }
}
