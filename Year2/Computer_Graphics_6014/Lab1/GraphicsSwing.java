import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class GraphicsSwing extends JPanel {
    Random rand = new Random();

    public static void main(String[] args) {
        GraphicsSwing m = new GraphicsSwing();
        JFrame f = new JFrame();

        f.add(m);
        f.setTitle("Graphics Swing");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics graphic) {
        graphic.drawString("Hello", 40, 40);
        graphic.setColor(Color.BLUE);
        graphic.fillRect(130, 30, 100, 80);
        graphic.drawOval(30, 130, 50, 60);
        graphic.setColor(Color.RED);
        graphic.drawLine(0, 0, 200, 30);
        graphic.fillOval(130, 130, 50, 60);
        graphic.drawArc(30, 200, 40, 50, 90, 60);
        graphic.fillArc(30, 130, 40, 50, 180, 40);

        for (int i = 0; i < 10; i++) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            
            graphic.setColor(new Color(r, g, b));
            plot(graphic, 250 + (i * 5), 250);
        }
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}