package project.shapes;

import java.awt.Graphics;
import project.MyPanel;
import project.functions.Function;

public interface Shape {
    public void paint(Graphics g);
    public void drawImage(Function f, MyPanel image, double x, double y);
    public void drawCont(Function f, MyPanel image);
}
