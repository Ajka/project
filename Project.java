package project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Project extends JPanel
        implements ActionListener {

    private JButton continuously;
    private Timer timer;

    public Project() {
        JPanel panel = new JPanel();
        final MyPanel pattern = new MyPanel();
        final MyPanel image = new MyPanel();

        add(pattern);
        add(image);
        add(panel);
        // panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JButton draw = new JButton("Vykresli");
        panel.add(draw);

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



        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Moves m = new Moves();
                m.movex(inputreal, pattern, image);
                m.movey(inputimag, pattern, image);

            }
        ;
        });
        
        JButton continuously = new JButton("Plynule");
        panel.add(continuously);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Moves m = new Moves();

                m.tmovex(inputreal, pattern, image, timer);
                m.tmovey(inputimag, pattern, image, timer);
            }
        });


        continuously.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Komplexne funkcie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 3));

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
