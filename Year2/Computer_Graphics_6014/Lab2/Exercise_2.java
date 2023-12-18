import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Exercise_2 extends JPanel {
    Graphics g;

    public static void main(String[] args) {
        Exercise_2 m = new Exercise_2();
        JFrame f = new JFrame();

        f.add(m);
        f.setTitle("Graphics Swing");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics graphic) {
        g = graphic;

        DDALine(100, 100, 400, 200);
        DDALine(400, 300, 100, 200);
        DDALine(100, 100, 200, 400);
    }

    private void DDALine(int x1, int y1, int x2, int y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float x = x1;
        float y = y1;
        float m = dy / dx;

        if (m <= 1 && m >= 0) {
            for (x = x1; x <= x2; x++) {
                y = y + m;
                plot((int) x, Math.round(y));
            }
        } else if (m <= -1) {
            for (x = x1; x >= x2; x--) {
                y = y + m;
                plot((int) x, Math.round(y));
            }
        } else if (m > 1) {
            for (y = y1; y <= y2; y++) {
                x = x + 1 / m;
                plot(Math.round(x), (int) y);
            }
        } else {
            for (y = y1; y >= y2; y--) {
                x = x + 1 / m;
                plot(Math.round(x), (int) y);
            }
        }
    }

    private void plot(int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}