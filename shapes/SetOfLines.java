package project.shapes;

import java.awt.Graphics;
import java.util.ArrayList;
import project.Complex;

public class SetOfLines implements Shape{
    
    public ArrayList<Line> lines = new ArrayList<Line>();
    
    public SetOfLines(){
        double x = -50.0;
        double y = 50.0;
        
        for(int i = 0; i<11;i++){
            Complex c1=new Complex(x,y);
            Complex c2=new Complex(x,y-100);
            Line l=new Line(c1,c2);
            lines.add(l);
            x+=10;  
        }
        
        for(int i = 0; i<11;i++){
            Complex c1=new Complex(x-10,y);
            Complex c2=new Complex(x-110,y);
            Line l=new Line(c1,c2);
            lines.add(l);
            y-=10;  
        }
        
    }
    public SetOfLines(ArrayList<Line> lines) {
        this.lines = lines;
    }
        
    public void addLine(Line l) {
        lines.add(l);
    }

    @Override
    public void paint(Graphics g) {
       for(Line l: lines){
           l.paint(g);
       }
    }
}
