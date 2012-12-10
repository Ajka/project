package project.functions;

import project.Complex;
import project.functions.Function;
import project.shapes.Dot;

public class Add implements Function {

    @Override
    public Complex evaluate(Complex c, Complex op) {
        return c.add(op);
    }
}
