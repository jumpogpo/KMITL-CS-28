import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

class AllGraphics extends JPanel implements Runnable {
    double circleMove = 0;
    double squareMoveY = 600;
    double circleDirection = 1; /* 1 = Left -1 = Right */
    double squareRotate = 0;

    public static void main(String[] args) {
        AllGraphics m = new AllGraphics();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Basic of computer animations | Student Id: 65050368");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();
    }

    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;

        while (true) {
            final int rightCornerX = getWidth() - 100;

            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            circleMove += (50.0 * elapsedTime / 1000.0) * circleDirection;
            squareRotate += 0.5 * elapsedTime / 1000.0;

            if (currentTime >= 3000.0) {
                squareMoveY -= 100 * elapsedTime / 1000.0;
            }

            if (circleMove >= rightCornerX) {
                circleMove = rightCornerX;
                circleDirection = -1;
            } else if (circleMove <= 0) {
                circleMove = 0;
                circleDirection = 1;
            }

            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        /* Clear */
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);

        /* Draw Circle */
        g2.setColor(Color.BLACK);
        g2.translate(circleMove, 0);
        g2.drawOval(0, 0, 100, 100);
        g2.translate(-circleMove, 0);

        /* Draw Square */
        g2.rotate(squareRotate, 300, 300);
        g2.drawRect(200, 200, 200, 200);

        g2.setTransform(new AffineTransform());
        g2.drawRect(0, (int) squareMoveY, 100, 100);
    }
}