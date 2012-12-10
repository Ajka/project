package project;

import project.functions.Multiply;
import project.functions.Add;
import project.functions.Function;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import project.functions.Mul;
import project.shapes.Line;

public class Project extends JPanel implements ActionListener {

    private JButton continuously;
    private Timer timer;
   
    public Project() {
        JPanel panel = new JPanel();
        JPanel buttons = new JPanel();
        final MyPanel pattern = new MyPanel();
        final MyPanel image = new MyPanel();

        add(pattern);
        add(image);
        add(buttons);
        add(panel);

        buttons.setLayout(new GridLayout(3, 0));
        panel.setLayout(new GridLayout(2, 0));
        // panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JButton draw = new JButton("Vykresli");
        buttons.add(draw);


        JLabel compl = new JLabel("z +");
        panel.add(compl);
        final JTextField inputreal = new JTextField(3);
        panel.add(inputreal);
        JLabel real = new JLabel("+");
        panel.add(real);
        final JTextField inputimag = new JTextField(3);
        panel.add(inputimag);
        JLabel imag = new JLabel("i");
        panel.add(imag);

        JLabel zmult = new JLabel("z *");
        panel.add(zmult);
        final JTextField inreal = new JTextField(3);
        panel.add(inreal);
        JLabel mreal = new JLabel("+");
        panel.add(mreal);
        final JTextField inimag = new JTextField(3);
        panel.add(inimag);
        JLabel mimag = new JLabel("i");
        panel.add(mimag);



        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
                Scanner s1=new Scanner(inputreal.getText());
                Scanner s2=new Scanner(inputimag.getText());
                Complex c= new Complex(s1.nextDouble(),s2.nextDouble());
                Function add= new Add();
                RepaintGraph rg=new RepaintGraph(pattern, image, add);               
                rg.repaintgraph(c);
                
               
                Scanner s3=new Scanner(inreal.getText());
                Scanner s4=new Scanner(inimag.getText());
                Complex c2= new Complex(s3.nextDouble(),s4.nextDouble());
                Mul m=new Mul();
                Complex cm1=new Complex(WIDTH/2, WIDTH/2+10.0);
                 Complex cm2=new Complex(WIDTH/2-15.0, WIDTH/2+15.0);
                Line l=new Line(cm1,cm2);
                m.mult(l, c, pattern, image);
                //Function mul=new Multiply();
                //RepaintGraph m=new RepaintGraph(pattern, image, mul);
                //m.repaintgraph();
            }
        ;
        });
    
        
        
        JButton continuously = new JButton("Plynule");
        buttons.add(continuously);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                

            
            }
        });
        continuously.addActionListener(this);
   
    
     JButton clear = new JButton("Zmaž");
     buttons.add(clear);
      clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                image.dots=pattern.dots;
                System.out.println("zmaz");
                image.repaint();           
            }
        ;
        });
    }
       
    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
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
}
