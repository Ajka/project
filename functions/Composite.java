package project.functions;

import java.util.ArrayList;
import project.Complex;

public class Composite extends Function {

    Function f;
    Function g;
    Complex c;

    public Composite(Function f, Function g, Complex c) {
        this.f = f;
        this.g = g;
        this.c = c;
    }

    @Override
    public Complex evaluate(Complex z) {
        return f.evaluate(g.evaluate(z));
    }
}
