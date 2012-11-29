package project;

import java.util.ArrayList;

public class Functions extends Function {

    ArrayList<Function> functions = null;

    public Functions() {
        functions = new ArrayList<Function>();
    }

    public void add(Function f) {
        functions.add(f);
    }

    @Override
    public void evaluate(Dot d) {
        for (Function f : functions) {
            f.evaluate(d);
        }
    }
}
