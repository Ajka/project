package project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.StringTokenizer;
import project.Complex;
import project.functions.Addition;
import project.functions.Composite;
import project.functions.Cosine;
import project.functions.Division;
import project.functions.Exponentiation;
import project.functions.Function;
import project.functions.Logarithm;
import project.functions.Multiplication;
import project.functions.Power;
import project.functions.Sine;
import project.functions.Subtraction;
import project.functions.Tangent;

public class Parser {

    private String s;
    private ArrayList<Complex> complex_stack = new ArrayList<Complex>();
    private ArrayList<String> operation_stack = new ArrayList<String>();
    private ArrayList<String> priority = new ArrayList<String>();
    private String last;
    private boolean complex_format = true;
    private boolean wasZ = false;
    Function id = new Addition(new Complex(0.0, 0.0));
    public Function f = new Composite(id, id);

    public Parser(String s) {
      
        StringBuilder sb = new StringBuilder("( ");
        sb.append(s);
        sb.append(" )");
        String s1 = new String(sb);
        this.s = s1;
           
        priority.add("(");
        priority.add("+");
        priority.add("-");
        priority.add("*");
        priority.add("/");
        priority.add("^");
        priority.add("sin");
        priority.add("cos");
        priority.add("tg");
        priority.add("log");
        priority.add("e");
        operation_stack.add(" ");
        complex_stack.add(null);
    }

    public Function parse() {
        System.out.println(s);

        StringTokenizer tokenizer = new StringTokenizer(s);

        while (tokenizer.hasMoreTokens()) {
            String str = tokenizer.nextToken();

            last = operation_stack.get(operation_stack.size() - 1);
            if (str.equals("(")) {
                operation_stack.add(str);
            } else if (str.equals(")")) {
                //vyhodnocuje az po predch. zatvorku
                while (!last.equals("(")) {
                    if (wasZ) {
                        f = createFunction(last, f);
                    } else {
                        simplify(last);
                    }
                    operation_stack.remove(last);
                    last = operation_stack.get(operation_stack.size() - 1);
                }
                operation_stack.remove(last);

            } else if (priority.indexOf(str) > -1) { //nie je to cislo, ale op.

                if (priority.indexOf(str) >= priority.indexOf(last)) {
                    operation_stack.add(str);
                } else {
                    if (wasZ) {
                        f = createFunction(last, f);
                    } else {
                        simplify(last);
                    }
                    operation_stack.remove(last);
                    operation_stack.add(str);
                }
            } else if (str.equals("z")) {
                wasZ = true;
            } else {
                Complex c = parse_complex(str);
                complex_stack.add(c);
            }


        }
        // System.out.println(operation_stack);
        // System.out.println(complex_stack);
        return f;
    }

    private Function createFunction(String str, Function f) {
        Function func = null;
        char op = str.charAt(0);
        switch (op) {
            case '+':
                Addition a = new Addition(complex_stack.get(complex_stack.size() - 1));
                func = new Composite(a, f);
                complex_stack.remove(complex_stack.get(complex_stack.size() - 1));
                break;
            case '-':
                Subtraction s = new Subtraction(complex_stack.get(complex_stack.size() - 1));
                func = new Composite(s, f);
                complex_stack.remove(complex_stack.size() - 1);
                break;
            case '*':
                Multiplication m = new Multiplication(complex_stack.get(complex_stack.size() - 1));
                func = new Composite(m, f);
                complex_stack.remove(complex_stack.size() - 1);
                break;
            case '/':
                Division d = new Division(complex_stack.get(complex_stack.size() - 1));
                func = new Composite(d, f);
                complex_stack.remove(complex_stack.size() - 1);
                break;
            case '^':
                Power p = new Power(complex_stack.get(complex_stack.size() - 1));
                func = new Composite(p, f);
                complex_stack.remove(complex_stack.size() - 1);
                break;
            case 's':
                Sine sin = new Sine();
                func = new Composite(sin, f);
                break;
            case 'c':
                Cosine cos = new Cosine();
                func = new Composite(cos, f);
                break;
            case 't':
                Tangent tg = new Tangent();
                func = new Composite(tg, f);
                break;
            case 'l':
                Logarithm log = new Logarithm();
                func = new Composite(log, f);
                break;
            case 'e':
                Exponentiation exp = new Exponentiation();
                func = new Composite(exp, f);
                break;
            case ' ':
                func =f;
                break;            
        }
        return func;

    }

    private void simplify(String str) {
        char op = str.charAt(0);
        Complex result;
        switch (op) {
            case '+':
                Addition a = new Addition(complex_stack.get(complex_stack.size() - 1), complex_stack.get(complex_stack.size() - 2));
                result = a.evaluate();
                complex_stack.remove(complex_stack.get(complex_stack.size() - 1));
                complex_stack.remove(complex_stack.get(complex_stack.size() - 2));
                complex_stack.add(result);
                break;
            case '-':
                Subtraction s = new Subtraction(complex_stack.get(complex_stack.size() - 1), complex_stack.get(complex_stack.size() - 2));
                result = s.evaluate();
                complex_stack.remove(complex_stack.get(complex_stack.size() - 1));
                complex_stack.remove(complex_stack.get(complex_stack.size() - 2));
                complex_stack.add(result);
                break;
            case '*':
                Multiplication m = new Multiplication(complex_stack.get(complex_stack.size() - 1), complex_stack.get(complex_stack.size() - 2));
                result = m.evaluate();
                complex_stack.remove(complex_stack.get(complex_stack.size() - 1));
                complex_stack.remove(complex_stack.get(complex_stack.size() - 2));
                complex_stack.add(result);
                break;
            case '/':
                Division d = new Division(complex_stack.get(complex_stack.size() - 1), complex_stack.get(complex_stack.size() - 2));
                result = d.evaluate();
                complex_stack.remove(complex_stack.get(complex_stack.size() - 1));
                complex_stack.remove(complex_stack.get(complex_stack.size() - 2));
                complex_stack.add(result);
                break;
            case '^':
                Power p = new Power(complex_stack.get(complex_stack.size() - 2), complex_stack.get(complex_stack.size() - 1));//pozor, opacne argumenty
                result = p.evaluate();
                complex_stack.remove(complex_stack.get(complex_stack.size() - 1));
                complex_stack.remove(complex_stack.get(complex_stack.size() - 2));
                complex_stack.add(result);
                break;
        }

    }

    private Complex parse_complex(String substring) {

        StringBuilder sb = new StringBuilder(substring);

        double r = 0.0;
        double i = 0.0;

        if (sb.charAt(0) == '(') {
            sb.deleteCharAt(0);
        }
        if (sb.charAt(sb.length() - 1) == ')') {
            sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.indexOf("+") > 0) {
            sb.insert(sb.indexOf("+"), " ");
            sb.deleteCharAt(sb.indexOf("+"));
            sb.insert(sb.indexOf("i"), " ");
            Scanner s = new Scanner(sb.toString());
            r = s.nextDouble();
            i = s.nextDouble();
        } else if (sb.indexOf("i") > 0) {
            sb.insert(sb.indexOf("i"), " ");
            Scanner s = new Scanner(sb.toString());
            i = s.nextDouble();
        } else {
            Scanner s = new Scanner(sb.toString());
            r = s.nextDouble();
        }

        Complex c = new Complex(r, i);
        // System.out.println(c.im);
        // System.out.println(c.re);
        return c;
        
    }
}
