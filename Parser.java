package project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
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
    private Stack <Complex> complex_stack = new Stack<Complex>();
    private Stack <String> operation_stack = new Stack <String>();
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

            last = operation_stack.peek();
            if (str.equals("(")) {
                operation_stack.push(str);
            } else if (str.equals(")")) {
                //vyhodnocuje az po predch. zatvorku
                while (!last.equals("(")) {
                    if (wasZ) {
                        f = createFunction(last, f);
                    } else {
                        simplify(last);
                    }
                    operation_stack.pop();
                    last = operation_stack.peek();
                }
                operation_stack.pop();

            } else if (priority.indexOf(str) > -1) { //nie je to cislo, ale op.

                if (priority.indexOf(str) >= priority.indexOf(last)) {
                    operation_stack.push(str);
                } else {
                    if (wasZ) {
                        f = createFunction(last, f);
                    } else {
                        simplify(last);
                    }
                    operation_stack.remove(last);
                    operation_stack.push(str);
                }
            } else if (str.equals("z")) {
                wasZ = true;
            } else {
                Complex c = parse_complex(str);
                complex_stack.push(c);
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
                Addition a = new Addition(complex_stack.pop());
                func = new Composite(a, f);
                break;
            case '-':
                Subtraction s = new Subtraction(complex_stack.pop());
                func = new Composite(s, f);
                break;
            case '*':
                Multiplication m = new Multiplication(complex_stack.pop());
                func = new Composite(m, f);
                break;
            case '/':
                Division d = new Division(complex_stack.pop());
                func = new Composite(d, f);
                break;
            case '^':
                Power p = new Power(complex_stack.pop());
                func = new Composite(p, f);
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
        Complex result, tmp;
        switch (op) {
            case '+':
                Addition a = new Addition(complex_stack.pop(), complex_stack.pop());
                result = a.evaluate();
                complex_stack.push(result);
                break;
            case '-':
                tmp = complex_stack.pop();
                Subtraction s = new Subtraction(complex_stack.pop(), tmp);
                result = s.evaluate();
                complex_stack.push(result);
                break;
            case '*':
                Multiplication m = new Multiplication(complex_stack.pop(), complex_stack.pop());
                result = m.evaluate();
                complex_stack.push(result);
                break;
            case '/':
                tmp = complex_stack.pop();
                Division d = new Division(complex_stack.pop(), tmp);
                result = d.evaluate();
                complex_stack.push(result);
                break;
            case '^':
                tmp = complex_stack.pop();
                Power p = new Power(complex_stack.pop(), tmp);
                result = p.evaluate();
                complex_stack.push(result);
                break; 
            case 's':
                Sine sine = new Sine();
                result = sine.evaluate(complex_stack.pop());
                complex_stack.push(result);
                break;   
            case 'c':
                Cosine cos = new Cosine();
                result = cos.evaluate(complex_stack.pop());
                complex_stack.push(result);
                break; 
            case 't':
                Tangent tg = new Tangent();
                result = tg.evaluate(complex_stack.pop());
                complex_stack.push(result);
                break;  
            case 'l':
                Logarithm log = new Logarithm();
                result = log.evaluate(complex_stack.pop());
                complex_stack.push(result);
                break;  
            case 'e':
                Exponentiation exp = new Exponentiation();
                result = exp.evaluate(complex_stack.pop());
                complex_stack.push(result);
                break;                                 
        }

    }

    private Complex parse_complex(String substring) {

        StringBuilder sb = new StringBuilder(substring);
        Scanner s;
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
            s = new Scanner(sb.toString());
            r = s.nextDouble();
            i = s.nextDouble();
        } else if (sb.indexOf("i") > 0) {
            sb.insert(sb.indexOf("i"), " ");
            s = new Scanner(sb.toString());
            i = s.nextDouble();
        } else {
            s = new Scanner(sb.toString());
            r = s.nextDouble();
        }

        Complex c = new Complex(r, i);
        // System.out.println(c.im);
        // System.out.println(c.re);
        return c;
        
    }
}
