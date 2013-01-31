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
import project.functions.Sine;
import project.shapes.Line;

public class Project extends JPanel implements ActionListener {

    private JButton continuously;
    private Timer timer;

    public Project() {
        final MyPanel pattern = new MyPanel();
        final MyPanel image = new MyPanel();

        JPanel buttons = new JPanel();
        //JPanel panel = new JPanel();

        JButton b_set = new JButton("Mriežka");
        JButton draw = new JButton("Vykresli");
        JButton clear = new JButton("Zmaž");

        add(pattern);
        add(image);
        add(buttons);
        //add(panel);

        buttons.setLayout(new GridLayout(1, 3));
        buttons.add(b_set);
        buttons.add(draw);
        buttons.add(clear);

        //panel.setLayout(new GridLayout(2, 0));

        b_set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Graphics g1 = image.getGraphics();
                g1.translate(150, 150);
                image.set.paint(g1);
                Graphics g2 = pattern.getGraphics();
                g2.translate(150, 150);
                pattern.set.paint(g2);
            }
        ;
        }
   );
        
       
       /* JLabel compl = new JLabel("z +");
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
*/


        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                /*  Scanner s1=new Scanner(inputreal.getText());
                 Scanner s2=new Scanner(inputimag.getText());
                 Complex c= new Complex(s1.nextDouble(),s2.nextDouble());
                 Function add= new Addition(c);
                 //add.drawImage(image.l, image);
                 //System.out.println(image.l.c1.re+" " +image.l.c1.im);
                
               
                 Scanner s3=new Scanner(inreal.getText());
                 Scanner s4=new Scanner(inimag.getText());
                 Complex c2= new Complex(s3.nextDouble(),s4.nextDouble());
                
                 Function multiplication=new Multiplication(c2);              
                 //multiplication.drawImage(image.l, image);
                 Function compos = new Composite(add, multiplication);
                 Function exp = new Exponentiation();*/
                Function add = new Addition(new Complex(20.0, 20.0));
                Function sin = new Sine();
                Function compos = new Composite(add, sin);

                image.paintComponent(image.getGraphics());
                for (Line l : image.set.lines) {
                    compos.drawImage(l, image);
                }
            };
        });
    
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("zmaz");
                repaint();
            };
        });
        
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
