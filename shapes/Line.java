package project.shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import project.Complex;

public class Line implements Shape{
    public Complex c1;
    public Complex c2;
    
    public Line(Complex c1,Complex c2){
        this.c1=c1;
        this.c2=c2;
    }
    @Override
    public void paint(Graphics g) {
       Graphics2D g2 = (Graphics2D) g;
       g2.draw(new Line2D.Double(c1.getRe(), c1.getIm(), c2.getRe(), c2.getIm()));
    }
    
}
