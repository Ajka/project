package project;

import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Moves {

    public void movex(JTextField inputreal, MyPanel pattern, MyPanel image) {
        Scanner s = new Scanner(inputreal.getText());
        int l = s.nextInt();

        int x1 = pattern.d1.getX();
        int x2 = pattern.d2.getX();

        image.d1.setX(x1 + l);
        image.d2.setX(x1 + l);

        image.repaint();
    }

    public void movey(JTextField inputimag, MyPanel pattern, MyPanel image) {
        Scanner s = new Scanner(inputimag.getText());
        int l = s.nextInt();

        int y1 = pattern.d1.getY();
        int y2 = pattern.d2.getY();

        image.d1.setY(y1 - l);
        image.d2.setY(y2 - l);

        image.repaint();
    }

    public void tmovex(JTextField inputreal, MyPanel pattern, MyPanel image, Timer timer) {

        Scanner s = new Scanner(inputreal.getText());
        int l = s.nextInt();

        int x1 = image.d1.getX();
        int x2 = image.d2.getX();

        int movex1 = x1 + l / 100;
        int movex2 = x2 + l / 100;

        if (movex1 < l) {

            image.d1.setX(movex1);
            image.d2.setX(movex2);
            image.repaint();
        } else {
            timer.stop();
            image.d1.setX(pattern.d1.getX() + l);
            image.d2.setX(pattern.d2.getX() + l);
            image.repaint();


        }

    }

    public void tmovey(JTextField inputimag, MyPanel pattern, MyPanel image, Timer timer) {

        Scanner s = new Scanner(inputimag.getText());
        int l = s.nextInt();

        int y1 = pattern.d1.getY();
        int y2 = pattern.d2.getY();

        int movey1 = y1 - l / 100;
        int movey2 = y2 - l / 100;

        if (movey1 < l) {

            image.d1.setY(movey1);
            image.d2.setY(movey2);
            image.repaint();
        } else {
            timer.stop();
            image.d1.setY(pattern.d1.getY() - l);
            image.d2.setY(pattern.d2.getY() - l);
            image.repaint();


        }
    }
    public void multiply(JTextField inreal,JTextField inimag, MyPanel image) {

        Scanner s1 = new Scanner(inreal.getText());
        int a = s1.nextInt();
        Scanner s2 = new Scanner(inimag.getText());
        int b = s2.nextInt();
        
        image.d1.multilp(a, b);
        image.d2.multilp(a, b);
      
        image.repaint();
        
    }
    
    
    
}
