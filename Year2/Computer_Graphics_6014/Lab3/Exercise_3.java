import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise_3 extends JPanel {
    public static void main(String[] args) {
        Exercise_3 m = new Exercise_3();
        JFrame f = new JFrame();

        f.add(m);
        f.setTitle("Exercise3");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
        
        int xPoly[] = {150, 250, 325, 375, 400, 275, 100};
        int yPoly[] = {150, 100, 125, 225, 325, 375, 300};
        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
        Color bg = new Color(255, 255, 255);
        g2.setColor(bg);
        g2.fillRect(0, 0, 600, 600);
        g2.setColor(Color.BLACK);
        g2.drawPolygon(poly);
        floodFill(g2,buffer, 200, 200, bg, Color.RED);
        g.drawImage(buffer, 0, 0, null);
        
    }
    
    public BufferedImage floodFill(Graphics g,BufferedImage m, int x, int y,Color target_colour, Color replacement_colour){
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<>();
        g2.setColor(replacement_colour);
        plot(g2,x, y, 1);
        q.add(new Point(x,y));

        while (!q.isEmpty()){
            Point p = q.poll();
            x = p.x;
            y = p.y;
            if(m.getRGB(x, y+1) == target_colour.getRGB()){
                plot(g2,x, y+1, 1);
                q.add(new Point(x,y+1));
            }
            if(m.getRGB(x, y-1) == target_colour.getRGB()){
                plot(g2,x, y-1, 1);
                q.add(new Point(x,y-1));
            }
            if(m.getRGB(x+1, y) == target_colour.getRGB()){
                plot(g2,x+1, y, 1);
                q.add(new Point(x+1,y));
            }
            if(m.getRGB(x-1, y) == target_colour.getRGB()){
                plot(g2,x-1, y, 1);
                q.add(new Point(x-1,y));
            }

        }

        return m;
    }

    public void plot(Graphics g , int x , int y, int size){
        g.fillRect(x, y, size, size);
    }
    
}