/*
 * Get Image Position
 *
 * 2023-12-30
 * 
 * This file make by jumpogpo
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Position extends JPanel implements MouseListener {
    private BufferedImage backgroundImage;
    File imageFile = new File("original.png");

    int image_width = 584;
    int image_height = 561;

    int image_position_x = 0;
    int image_position_y = 0;

    public static void main(String[] args) {
        Position m = new Position();
        JFrame frame = new JFrame();

        frame.add(m);
        frame.setTitle("Happy New Year 🎄🎅🏻❄️");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Position() {
        addMouseListener(this);

        try {
            BufferedImage originalImage = ImageIO.read(imageFile);
            backgroundImage = resizeImage(originalImage, image_width, image_height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, image_position_x, image_position_y, null);
        }
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(resultingImage, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        Color color = new Color(backgroundImage.getRGB(x, y));
        System.out.printf("[Debug] X: %d Y: %d | R: %d G: %d B: %d%n", x, y, color.getRed(), color.getGreen(), color.getBlue());
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
