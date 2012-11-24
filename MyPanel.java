package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.geom.AffineTransform;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    private static final long serialVersionUID = 1301836524800050587L; //?
    private double x = 75;
    private double r = 7.0;
    public ArrayList<Dot> dots = new ArrayList<Dot>();
    Dot d1;
    Dot d2;
    public Dot centre = new Dot(0, 0, r);

    public MyPanel() {


        d1 = new Dot(0.0, 50.0, r);
        d2 = new Dot(0.0, -50.0, r);
        dots.add(d1);
        dots.add(d2);

        int height = getHeight();
        int width = getWidth();
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        //setBorder(BorderFactory.createLineBorder(Color.yellow));


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
        g.translate(width / 2, width / 2);
        AffineTransform aftransfom= new AffineTransform(); 
        aftransfom.translate(0.0, -1.0);
        
        g.drawRect(-width / 2, -height / 2, height - 1, width - 1);
      
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(0, 0, (int)r,(int) r);
        g.drawLine((int)-width / 2,(int) r / 2, width, (int)r / 2);
        g.drawLine((int)r / 2, (int)-height / 2, (int)r / 2, height);

       
        g.setColor(Color.BLACK);
        d1.paintDot(g);
        d2.paintDot(g);
        g.drawLine((int)d1.getX() + (int)r / 2,
                   (int)d1.getY() + (int)r / 2, 
                   (int)d2.getX() + (int)r / 2,
                   (int)d2.getY() + (int)r / 2);
    }
}