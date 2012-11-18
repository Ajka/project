package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import sun.java2d.loops.DrawLine;

public class MyPanel extends JPanel {

    private static final long serialVersionUID = 1301836524800050587L; //?
    private int x = 75;
    private int r = 7;
    public Dot d1 = null;
    public Dot d2 = null;
    public Dot centre= new Dot(0,0, r);

    public MyPanel() {


        d1 = new Dot(0, 50, r);
        d2 = new Dot(0, -50, r);

        int height = getHeight();
        int width = getWidth();
         setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        //setBorder(BorderFactory.createLineBorder(Color.yellow));

        //Dot centre = new Dot(width / 2, height / 2, r);
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
        g.drawRect(-width / 2, -height / 2, height - 1, width - 1);
        Color c = Color.LIGHT_GRAY;
        g.setColor(c);
        g.fillOval(0, 0, r, r);
        g.drawLine(-width / 2, r / 2, width, r / 2);
        g.drawLine(r / 2, -height / 2, r / 2, height);

        c = Color.BLACK;
        g.setColor(c);
        d1.paintDot(g);
        d2.paintDot(g);
        g.drawLine(d1.getX() + r / 2, d1.getY() + r / 2, d2.getX() + r / 2, d2.getY() + r / 2);
    }
}