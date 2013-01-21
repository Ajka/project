package project;

import project.shapes.Dot;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import project.shapes.Line;

public class MyPanel extends JPanel implements Panel {

    private static final long serialVersionUID = 1301836524800050587L;
    private double x = 75;
    private double r = 7.0;
    ValueImage d1 = new ValueImage();
    ValueImage d2 = new ValueImage();
    Complex centre = new Complex(0.0, 0.0);
    public Dot centreDot = new Dot(centre);

    public MyPanel() {

        d1.setValue(new Complex(20.0, 50.0));
        d2.setValue(new Complex(20.0, -50.0));
        d1.setImage(new Complex(20.0, 50.0));
        d2.setImage(new Complex(20.0, -50.0));
        pairs.add(d1);
        pairs.add(d2);

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
        /*  Graphics2D g2 = (Graphics2D) g;
         g2.scale(1.0,-1.0);*/


        int height = getHeight();
        int width = getWidth();
        g.translate(width / 2, width / 2);
        /* AffineTransform aftransfom= new AffineTransform(); 
         aftransfom.scale(1.0, -1.0);*/

        g.drawRect(-width / 2, -height / 2, height - 1, width - 1);

        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(0 - (int) r / 2, 0 - (int) r / 2, (int) r, (int) r);
        g.drawLine((int) -width / 2, 0, width, 0);
        g.drawLine(0, (int) -height / 2, 0, height);


        g.setColor(Color.BLACK);

        Line l = new Line();
        l.paint(g);



    }
}