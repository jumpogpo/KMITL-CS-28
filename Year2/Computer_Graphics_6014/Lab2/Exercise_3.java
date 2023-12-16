import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Exercise_3 extends JPanel {
    Graphics g;

    public static void main(String[] args) {
        Exercise_3 m = new Exercise_3();
        JFrame f = new JFrame();

        f.add(m);
        f.setTitle("Exercise 3");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics graphic) {
        g = graphic;

        bresenhamLine(100, 100, 400, 200);
        bresenhamLine(400, 300, 100, 200);
        bresenhamLine(100, 100, 200, 400);
    }

    private void bresenhamLine(int x1, int y1, int x2, int y2) {
        float dx = Math.abs(x2 - x1);
        float dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;

        if (dy > dx) {
            float temp = dx;
            dx = dy;
            dy = temp;
            isSwap = true;
        }

        float D = 2 * dy - dx;

        int x = x1;
        int y = y1;

        for (int i = 1; i <= dx; i++) {
            plot(x, y);

            if (D >= 0) {
                if (isSwap) x += sx;
                else y += sy;

                D -= 2 * dx;
            }

            if (isSwap) y += sy;
            else x += sx;

            D += 2 * dy;
        }
    }

    private void plot(int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}