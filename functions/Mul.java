package project.functions;

import project.Complex;
import project.Panel;
import project.ValueImage;


public class Mul implements Panel{
   
    private double eps = 25.0;

     
    public void mult(ValueImage p1,ValueImage p2,Complex op) {
        Multiplication m = new Multiplication();
        Complex n1=m.evaluate(p1.getImage(), op);
        Complex n2=m.evaluate(p2.getImage(), op);
     
        double x1 = n1.getRe();
        double x2 = n2.getRe();
        double y1 = n1.getIm();
        double y2 = n2.getIm();

        if (((Math.abs(x1) - Math.abs(x2)) > eps) || ((Math.abs(y1) - Math.abs(y2)) > eps)) {
       
            Complex n = new Complex((p1.getValue().getRe()+p2.getValue().getRe())/2,
                                    (p1.getValue().getIm()+p2.getValue().getIm())/2);
            ValueImage p = new ValueImage();
            p.setImage(n);
            p.setValue(n);
            int index=0;
            for(ValueImage t:pairs){
                if(p1.equals(t)){
                    index=pairs.indexOf(t);
                }
            }            
            pairs.add(index+1,p);
                     
            mult(p1,p,op);
            mult(p,p2,op);
        }
    }

   


  
}
