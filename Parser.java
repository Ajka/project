package project;

import java.util.ArrayList;
import java.util.Scanner;
import project.Complex;
import project.functions.Addition;
import project.functions.Composite;
import project.functions.Division;
import project.functions.Function;
import project.functions.Multiplication;
import project.functions.Subtraction;

public class Parser {

    private String s;
    private ArrayList<Complex> complex_stack = new ArrayList<Complex>();
    private StringBuilder operations = new StringBuilder("");
    private int last=0;
    private boolean complex_format = true;
    Function id = new Addition(new Complex(0.0, 0.0));
    public Function f = new Composite(id, id);

    public Parser(String s) {
        this.s = s;
    }

    public Function parse() {
        System.out.println(s);
        this.s = s.replaceAll(" ", "");
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                last = i;
            } else if (s.charAt(i) == ')') {
                String subst = s.substring(last + 1, i);
                last=-1;
                // System.out.println(substring);
                for (int j = 0; j < subst.length(); j++) {
                    if (subst.charAt(j) == 'z') {
                        complex_format = false;
                    }
                }
                if (complex_format) {  
                    complex_stack.add(parse_complex(subst));
                } else {
                    char op = operations.charAt(operations.length() - 1);
                    operations.deleteCharAt(operations.length() - 1);
      
                    switch (op) {
                        case '+':
                            Addition a = new Addition(complex_stack.get(complex_stack.size()-1 ));
                            f = new Composite(a, f);
                            complex_stack.remove(complex_stack.get(complex_stack.size()-1 ));
                            break;
                        case '-':
                            Subtraction s = new Subtraction(complex_stack.get(complex_stack.size() - 1));
                            f = new Composite(s, f);
                            complex_stack.remove(complex_stack.size() - 1);
                            break;
                        case '*':                           
                            Multiplication m = new Multiplication(complex_stack.get(complex_stack.size() - 1));
                            f = new Composite(m, f);
                            complex_stack.remove(complex_stack.size()-1 );                        
                            break;
                        case '/':
                            Division d = new Division(complex_stack.get(complex_stack.size() - 1));
                            f = new Composite(d, f);
                            complex_stack.remove(complex_stack.size() - 1);
                            break;
                    }
                }
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')&&(last==-1)) {
                operations.append(s.charAt(i));
            }

        }
        return f;

    }

    private Complex parse_complex(String substring) {

        StringBuilder sb = new StringBuilder(substring);
        sb.insert(sb.indexOf("+"), " ");
        sb.deleteCharAt(sb.indexOf("+"));
        sb.insert(sb.indexOf("i"), " ");
        //System.out.println(sb);

        Scanner s = new Scanner(sb.toString());

        double r = s.nextDouble();
        double i = s.nextDouble();

        Complex c = new Complex(r, i);       
        return c;

    }
}
