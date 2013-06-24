package project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import project.functions.Addition;
import project.functions.Constant;
import project.functions.Cosine;
import project.functions.Division;
import project.functions.Exponentiation;
import project.functions.Function;
import project.functions.Identity;
import project.functions.Logarithm;
import project.functions.Multiplication;
import project.functions.Power;
import project.functions.Sine;
import project.functions.Subtraction;
import project.functions.Tangent;

public class Parser {

    private String s;
    private Stack <Function> function_stack = new Stack<Function>();
    private Stack <String> operation_stack = new Stack <String>();
    private ArrayList<String> priority = new ArrayList<String>();
    private String last;
    private boolean complex_format = true;
    Function id = new Identity();
    public Function f = id;

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
        //complex_stack.add(null);
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
                    f = createFunction(last, f);
                    operation_stack.pop();
                    last = operation_stack.peek();
                }
                operation_stack.pop();

            } else if (priority.indexOf(str) > -1) { //nie je to cislo, ale op.

                if (priority.indexOf(str) >= priority.indexOf(last)) {
                    operation_stack.push(str);
                } else {
                    while (priority.indexOf(str) < priority.indexOf(last)) {
                        f = createFunction(last, f);                        
                        operation_stack.remove(last);                        
                        last = operation_stack.peek(); 
                    }
                    operation_stack.push(str);
                }
            } else if (str.equals("z")) {
                function_stack.push(id);
            } else {
                Complex c = parse_complex(str);
                Function constant = new Constant(c);
                function_stack.push(constant);
            }           
        }
        // System.out.println(operation_stack);
        // System.out.println(complex_stack);
        return f;
    }

    private Function createFunction(String str, Function f) {
        Function func = null;
        Function tmp;
        char op = str.charAt(0);
        switch (op) {
            case '+':
                Addition a = new Addition(function_stack.pop(), function_stack.pop());
                func = a;
                function_stack.push(func);              
                break;
            case '-':
                tmp = function_stack.pop();
                Subtraction s = new Subtraction(function_stack.pop(), tmp);
                func = s;
                function_stack.push(func);
                break;
            case '*':
                Multiplication m = new Multiplication(function_stack.pop(), function_stack.pop());
                func = m;
                function_stack.push(func); 
                break;
            case '/':
                tmp = function_stack.pop();
                Division d = new Division(function_stack.pop(), tmp);
                func = d;
                function_stack.push(func);
                break;
            case '^':
                tmp = function_stack.pop();
                Power p = new Power(function_stack.pop(), tmp);
                func = p;
                function_stack.push(func);
                break;
            case 's':     
                Sine sin = new Sine(function_stack.pop());              
                func = sin;
                function_stack.push(func);
                break;
            case 'c':
                Cosine cos = new Cosine(function_stack.pop());
                func = cos;
                function_stack.push(func);
                break;
            case 't':
                Tangent tg = new Tangent(function_stack.pop());
                func = tg;
                function_stack.push(func);
                break;
            case 'l':
                Logarithm log = new Logarithm(function_stack.pop());
                func = log;
                function_stack.push(func);
                break;
            case 'e':
                Exponentiation exp = new Exponentiation(function_stack.pop());
                func = exp;
                function_stack.push(func);
                break;
        /*  case ' ':
                func = complex_stack.pop();
                System.out.println("*"+func);
                break; */
                
        }
        return func;
        
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
