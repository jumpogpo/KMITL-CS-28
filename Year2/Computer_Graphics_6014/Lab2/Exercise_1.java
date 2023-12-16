import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Exercise_1 extends JPanel {
    Graphics g;

    public static void main(String[] args) {
        Exercise_1 m = new Exercise_1();
        JFrame f = new JFrame();

        f.add(m);
        f.setTitle("Exercise 1");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics graphic) {
        g = graphic;

        naiveLine(100, 100, 400, 200);
        naiveLine(400, 300, 100, 200);
        naiveLine(100, 100, 200, 400);
    }

    private void naiveLine(int x1, int y1, int x2, int y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float b = y1 - (dy / dx) * x1;

        for (int x = x1; x <= x2; x++) {
            int y = (int) (Math.round((dy / dx) * x) + b);
            plot(x, y);
        }
    }

    private void plot(int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}