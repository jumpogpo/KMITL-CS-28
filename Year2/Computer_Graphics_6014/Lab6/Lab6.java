import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.AffineTransform;

public class Lab6 extends JPanel {
    private final int WIDTH = 200;
    private final int HEIGHT = 200;

    public static void main(String[] args) {
        Lab6 lab6 = new Lab6();
        JFrame frame = new JFrame("Laboratory 6th | 65050368");
        frame.add(lab6);
        frame.setSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setTransform(new AffineTransform(1, 0, 0, 1, 100, 100));
        g2.setColor(Color.RED);
        g2.drawRect(0, 0, WIDTH, HEIGHT);

        double centerX = WIDTH / 2.0;
        double centerY = HEIGHT / 2.0;
        boolean isClockwise = true;
        int angleDegree = 30;
        double angle = Math.toRadians(angleDegree * (isClockwise ? -1 : 1));

        double x = centerX + (Math.cos(angle) * (0 - centerX) - Math.sin(angle) * (0 - centerY));
        double y = centerY + (Math.sin(angle) * (0 - centerX) + Math.cos(angle) * (0 - centerY));

        g2.setTransform(new AffineTransform(Math.cos(angle), Math.sin(angle), -Math.sin(angle), Math.cos(angle), x, y));
        g2.setColor(Color.GREEN);
        g2.drawRect(0, 0, WIDTH, HEIGHT);

        double scaleX = 2.0;
        double scaleY = 2.0;
        double translateX = -50;
        double translateY = 50;

        g2.setTransform(new AffineTransform(scaleX, 0, 0, scaleY, translateX, translateY));
        g2.setColor(Color.BLUE);
        g2.drawRect(0, 0, WIDTH, HEIGHT);
    }
}