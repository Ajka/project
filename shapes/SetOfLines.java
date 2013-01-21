package project.shapes;

import java.awt.Graphics;
import java.util.ArrayList;

public class SetOfLines implements Shape{
    
    ArrayList<Line> lines = new ArrayList<Line>();

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
