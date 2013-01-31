package project.functions;

import project.Complex;

public class Cosine extends Function {

    @Override
    public Complex evaluate(Complex z) {
        return z.cos();
    }
}