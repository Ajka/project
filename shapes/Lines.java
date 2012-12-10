package project.shapes;

import project.shapes.Shape;
import project.shapes.Line;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Lines implements Shape {

    ArrayList<Line> lines = new ArrayList<Line>();

    public void addLine(Line l) {
        lines.add(l);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < lines.size(); i++) {
            g2.draw(new Line2D.Double(lines.get(i).c1.getRe(), lines.get(i).c1.getIm(),
                                      lines.get(i).c2.getRe(), lines.get(i).c2.getIm()));
        }

    }
}
