package project.functions;

import project.Complex;

public class Divide implements Function {

    @Override
    public Complex evaluate(Complex c, Complex op) {
        return c.div(op);
    }
}
