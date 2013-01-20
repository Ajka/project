package project.shapes;

import java.awt.Graphics;
import project.Complex;

public class Line implements Shape,project.Panel{
   
    @Override
    public void paint(Graphics g) {
    
        for (int i=0;i<dots.size()-1;i++){
            Complex c1=dots.get(i).getImage();
            Complex c2=dots.get(i+1).getImage();
           
            c1.toDot().paint(g);
            c1.toDot().paint(g);
            g.drawLine((int)c1.getRe(),(int)c1.getIm(),(int)c2.getRe(),(int)c2.getIm());
            
        }
    }
    
}
