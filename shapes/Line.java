package project.shapes;

import java.awt.Graphics;
import project.Complex;

public class Line implements Shape,project.Panel{
   
    @Override
    public void paint(Graphics g) {
    
        for (int i=0;i<pairs.size()-1;i++){
            Complex c1=pairs.get(i).getImage();
            Complex c2=pairs.get(i+1).getImage();
           
            Dot d1=new Dot(c1);
            d1.paint(g);
            Dot d2=new Dot(c2);
            d2.paint(g);
            g.drawLine((int)c1.getRe(),(int)c1.getIm(),(int)c2.getRe(),(int)c2.getIm());
            
        }
    }
    
}
