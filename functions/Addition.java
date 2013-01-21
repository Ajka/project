package project.functions;

import project.Complex;

public class Addition implements Function {

    @Override
    public Complex evaluate(Complex c, Complex op) {
        return c.add(op);
    }
}
