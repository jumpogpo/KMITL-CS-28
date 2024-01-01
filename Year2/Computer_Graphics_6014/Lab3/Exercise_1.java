import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Exercise_1 extends JPanel {
    Graphics g;

    public static void main(String[] args) {
        Exercise_1 m = new Exercise_1();
        JFrame f = new JFrame();

        f.add(m);
        f.setTitle("Exercise1");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics graphic) {
        Random rand = new Random();
        g = graphic;
        Color[] color = {Color.RED,Color.BLUE,Color.GREEN};
        for (Color c : color) {
            g.setColor(c);
            int[] x = {rand.nextInt(580),rand.nextInt(580),rand.nextInt(580),rand.nextInt(580)};
            int[] y = {rand.nextInt(580),rand.nextInt(580),rand.nextInt(580),rand.nextInt(580)};
            plot(x[0], y[0],5);
            plot(x[1], y[1],5);
            plot(x[2], y[2],5);
            plot(x[3], y[3],5);
            BezierCurve(x[0],y[0],x[1],y[1],x[2],y[2],x[3],y[3]);
        }
    }

    private void BezierCurve(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        for (int i = 1; i <= 1000; i++) {
            Double t = i/1000.0;
            int x = (int)((Math.pow(1-t, 3)*x1) +
                   (3 * t *Math.pow(1-t, 2) *x2) +
                   (3 * Math.pow(t,2) *(1-t)*x3) +
                   (Math.pow(t,3)*x4));
            int y = (int)((Math.pow(1-t, 3)*y1) +
                   (3 * t *Math.pow(1-t, 2) *y2) +
                   (3 * Math.pow(t,2) *(1-t)*y3) +
                   (Math.pow(t,3)*y4));
            plot(x, y,2);
            
        }
    }

    private void plot(int x, int y,int size) {
        g.fillRect(x, y, size, size);
    }
}