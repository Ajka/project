package project.shapes;

import java.awt.Graphics;
import project.Complex;

public class Line implements Shape{
   public Complex c1;
   public Complex c2;
   
   public Line(Complex c1, Complex c2){
       this.c1 = c1;
       this.c2 = c2;
   }
   
    @Override
    public void paint(Graphics g) {        
            Dot d1=new Dot(c1);
            d1.paint(g);
            Dot d2=new Dot(c2);
            d2.paint(g);
            g.drawLine((int)c1.getRe(),(int)c1.getIm(),(int)c2.getRe(),(int)c2.getIm());                 
    }
    
}
