package project;

import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Moves {

    public void movexy(JTextField inputreal, JTextField inputimag, MyPanel pattern, MyPanel image) {
        Scanner s1 = new Scanner(inputreal.getText());
        int w = s1.nextInt();
        Scanner s2 = new Scanner(inputimag.getText());
        int h = s2.nextInt();

        for (int i = 0; i < pattern.dots.size(); i++) {
            image.dots.get(i).movex(w);
            image.dots.get(i).movey(h);
        }
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

    public void multadd(Dot d1, Dot d2, int a, int b, MyPanel pattern, MyPanel image) {
        
        d1.multilp(a, b);
        d2.multilp(a, b);
        image.repaint();

        int x1 = d1.getX();
        int x2 = d2.getX();
        int y1 = d1.getY();
        int y2 = d2.getY();
        if (((Math.abs(x1) - Math.abs(x2)) > 5) || ((Math.abs(y1) - Math.abs(y2)) > 5)) {
            int px1 = pattern.dots.get(image.dots.indexOf(d1)).getX();
            int px2 = pattern.dots.get(image.dots.indexOf(d2)).getX();
            int py1 = pattern.dots.get(image.dots.indexOf(d1)).getY();
            int py2 = pattern.dots.get(image.dots.indexOf(d2)).getY();
            Dot d = new Dot(((px1 + px2) / 2), ((py1 + py2) / 2), d1.getR());
            pattern.dots.add(image.dots.indexOf(d2), d);
            image.dots = pattern.dots;

            multadd(d1, d, a, b, pattern, image);
            multadd(d, d2, a, b, pattern, image);
           
        }
    }

    public void multiply(JTextField inreal, JTextField inimag, MyPanel pattern, MyPanel image) {

        Scanner s1 = new Scanner(inreal.getText());
        int a = s1.nextInt();
        Scanner s2 = new Scanner(inimag.getText());
        int b = s2.nextInt();

        multadd(image.dots.get(0), image.dots.get(1), a, b, pattern, image);
        image.repaint();

    }
}
