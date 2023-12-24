import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

//CREDIT : https://www.pngegg.com/en/png-bfgdn 

public class Template extends JPanel{
    public static void main(String[] args) {
        Template m = new Template();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("y2k buuny");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true); 
    }
    @Override
    public void paintComponent(Graphics g){
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        //พื้นหลัง
        g2.setColor(Color.white);
        g2.fillRect(0, 0,600, 600);

        //ตา
        g2.setColor(Color.black);
        bezierCurve(g2,215,315,228,309,243,315,246,325);
        bezierCurve(g2,246,325,237,329,219,323,215,315);

        bezierCurve(g2,299,333,312,327,329,334,330,343);
        bezierCurve(g2,330,343,321,348,303,342,299,333);

        //ปาก
        bezierCurve(g2,260,350,264,346,266,345,270,343);
        bezierCurve(g2,270,343,273,346,274,349,277,354);
        bezierCurve(g2,274,349,272,353,270,358,267,358);
        bezierCurve(g2,264,346,264,354,265,357,267,358);

        //หู
        bezierCurve(g2,235,211,239,123,274,52,331,29);
        bezierCurve(g2,332,29,368,69,340,139,272,209);
        bezierCurve(g2, 328,231,361 ,149 ,402 ,100 ,475 ,81 );
        bezierCurve(g2, 476,81 ,495 ,119 ,454 ,188 ,367 ,249 );

        bezierCurve(g2, 328,231 ,311 ,220 ,290 ,213 ,262 ,209 );

        //หน้า
        bezierCurve(g2, 235, 211, 194, 274, 188, 318, 232, 367);
        bezierCurve(g2, 367,249 ,364 ,317 ,352 ,355 ,298 ,374 );

        //มือซ้าย
        bezierCurve(g2, 203, 321, 181, 325, 181, 342, 192, 360);
        bezierCurve(g2, 192, 360, 171, 392, 171, 408, 185, 410);
        bezierCurve(g2, 185, 410, 187, 411, 205, 383, 220, 350);

        //มือขวา
        bezierCurve(g2,335,350,354,373,348,382,338,389);
        bezierCurve(g2,338,389,343,407,345,421,346,429);
        bezierCurve(g2,346,429,341,441,331,442,322,441);
        bezierCurve(g2,322,441,321,437,320,424,317,396);
        bezierCurve(g2,317,396,306,385,321,376,320,365);

        bezierCurve(g2,185,410,191,417,195,414,218,400);

        //รูปร่าง
        bezierCurve(g2,235,498,208,453,200,412,229,392);
        bezierCurve(g2,229,392,249,399,258,411,270,402);
        bezierCurve(g2,270,402,282,395,303,410,321,441);
        bezierCurve(g2,321,441,323,443,337,443,334,445);
        bezierCurve(g2,334,445,343,443,356,454,363,469);
        bezierCurve(g2,363,469,368,491,367,520,355,542);

        //ขา
        bezierCurve(g2,355,542,352,527,344,510,327,500);
        bezierCurve(g2,327,500,312,488,291,488,260,491);
        bezierCurve(g2,260,491,231,497,185,511,173,505);
        bezierCurve(g2,175,505,169,509,171,516,188,524);
        bezierCurve(g2,188,524,219,537,255,550,308,560);

        bezierCurve(g2,260,550,271,565,284,582,299,599);
        bezierCurve(g2,339,556,339,572,337,588,336,599);

        bezierCurve(g2,332,560,339,556,349,548,355,542);

        //หาง
        bezierCurve(g2,366,499,391,508,396,538,353,544);

        //เสา     
        bresenhamLine(g2, 305, 218, 305,166);
        bresenhamLine(g2, 305, 44, 305,0);

        bresenhamLine(g2, 341, 200, 341,107);
        bresenhamLine(g2, 341, 44, 341,0);
        bresenhamLine(g2, 305, 1, 343,1);

        //ตกแต่งหูกระต่าย
        g2.setColor(Color.gray);
        bezierCurve(g2,257,191,252,174,306,65,325,55);
        bezierCurve(g2,325,55,330,65,284,174,257,191);

        bezierCurve(g2,358,232,357,209,441,108,463,102);
        bezierCurve(g2,463,102,465,118,375,229,358,232);

        //โบว์
        g2.setColor(new Color(235,91,173));
        int xPoly[] = { 232,234,253,260,265,274,279,297,294,279,273,265,255,249,232};
        int yPoly[] = { 390,361,371,368,368,370,375,365,396,383,389,391,388,382,390};
        Polygon poly = new Polygon(xPoly, yPoly, 15);
        g2.drawPolygon(poly);

        //ข้อมือซ้าย
        g2.setColor(new Color(235,91,173));
        int handPoly[] = { 191,209,201,184,190};
        int hand2Poly[] = {361,373,383,373,361};
        poly = new Polygon(handPoly, hand2Poly, 5);
        g2.drawPolygon(poly);
        
        //ข้อมือขวา
        g2.setColor(new Color(235,91,173));
        int hPoly[] = { 318,338,341,318,318};
        int h2Poly[] = {399,393,403,409,399};
        poly = new Polygon(hPoly, h2Poly, 5);
        g2.drawPolygon(poly);

       /*-------------------floodfill------------------------*/
       
       //ตกแต่งหูกระต่าย
       floodfill(buffer, 295, 125, Color.WHITE, Color.BLACK);
       floodfill(buffer, 412, 166, Color.WHITE, Color.BLACK);

       //โบว์
       floodfill(buffer, 267, 379, Color.white, new Color(235,91,173));

       //ตา
       floodfill(buffer, 231, 319, Color.WHITE, Color.black);
       floodfill(buffer, 316, 337, Color.WHITE, Color.BLACK);

       //รูปร่าง
       floodfill(buffer, 274, 450, Color.WHITE, Color.BLACK);

       //เสา
       floodfill(buffer, 321, 186, Color.WHITE, new Color(235,91,173));
       floodfill(buffer, 320, 20, Color.WHITE, new Color(235,91,173));
    
       //ข้อมือซ้าย
       floodfill(buffer, 198, 373, Color.white, new Color(235,91,173));

       //ข้อมือขวา
       floodfill(buffer, 327, 402, Color.white, new Color(235,91,173));

       //ลงสีผิว
       floodfill(buffer, 268, 297, Color.white, new Color(255,250,239));
       floodfill(buffer, 205, 360, Color.white, new Color(255,250,239));
       floodfill(buffer, 184, 396, Color.white, new Color(255,250,239));
       floodfill(buffer, 334, 378, Color.white, new Color(255,250,239));
       floodfill(buffer, 328, 422, Color.white, new Color(255,250,239));
       floodfill(buffer, 268, 297, Color.white, new Color(255,250,239));
       floodfill(buffer, 277, 519, Color.white, new Color(255,250,239));
       floodfill(buffer, 268, 297, Color.white, new Color(255,250,239));
       floodfill(buffer, 377, 524, Color.white, new Color(255,250,239));

       //ลงสีปาก
       floodfill(buffer, 269, 350, Color.white, new Color(255,176,198));
       
       //ลงสีพื้นหลัง
       floodfill(buffer, 132, 279, Color.white, new Color(213,226,255));
       floodfill(buffer, 295, 204, Color.white, new Color(213,226,255));

       g.drawImage(buffer, 0, 0, null);

    }
    public void bezierCurve(Graphics g , int x1 , int y1 , int x2 , int y2 ,int x3 , int y3, int x4 , int y4){
        for(int i = 0; i <= 1000; i++){

            double t = i / 1000.0;
            
            int x = (int)(Math.pow((1 - t) , 3 ) * x1 +
                   3 * t *  Math.pow((1 - t) , 2) * x2 +
                   3 * Math.pow(t , 2) * (1 - t) * x3  +
                   Math.pow(t , 3) * x4);
        
            int y = (int)(Math.pow((1 - t) , 3 ) * y1 +
                   3 * t *  Math.pow((1 - t) , 2) * y2 +
                   3 * Math.pow(t , 2) * (1 - t) * y3  +
                   Math.pow(t , 3) * y4);
            
            plot(g,x,y,1);
        }
    }
    public void bresenhamLine(Graphics g, int x1 , int y1, int x2 ,int y2){
        double dx = Math.abs(x2-x1);
        double dy = Math.abs(y2-y1);

        double sx = (x1 < x2) ? 1 : -1;
        double sy = (y1 < y2) ? 1 : -1;

        boolean isSwap = false;
        if(dy > dx){
            double dd = dx;
            dx = dy;
            dy = dd;
            isSwap = true;
        }
        double D = 2 * dy - dx;
        double x = x1;
        double y = y1;
        for(int i = 1 ; i < dx; i++){
            plot(g, (int)x , (int)y , 1);
            if(D >= 0){
                if(isSwap)  {
                    x += sx;
                }
                else {
                    y += sy;
                }       
                D -= 2 * dx; 
            }
            if(isSwap) {
                y += sy;
            }
            else{
                x += sx;
            }
            D += 2 * dy;     
        }   
    }
    public BufferedImage floodfill (BufferedImage m , int x , int y , Color targetColor , Color replacementColor){
        Graphics2D g2 = m .createGraphics();
        Queue<Point> q = new LinkedList<Point>();

        if(m.getRGB(x,y) == targetColor.getRGB()){
            g2.setColor(replacementColor);
            plot(g2, x, y, 1);
            q.add(new Point (x,y));
        }
        while(!q.isEmpty()){
            Point p = q.poll();

             //south
             if(p.y < 600 && m.getRGB(p.x , p.y + 1) == targetColor.getRGB()){
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point (p.x,p.y + 1));
            }
            //north
            if(p.y > 0 && m.getRGB(p.x , p.y - 1) == targetColor.getRGB()){
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point (p.x,p.y - 1));
            }
            //east
            if(p.x < 600 && m.getRGB(p.x + 1 , p.y) == targetColor.getRGB()){
                g2.setColor(replacementColor);
                plot(g2, p.x + 1, p.y , 1);
                q.add(new Point (p.x + 1,p.y));
            }
            //west
            if(p.x > 0 && m.getRGB(p.x - 1 , p.y) == targetColor.getRGB()){
                g2.setColor(replacementColor);
                plot(g2, p.x - 1, p.y , 1);
                q.add(new Point (p.x - 1,p.y));
            }
        }
        return m;
       
    }
    public void plot(Graphics g , int x , int y, int size){
        g.fillRect(x, y, size, size);
    }
 
}
