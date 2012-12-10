package project.functions;

import project.Complex;

public class Subtract implements Function {

    @Override
    public Complex evaluate(Complex c, Complex op) {
        return c.sub(op);
    }
}
