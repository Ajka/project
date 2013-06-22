package project;

import java.awt.Graphics;
import project.functions.Function;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    
    private int pressed;
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
                x*=1.1;
                y*=1.1;
                draw(input, image, x, y);         
            }
        ;
        }
        );
        
            zoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {                                            
                x*=0.9;
                y*=0.9;
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
                image.set = new SetOfLines(new ArrayList<Line>() );
                image.set.addLine(image.l1);
                image.set.paint(g1);
                Graphics g2 = pattern.getGraphics();
                g2.translate(150, 150);
                pattern.set = new SetOfLines(new ArrayList<Line>() );
                pattern.set.addLine(pattern.l1);
                pattern.set.paint(g2);
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
                image.set = new SetOfLines();
                image.set.paint(g1);
                Graphics g2 = pattern.getGraphics();
                g2.translate(150, 150);
                pattern.set = new SetOfLines();
                pattern.set.paint(g2);
                pressed = 3;
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
                Function compos = p.parse();

                image.paintComponent(image.getGraphics());
                switch (pressed) {
                    case 2:
                        compos.drawImage2(image.set.lines.get(0), image);                       
                        break;
                    case 3:
                        for (Line l : image.set.lines) {
                            compos.drawImage2(l, image);
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
                x=1;
                y=-1;
                repaint();
            }
            ;
            }

         );
        
 }
     public void draw(JTextField input,MyPanel image, double x, double y){
         Parser p = new Parser(input.getText());
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
                        compos.drawImage(image.set.lines.get(0), image, x, y);                       
                        break;
                    case 3:
                        for (Line l : image.set.lines) {
                            compos.drawImage(l, image,x, y);
                        }
                        break;
                }       
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
