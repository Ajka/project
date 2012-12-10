package project.functions;

import project.Complex;
import project.MyPanel;
import project.functions.Function;
import project.shapes.Dot;
import project.shapes.Line;

public class Mul{
    Line l;
    private double eps = 5.0;

      public Mul(){
     }
/*
     @Override
     void evaluate(double a, double b) {
     mult(image.dots.get(0), image.dots.get(1), a, b, pattern, image);
     }*/
    public void mult(Line l,Complex c, MyPanel pattern, MyPanel image) {
        Complex n1=l.c1.mul(c);
        Complex n2=l.c2.mul(c);
        image.repaint();
        

        double x1 = n1.getRe();
        double x2 = n2.getRe();
        double y1 = n1.getIm();
        double y2 = n2.getIm();

        if (((Math.abs(x1) - Math.abs(x2)) > eps) || ((Math.abs(y1) - Math.abs(y2)) > eps)) {
       
            Complex n = new Complex((x1+x2)/2,(y1+y2)/2);
          /*  pattern.dots.add(image.dots.indexOf(d2), d);
            image.dots = pattern.dots;*/
            Line l1=new Line(l.c1,n);
            Line l2=new Line(n,l.c2);
            
            mult(l1,c, pattern, image);
            mult(l2,c, pattern, image);

        }
    }

   


  
}
