package project.functions;

import java.util.ArrayList;
import project.Complex;

public class Composite extends Function {

    Function f;
    Function g;

    public Composite(Function f, Function g) {
        this.f = f;
        this.g = g;

    }

    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(g.evaluate(z));
    }
}
