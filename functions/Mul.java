package project.functions;

import project.Complex;
import project.Panel;
import project.PatIm;


public class Mul implements Panel{
   
    private double eps = 2.0;

     
    public void mult(PatIm p1,PatIm p2,Complex op) {
        Multiplication m = new Multiplication();
        Complex n1=m.evaluate(p1.getImage(), op);
        Complex n2=m.evaluate(p2.getImage(), op);
     
        double x1 = n1.getRe();
        double x2 = n2.getRe();
        double y1 = n1.getIm();
        double y2 = n2.getIm();

        if (((Math.abs(x1) - Math.abs(x2)) > eps) || ((Math.abs(y1) - Math.abs(y2)) > eps)) {
       
            Complex n = new Complex((p1.getPattern().getRe()+p2.getPattern().getRe())/2,
                                    (p1.getPattern().getIm()+p2.getPattern().getIm())/2);
            PatIm p = new PatIm();
            p.setImage(n);
            p.setPattern(n);
            int index=0;
            for(PatIm t:dots){
                if(p1.equals(t)){
                    index=dots.indexOf(t);
                }
            }            
            dots.add(index+1,p);
          
            
            mult(p1,p,op);
            mult(p,p2,op);
        }
    }

   


  
}
