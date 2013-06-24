package project;

import project.shapes.Dot;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import project.shapes.Shape;

public class MyPanel extends JPanel {

    private static final long serialVersionUID = 1301836524800050587L;
    private double x = 75;
    private double r = 7.0;
    public Complex centre = new Complex(0.0, 0.0);
    public Dot centreDot = new Dot(centre);
    public Shape shape;

    public MyPanel() {

        int height = getHeight();
        int width = getWidth();
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    @Override
    public void paintComponent(final Graphics g) {

        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();
        
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(width / 2, width / 2);       
        g2.scale(1, -1); 
        
        g2.drawRect(-width / 2, -height / 2, height - 1, width - 1);
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillOval(0 - (int) r / 2, 0 - (int) r / 2, (int) r, (int) r);
        
        //g2.fillOval(20, 20, 5,5); 
        
        g2.drawLine((int) -width / 2, 0, width, 0);
        g2.drawLine(0, (int) -height / 2, 0, height);

        g2.setColor(Color.BLACK);
    }
}