import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Exercise_2 extends JPanel {
    Graphics g;

    public static void main(String[] args) {
        Exercise_2 m = new Exercise_2();
        JFrame f = new JFrame();

        f.add(m);
        f.setTitle("Exercise 2");
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

    public void DDALine(int x1,int y1,int x2,int y2){
        float dx = x2-x1;
        float dy = y2-y1; 
        float m = dy/dx;
        float curY;
        float curX;

        if (m <= 1 && m >= 0) {
            if (x2 > x1) curY = y1;
            else curY = y2;

            for(int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                plot(x, Math.round(curY));
                curY +=m;
            }
        } else if (m <= -1) {
            curX = x1;

            if (y1 > y2) curX = x1;
            else curX = x2;

            for(int y = Math.max(y1, y2); y >= Math.min(y1, y2); y--) {
                plot(Math.round(curX), y);
                curX -=1/m;
            }
        } else if (m > 1) {
            curX = x1;

            if (y1 > y2) curX = x1;
            else curX = x2;

            for(int y = Math.max(y1, y2); y >= Math.min(y1, y2); y--) {
                plot(Math.round(curX), y);
                curX -=1/m;
            }
        }else{
            if (x2 > x1) curY = y1;
            else curY = y2;

            for(int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++){
                plot(x, Math.round(curY));
                curY += m;
            }
        }
            
    }

    private void plot(int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}