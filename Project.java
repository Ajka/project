package project;

import java.awt.Graphics;
import project.functions.Addition;
import project.functions.Function;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import project.functions.Composite;
import project.functions.Exponentiation;
import project.functions.Multiplication;
import project.functions.Sine;
import project.shapes.Dot;
import project.shapes.Line;

public class Project extends JPanel implements ActionListener {

    private JButton continuously;
    private Timer timer;
    private int pressed;

    public Project() {
        final MyPanel pattern = new MyPanel();
        final MyPanel image = new MyPanel();

        JPanel buttons = new JPanel();
        //JPanel panel = new JPanel();
        JButton b_dot = new JButton("Bod");
        JButton b_line = new JButton("Úsečka");
        JButton b_set = new JButton("Mriežka");
        JButton draw = new JButton("Vykresli");
        JButton clear = new JButton("Zmaž");

        add(pattern);
        add(image);
        add(buttons);
        //add(panel);

        buttons.setLayout(new GridLayout(3, 2));

        buttons.add(b_dot);
        buttons.add(draw);
        buttons.add(b_line);
        buttons.add(clear);
        buttons.add(b_set);

        //panel.setLayout(new GridLayout(2, 0));
        
        b_dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {               
                Graphics g1 = image.getGraphics();
                g1.translate(150, 150);               
                image.centreDot.paint(g1);
                Graphics g2 = pattern.getGraphics();
                g2.translate(150, 150);
                pattern.centreDot.paint(g2);
                pressed = 1;
            }
        ;
        }
        );

        
        b_line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Graphics g1 = image.getGraphics();
                g1.translate(150, 150);
                image.l.paint(g1);
                Graphics g2 = pattern.getGraphics();
                g2.translate(150, 150);
                pattern.l.paint(g2);
                pressed = 2;
            }
        ;
        }
        );
        
        
        b_set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Graphics g1 = image.getGraphics();
                g1.translate(150, 150);
                image.set.paint(g1);
                Graphics g2 = pattern.getGraphics();
                g2.translate(150, 150);
                pattern.set.paint(g2);
                pressed = 3;
            }
        ;
        }
        );
        
       
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
              /*  Function exp = new Exponentiation();
                Function add = new Addition(new Complex(20.0, 20.0));
                Function mul=new Multiplication(new Complex(1.0,1.0));
                Function sin = new Sine();
                Function compos = new Composite(add, mul);*/
                Parser p = new Parser("((70,0 + 5,0 i) + ((1,0 + 1,0 i) * z))");
                Function compos = p.parse();

                image.paintComponent(image.getGraphics());
                switch (pressed) {
                    case 1:                  
                        Complex c = compos.evaluate(image.centre);
                        Dot d = new Dot(c);
                        Graphics g = image.getGraphics();
                        g.translate(150, 150);
                        d.paint(g);
                        break;
                    case 2:
                        compos.drawImage(image.l, image);                       
                        break;
                    case 3:
                        for (Line l : image.set.lines) {
                            compos.drawImage(l, image);
                        }
                        break;
                }

            }
        ;
        });
    
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("zmaz");
                repaint();
            }
        ;
    }

    );
        
    }
       
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Komplexne funkcie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 4));

        JComponent pane = new Project();
        pane.setOpaque(true);
        frame.setContentPane(pane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 }
