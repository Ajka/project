package project;

import java.awt.Graphics;
import project.functions.Function;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import project.shapes.Dot;
import project.shapes.Line;
import project.shapes.SetOfLines;

public class Project extends JPanel implements ActionListener {

    double x = 1.0;
    double y = -1.0;
       
    public Project() {
        final MyPanel pattern = new MyPanel();
        final MyPanel image = new MyPanel();
        final JTextField input = new JTextField(20);

        JPanel buttons = new JPanel();
        //JPanel panel = new JPanel();
        JButton b_dot = new JButton("Bod");
        JButton b_line = new JButton("Úsečka");
        JButton b_set = new JButton("Mriežka");
        JButton draw = new JButton("Vykresli");
        JButton clear = new JButton("Zmaž");
        JButton continuously = new JButton("Plynule");
        JButton zoomIn = new JButton("+");
        JButton zoomOut = new JButton("-");

        add(pattern);
        add(image);
        add(input);
        add(buttons);
        //add(panel);

        buttons.setLayout(new GridLayout(4, 2));

        buttons.add(b_dot);
        buttons.add(draw);
        buttons.add(b_line);
        buttons.add(continuously);
        buttons.add(b_set);
        buttons.add(clear);
        buttons.add(zoomIn);
        buttons.add(zoomOut);

        //panel.setLayout(new GridLayout(2, 0));

        zoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                x *= 1.1;
                y *= 1.1;
                draw(input, image, x, y);
            }
        ;
        }
        );
        
        zoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                x *= 0.9;
                y *= 0.9;
                draw(input, image, x, y);
            }
        ;
        }
        );
        
        b_dot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Graphics g1 = image.getGraphics();
                g1.translate(150, 150);
                image.shape = new Dot();
                image.shape.paint(g1);
                Graphics g2 = pattern.getGraphics();
                g2.translate(150, 150);
                pattern.shape = new Dot();
                pattern.shape.paint(g2);
            }
        ;
        }
        );

        
        b_line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Graphics g1 = image.getGraphics();
                g1.translate(150, 150);
                Complex c1 = new Complex(0.0, 50.0);
                Complex c2 = new Complex(0.0, -50.0);
                image.shape = new Line(c1, c2);
                image.shape.paint(g1);
                Graphics g2 = pattern.getGraphics();
                g2.translate(150, 150);
                pattern.shape = new Line(c1, c2);
                pattern.shape.paint(g2);
            }
        ;
        }
        );
        
        
        b_set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Graphics g1 = image.getGraphics();
                g1.translate(150, 150);
                image.shape = new SetOfLines();
                image.shape.paint(g1);
                Graphics g2 = pattern.getGraphics();
                g2.translate(150, 150);
                pattern.shape = new SetOfLines();
                pattern.shape.paint(g2);
            }
        ;
        }
        );
        
       
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                draw(input, image, x, y);
            }
        ;
        });
        
        continuously.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Parser p = new Parser(input.getText());
                Function f = p.parse();
              //  image.paintComponent(image.getGraphics());                
                image.shape.drawCont(f, image);  
            }
        ;
        });
        
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("zmaz");             
                x = 1;
                y = -1;
                repaint();
            }
        ;
        });
    }
    
    public void draw(JTextField input, MyPanel image, double x, double y) {
        Parser p = new Parser(input.getText());
        Function f = p.parse();
        image.paintComponent(image.getGraphics());
        image.shape.drawImage(f, image, x, y);                     
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
