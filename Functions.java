package project;

import java.util.ArrayList;

public class Functions {

    ArrayList<Function> functions = null;

    public Functions() {
        functions = new ArrayList<Function>();
    }

    public void add(Function f) {
        functions.add(f);
    }

   
    public void evaluat(Dot d) {
        for (Function f : functions) {
            f.evaluate(d);
        }
    }    
}
