package project.functions;

import project.functions.Function;
import project.shapes.Dot;
import java.util.ArrayList;
import project.Complex;

public class Functions {

    ArrayList<Function> functions = null;

    public Functions() {
        functions = new ArrayList<Function>();
    }

    public void add(Function f) {
        functions.add(f);
    }

    public void evaluate(Complex c, Complex op) {
        for (Function f : functions) {
            f.evaluate(c, op);
        }
    }
}
