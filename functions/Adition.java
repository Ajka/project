package project.functions;

import project.Complex;

public class Adition implements Function {

    @Override
    public Complex evaluate(Complex c, Complex op) {
        return c.add(op);
    }
}
