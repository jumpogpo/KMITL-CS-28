import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;
import java.util.Queue;

public class Assignment2_65050171_65050368 extends JPanel implements Runnable {
    int x = 50, y = 550;
    int cookieX = 50, cookieY = 470;
    double delay = 0;

    double lastTime = System.currentTimeMillis();
    double currentTime, elapsedTime;

    boolean stageOne = true, stageTwo = false, stageThree = false;
    boolean showCookie = false;
    boolean stopAnim = false;
    boolean babyIsCloseEye = false;
    int pigEarStage = 1;
    int cookieCount = 0;

    Color backgroundColor = new Color(176, 255, 217);
    Color outlineColor = new Color(87, 54, 53);

    public static void main(String[] args) {
        Assignment2_65050171_65050368 m = new Assignment2_65050171_65050368();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("FROM BABIES TO ...");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        (new Thread(m)).start();
    }

    @Override
    public void run() {
        double velocityX = 1.0;
        double targetFrameTime = 1500.0 / 60.0;
        boolean increasingPigEar = true;

        while (true) {
            currentTime = System.currentTimeMillis();

            if (!stopAnim)
                x += velocityX;

            if (showCookie && cookieX <= 300 && cookieCount <= 3) {
                cookieX += 3.0;
            } else if (showCookie && cookieCount <= 3) {
                showCookie = false;
                cookieX = 50;

                Timer showCookieTimer = new Timer(500, e -> {
                    showCookie = true;
                    cookieCount += 1;
                    ((Timer) e.getSource()).stop();
                });

                showCookieTimer.setRepeats(false);
                showCookieTimer.start();
            } else if (showCookie) {
                showCookie = false;
            }

            if (x >= 305 && !stopAnim) {
                stopAnim = true;
                stageOne = false;
                stageTwo = true;

                Timer showCookieTimer = new Timer(1000, e -> {
                    showCookie = true;
                    cookieCount += 1;
                    ((Timer) e.getSource()).stop();
                });

                Timer timer = new Timer(9000, e -> {
                    stageTwo = false;
                    showCookie = false;
                    stageThree = true;
                    ((Timer) e.getSource()).stop();
                });

                timer.setRepeats(false);
                showCookieTimer.setRepeats(false);
                showCookieTimer.start();
                timer.start();
            }

            if (stageTwo && (delay % 1) < (elapsedTime / 1000.0)) {
                babyIsCloseEye = !babyIsCloseEye;
            } else if (stageThree && (delay % 0.8) < (elapsedTime / 1000.0)) {
                pigEarStage += pigEarStage == 3 ? -1
                        : (pigEarStage == 1 && delay % 2 < (elapsedTime / 1000.0)) ? 1
                                : pigEarStage == 2 && !increasingPigEar ? -1 : 1;
                if (pigEarStage == 2)
                    increasingPigEar = !increasingPigEar;
            }

            repaint();

            elapsedTime = currentTime - lastTime;
            lastTime = System.currentTimeMillis();

            delay += elapsedTime / 1000.0;

            long sleepTime = (long) (targetFrameTime - elapsedTime);

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        /* Background */
        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, 600, 600);

        /* Baby Left */
        if (stageOne)
            babyStageOne(g2, buffer, x, y);

        /* Baby Center */
        if (stageTwo)
            babyStageTwo(g2, buffer, x, y, babyIsCloseEye);

        /* Cookie */
        if (showCookie)
            cookie(g2, buffer, cookieX, cookieY);

        /* Pig */
        if (stageThree)
            pig(g2, buffer, x, y, pigEarStage);

        /* Draw */
        g.drawImage(buffer, 0, 0, null);
    }

    private void babyStageOne(Graphics2D g2, BufferedImage buffer, int x, int y) {
        Color backgroundColor = new Color(176, 255, 217);
        g2.setColor(new Color(86, 183, 198));

        // body
        bresenhamLine(g2, x + 21, y - 33, x - 19, y - 34);
        bresenhamLine(g2, x - 33, y - 26, x - 39, y - 7);
        bresenhamLine(g2, x - 39, y - 8, x - 47, y - 12);
        bresenhamLine(g2, x - 51, y - 10, x - 58, y + 5);
        bresenhamLine(g2, x - 57, y + 4, x - 41, y + 2);
        bresenhamLine(g2, x + 17, y - 16, x + 22, y - 35);
        bresenhamLine(g2, x - 33, y - 10, x - 28, y - 4);
        bresenhamLine(g2, x - 14, y - 20, x - 5, y - 10);
        bresenhamLine(g2, x - 36, y - 2, x - 43, y + 9);
        bresenhamLine(g2, x - 42, y + 8, x - 9, y + 6);
        bresenhamLine(g2, x + 3, y - 33, x - 1, y - 26);
        bresenhamLine(g2, x - 1, y - 28, x + 5, y + 4);
        bresenhamLine(g2, x + 4, y + 2, x + 28, y + 2);
        bresenhamLine(g2, x + 21, y + 4, x + 14, y - 1);
        bresenhamLine(g2, x + 15, y - 1, x + 15, y - 34);
        bresenhamLine(g2, x + 16, y - 18, x + 24, y + 1);
        bresenhamLine(g2, x + 30, y + 3, x + 20, y - 3);
        bezierCurve(g2, x - 10, y + 6, x - 8, y, x - 7, y - 9, x - 9, y - 13);
        bezierCurve(g2, x - 17, y - 34, x - 24, y - 31, x - 31, y - 28, x - 35, y - 23);
        bezierCurve(g2, x - 44, y - 10, x - 47, y - 12, x - 49, y - 10, x - 52, y - 9);
        bezierCurve(g2, x - 34, y - 11, x - 34, y - 20, x - 29, y - 25, x - 14, y - 21);
        bezierCurve(g2, x - 29, y - 4, x - 30, y - 6, x - 33, y - 4, x - 36, y - 2);

        g2.setColor(new Color(107, 197, 209));
        bresenhamLine(g2, x - 42, y + 2, x + 2, y - 6);
        bezierCurve(g2, x - 1, y - 6, x + 11, y - 9, x + 15, y - 13, x + 18, y - 15);

        // face
        g2.setColor(new Color(247, 210, 183));
        bresenhamLine(g2, x - 23, y - 70, x - 17, y - 99);
        bresenhamLine(g2, x + 58, y - 70, x + 50, y - 99);
        bresenhamLine(g2, x - 24, y - 56, x - 10, y - 37);
        bresenhamLine(g2, x + 56, y - 56, x + 39, y - 37);
        bezierCurve(g2, x - 19, y - 94, x - 4, y - 110, x + 37, y - 109, x + 52, y - 94);
        bezierCurve(g2, x - 11, y - 38, x + 11, y - 31, x + 31, y - 32, x + 47, y - 41);

        // คิ้ว
        g2.setColor(new Color(239, 198, 170));
        bresenhamLine(g2, x - 11, y - 78, x - 2, y - 78);
        bresenhamLine(g2, x + 39, y - 78, x + 48, y - 78);

        // eye
        g2.setColor(new Color(0, 0, 0));
        midpointCircle(g2, x - 5, y - 69, 4);
        midpointCircle(g2, x + 37, y - 69, 4);

        // mouse
        bezierCurve(g2, x + 11, y - 49, x + 15, y - 46, x + 19, y - 45, x + 23, y - 49);

        // ear
        g2.setColor(new Color(247, 210, 183));
        bezierCurve(g2, x - 23, y - 57, x - 33, y - 62, x - 30, y - 69, x - 24, y - 70);
        bezierCurve(g2, x + 56, y - 57, x + 64, y - 58, x + 67, y - 67, x + 58, y - 70);

        // nose
        drawNose(g2, x + 15, y - 58);

        // แก้ม
        g2.setColor(new Color(243, 175, 157));
        drawEye(g2, x - 12, y - 57, 8);
        drawEye(g2, x + 35, y - 57, 8);

        floodfill(buffer, x + 16, y - 82, backgroundColor, new Color(247, 210, 183));

        // hair
        g2.setColor(new Color(231, 186, 156));
        bresenhamLine(g2, x - 11, y - 102, x + 2, y - 97);
        bresenhamLine(g2, x + 25, y - 106, x + 34, y - 99);
        bresenhamLine(g2, x + 43, y - 93, x + 47, y - 82);
        bresenhamLine(g2, x + 27, y - 102, x + 31, y - 93);
        bresenhamLine(g2, x + 29, y - 105, x + 43, y - 98);
        bresenhamLine(g2, x - 15, y - 93, x - 15, y - 80);
        bezierCurve(g2, x - 1, y - 98, x + 7, y - 94, x + 21, y - 93, x + 21, y - 98);
        bezierCurve(g2, x + 1, y - 106, x + 11, y - 101, x + 19, y - 101, x + 25, y - 106);

        /* Flood Fill baby left */
        floodfill(buffer, x - 4, y - 70, backgroundColor, new Color(0, 0, 0));
        floodfill(buffer, x + 38, y - 70, backgroundColor, new Color(0, 0, 0));
        floodfill(buffer, x - 13, y - 56, backgroundColor, new Color(247, 210, 183));
        floodfill(buffer, x - 9, y - 56, backgroundColor, new Color(247, 175, 157));
        floodfill(buffer, x + 38, y - 56, backgroundColor, new Color(247, 175, 157));
        floodfill(buffer, x + 18, y - 58, backgroundColor, new Color(0, 0, 0));
        floodfill(buffer, x + 17, y - 5, backgroundColor, new Color(80, 169, 183));
        floodfill(buffer, x - 11, y - 27, backgroundColor, new Color(86, 183, 198));
        floodfill(buffer, x + 17, y - 25, backgroundColor, new Color(86, 183, 198));
        floodfill(buffer, x - 17, y + 4, backgroundColor, new Color(107, 197, 209));
        floodfill(buffer, x - 24, y - 15, backgroundColor, new Color(107, 197, 209));
        floodfill(buffer, x + 6, y - 23, backgroundColor, new Color(107, 197, 209));
        floodfill(buffer, x + 11, y - 1, backgroundColor, new Color(107, 197, 209));
    }

    private void babyStageTwo(Graphics2D g2, BufferedImage buffer, int x, int y, Boolean isClose) {
        // head
        g2.setColor(new Color(252, 215, 193));
        bezierCurve(g2, x - 49, y - 87, x - 44, y - 80, x - 32, y - 70, x - 17, y - 66);
        bezierCurve(g2, x + 40, y - 84, x + 34, y - 76, x + 26, y - 69, x + 11, y - 65);
        bezierCurve(g2, x - 18, y - 66, x - 8, y - 65, x + 4, y - 65, x + 17, y - 66);
        bezierCurve(g2, x - 48, y - 106, x - 47, y - 132, x - 37, y - 144, x - 16, y - 154);
        bezierCurve(g2, x + 16, y - 154, x + 33, y - 145, x + 44, y - 131, x + 45, y - 103);
        bresenhamLine(g2, x - 16, y - 155, x + 18, y - 154);

        // ear
        bezierCurve(g2, x - 48, y - 87, x - 56, y - 91, x - 57, y - 100, x - 49, y - 106);
        bezierCurve(g2, x + 41, y - 84, x + 49, y - 85, x + 53, y - 94, x + 44, y - 103);

        // mouse
        g2.setColor(new Color(229, 128, 118));
        bezierCurve(g2, x - 14, y - 85, x - 10, y - 80, x, y - 78, x + 10, y - 84);
        bresenhamLine(g2, x - 15, y - 90, x + 10, y - 90);
        bresenhamLine(g2, x - 15, y - 90, x - 14, y - 82);
        bresenhamLine(g2, x + 8, y - 90, x + 9, y - 82);

        // hair
        g2.setColor(new Color(205, 125, 74));
        bezierCurve(g2, x - 12, y - 153, x - 13, y - 142, x - 8, y - 136, x + 3, y - 130);
        bezierCurve(g2, x - 7, y - 153, x - 4, y - 146, x, y - 141, x + 5, y - 139);
        bezierCurve(g2, x - 1, y - 153, x + 1, y - 148, x + 6, y - 146, x + 10, y - 145);
        bresenhamLine(g2, x + 3, y - 155, x + 12, y - 151);

        // คิ้ว
        g2.setColor(new Color(82, 42, 14));
        bezierCurve(g2, x - 22, y - 114, x - 20, y - 117, x - 17, y - 118, x - 14, y - 115);
        bezierCurve(g2, x + 7, y - 114, x + 10, y - 117, x + 12, y - 118, x + 16, y - 115);

        // แก้ม
        g2.setColor(new Color(255, 164, 146));
        drawEye(g2, x - 39, y - 90, 10);
        drawEye(g2, x + 18, y - 90, 10);

        // body(arm left)
        g2.setColor(new Color(143, 214, 216));
        bezierCurve(g2, x - 28, y - 70, x - 40, y - 60, x - 44, y - 49, x - 40, y - 26);
        bezierCurve(g2, x - 28, y - 15, x - 17, y - 13, x - 12, y - 22, x - 15, y - 30);
        bresenhamLine(g2, x - 28, y - 14, x - 41, y - 26);
        bresenhamLine(g2, x - 16, y - 31, x - 32, y - 15);
        bresenhamLine(g2, x - 26, y - 41, x - 15, y - 30);
        bresenhamLine(g2, x - 26, y - 42, x - 32, y - 67);

        // body(leg left)
        g2.setColor(new Color(143, 214, 216));
        bresenhamLine(g2, x - 41, y - 26, x - 59, y - 10);
        bresenhamLine(g2, x - 44, y + 4, x - 16, y - 5);
        bresenhamLine(g2, x - 17, y - 4, x + 18, y - 5);
        bezierCurve(g2, x - 56, y - 15, x - 63, y - 18, x - 70, y - 15, x - 72, y - 10);
        bezierCurve(g2, x - 72, y - 10, x - 69, y + 1, x - 57, y + 7, x - 44, y + 4);
        bezierCurve(g2, x - 56, y - 15, x - 51, y - 10, x - 45, y - 2, x - 46, y + 4);

        // body(leg right)
        g2.setColor(new Color(143, 214, 216));
        bresenhamLine(g2, x + 18, y - 5, x + 45, y + 3);
        bresenhamLine(g2, x + 56, y - 15, x + 40, y - 26);
        bezierCurve(g2, x + 56, y - 14, x + 71, y - 14, x + 68, y + 4, x + 45, y + 3);
        bezierCurve(g2, x + 56, y - 14, x + 50, y - 10, x + 45, y - 3, x + 46, y + 3);

        // body(arm right)
        g2.setColor(new Color(143, 214, 216));
        bezierCurve(g2, x + 25, y - 70, x + 40, y - 58, x + 46, y - 44, x + 42, y - 25);
        bezierCurve(g2, x + 20, y - 30, x + 14, y - 22, x + 19, y - 13, x + 32, y - 18);
        bresenhamLine(g2, x + 31, y - 66, x + 25, y - 38);
        bresenhamLine(g2, x + 26, y - 40, x + 18, y - 30);
        bresenhamLine(g2, x + 19, y - 32, x + 33, y - 18);
        bresenhamLine(g2, x + 42, y - 25, x + 30, y - 18);

        // body(hand)
        g2.setColor(new Color(252, 215, 193));
        bezierCurve(g2, x - 28, y - 15, x - 17, y - 13, x - 12, y - 22, x - 15, y - 30);
        bezierCurve(g2, x + 20, y - 30, x + 14, y - 22, x + 19, y - 13, x + 32, y - 18);

        // shirt
        g2.setColor(new Color(246, 239, 227));
        bresenhamLine(g2, x - 26, y - 42, x - 32, y - 67);
        bresenhamLine(g2, x - 26, y - 41, x - 15, y - 30);
        bresenhamLine(g2, x - 42, y - 26, x - 56, y - 14);
        bresenhamLine(g2, x + 56, y - 15, x + 40, y - 26);
        bresenhamLine(g2, x - 44, y + 4, x - 16, y - 5);
        bresenhamLine(g2, x + 18, y - 5, x + 45, y + 3);
        bresenhamLine(g2, x - 17, y - 4, x + 20, y - 5);
        bresenhamLine(g2, x + 31, y - 66, x + 25, y - 38);
        bresenhamLine(g2, x + 26, y - 40, x + 18, y - 30);
        bresenhamLine(g2, x - 41, y - 26, x - 28, y - 15);
        bresenhamLine(g2, x - 31, y - 15, x - 15, y - 34);
        bresenhamLine(g2, x + 18, y - 32, x + 32, y - 16);
        bresenhamLine(g2, x + 30, y - 17, x + 42, y - 26);
        bresenhamLine(g2, x - 33, y - 66, x - 25, y - 71);
        bresenhamLine(g2, x - 26, y - 69, x - 18, y - 64);
        bresenhamLine(g2, x + 17, y - 66, x + 29, y - 71);
        bresenhamLine(g2, x + 26, y - 71, x + 34, y - 63);
        bresenhamLine(g2, x - 40, y + 2, x - 48, y + 6);
        bresenhamLine(g2, x + 40, y + 4, x + 48, y + 2);
        bresenhamLine(g2, x + 41, y - 25, x + 30, y - 17);
        bresenhamLine(g2, x - 58, y - 14, x - 40, y - 26);
        bezierCurve(g2, x + 56, y - 14, x + 50, y - 10, x + 45, y - 3, x + 46, y + 3);
        bezierCurve(g2, x - 56, y - 15, x - 51, y - 10, x - 45, y - 2, x - 46, y + 4);
        bezierCurve(g2, x - 19, y - 66, x - 11, y - 54, x + 7, y - 54, x + 16, y - 66);

        // ขีดๆ
        g2.setColor(new Color(255, 204, 0));
        bresenhamLine(g2, x - 68, y - 106, x - 88, y - 102);
        bresenhamLine(g2, x - 64, y - 119, x - 87, y - 126);
        bresenhamLine(g2, x - 60, y - 128, x - 74, y - 142);
        bresenhamLine(g2, x + 56, y - 127, x + 68, y - 143);
        bresenhamLine(g2, x + 60, y - 118, x + 83, y - 126);
        bresenhamLine(g2, x + 64, y - 106, x + 84, y - 102);

        if (!isClose) {
            g2.setColor(outlineColor);
            bresenhamLine(g2, x - 18, y - 111, x - 27, y - 111);
            bresenhamLine(g2, x + 14, y - 110, x + 23, y - 109);
            bezierCurve(g2, x + 20, y - 109, x + 24, y - 104, x + 26, y - 100, x + 22, y - 97);
            bezierCurve(g2, x + 11, y - 96, x + 8, y - 101, x + 10, y - 105, x + 14, y - 110);
            bezierCurve(g2, x + 25, y - 97, x + 19, y - 94, x + 13, y - 95, x + 9, y - 98);
            bezierCurve(g2, x - 24, y - 110, x - 27, y - 110, x - 29, y - 106, x - 29, y - 101);
            bezierCurve(g2, x - 29, y - 100, x - 25, y - 97, x - 20, y - 97, x - 14, y - 99);
            bezierCurve(g2, x - 16, y - 98, x - 13, y - 102, x - 13, y - 107, x - 18, y - 112);

            floodfill(buffer, x - 27, y - 105, backgroundColor, new Color(255, 255, 255));
            floodfill(buffer, x + 20, y - 105, backgroundColor, new Color(255, 255, 255));

            midpointCircle(g2, x - 17, y - 103, 2);
            midpointCircle(g2, x + 14, y - 101, 2);

            g2.setColor(new Color(140, 98, 57));
            bezierCurve(g2, x + 12, y - 106, x + 20, y - 106, x + 22, y - 102, x + 18, y - 94);
            bezierCurve(g2, x + 11, y - 96, x + 8, y - 101, x + 10, y - 105, x + 14, y - 110);
            bezierCurve(g2, x - 16, y - 98, x - 13, y - 102, x - 13, y - 107, x - 18, y - 112);
            bezierCurve(g2, x - 21, y - 98, x - 25, y - 102, x - 24, y - 108, x - 14, y - 108);

            /* Flood Fill animation babycenter */
            floodfill(buffer, x - 19, y - 101, new Color(255, 255, 255), new Color(143, 101, 61));
            floodfill(buffer, x + 12, y - 98, new Color(255, 255, 255), new Color(143, 101, 61));

        } else {
            g2.setColor(new Color(87, 42, 14));
            bezierCurve(g2, x - 32, y - 100, x - 27, y - 106, x - 20, y - 106, x - 15, y - 100);
            bezierCurve(g2, x + 9, y - 100, x + 14, y - 106, x + 20, y - 106, x + 24, y - 100);
        }

        /* Flood Fill Baby Center */
        floodfill(buffer, x, y - 109, backgroundColor, new Color(252, 215, 193));
        floodfill(buffer, x - 1, y - 38, backgroundColor, new Color(246, 239, 227));
        floodfill(buffer, x + 36, y - 40, backgroundColor, new Color(142, 214, 216));
        floodfill(buffer, x - 50, y - 2, backgroundColor, new Color(142, 214, 216));
        floodfill(buffer, x + 48, y, backgroundColor, new Color(142, 214, 216));
        floodfill(buffer, x - 19, y - 19, backgroundColor, new Color(252, 215, 193));
        floodfill(buffer, x + 24, y - 19, backgroundColor, new Color(252, 215, 193));
        floodfill(buffer, x - 33, y - 89, backgroundColor, new Color(255, 164, 146));
        floodfill(buffer, x + 24, y - 89, backgroundColor, new Color(255, 164, 146));
        floodfill(buffer, x - 39, y - 43, backgroundColor, new Color(143, 214, 216));
        floodfill(buffer, x - 1, y - 60, backgroundColor, new Color(143, 214, 216));
        floodfill(buffer, x - 4, y - 83, backgroundColor, new Color(229, 128, 118));

    }

    private void pig(Graphics2D g2, BufferedImage buffer, int x, int y, int stage) {
        // eye
        g2.setColor(outlineColor);
        midpointCircle(g2, x - 48, y - 98, 7);
        midpointCircle(g2, x + 46, y - 98, 7);

        // nose
        g2.setColor(new Color(162, 106, 98));
        bezierCurve(g2, x - 22, y - 84, x - 20, y - 106, x + 19, y - 104, x + 23, y - 84);
        bezierCurve(g2, x - 22, y - 84, x - 16, y - 65, x + 16, y - 65, x + 24, y - 83);
        g2.setColor(new Color(249, 189, 177));
        midpointCircle(g2, x - 1, y - 88, 25);

        // รูจมูก
        g2.setColor(new Color(45, 41, 35));
        bresenhamLine(g2, x - 13, y - 90, x - 13, y - 79);
        bresenhamLine(g2, x - 8, y - 90, x - 8, y - 79);
        bresenhamLine(g2, x + 8, y - 90, x + 8, y - 79);
        bresenhamLine(g2, x + 14, y - 90, x + 14, y - 79);
        bresenhamLine(g2, x - 15, y - 90, x - 7, y - 90);
        bresenhamLine(g2, x - 15, y - 80, x - 7, y - 80);
        bresenhamLine(g2, x + 8, y - 80, x + 15, y - 80);
        bresenhamLine(g2, x + 8, y - 90, x + 15, y - 90);

        // แก้ม
        g2.setColor(new Color(242, 152, 159));
        drawEye(g2, x - 68, y - 78, 15);
        drawEye(g2, x + 41, y - 78, 15);

        // face
        g2.setColor(new Color(69, 86, 83));
        bezierCurve(g2, x - 46, y - 21, x - 88, y - 56, x - 92, y - 100, x - 56, y - 157);
        bezierCurve(g2, x + 44, y - 22, x + 85, y - 54, x + 90, y - 102, x + 55, y - 157);
        bezierCurve(g2, x - 66, y - 150, x - 19, y - 170, x + 16, y - 170, x + 64, y - 149);

        // body
        bresenhamLine(g2, x - 57, y - 30, x - 53, y + 9);
        bresenhamLine(g2, x - 52, y + 7, x - 36, y + 7);
        bresenhamLine(g2, x - 40, y + 6, x - 40, y - 16);
        bresenhamLine(g2, x - 41, y + 8, x - 20, y + 9);
        bresenhamLine(g2, x - 20, y + 8, x - 16, y - 14);
        bresenhamLine(g2, x - 19, y + 2, x + 20, y + 2);
        bresenhamLine(g2, x + 14, y - 14, x + 20, y + 8);
        bresenhamLine(g2, x + 20, y + 7, x + 44, y + 6);
        bresenhamLine(g2, x + 41, y + 7, x + 39, y - 16);
        bresenhamLine(g2, x + 40, y + 6, x + 54, y + 7);
        bresenhamLine(g2, x + 53, y + 7, x + 54, y - 31);
        bresenhamLine(g2, x - 29, y + 10, x - 19, y + 9);

        g2.setColor(new Color(69, 86, 83));

        if (stage == 1) {
            // earLeftUnder
            bezierCurve(g2, x - 59, y - 157, x - 72, y - 161, x - 84, y - 161, x - 102, y - 155);
            bezierCurve(g2, x - 73, y - 129, x - 91, y - 138, x - 98, y - 147, x - 100, y - 156);

            // earRightUnder
            bezierCurve(g2, x + 56, y - 153, x + 73, y - 156, x + 86, y - 157, x + 100, y - 154);
            bezierCurve(g2, x + 74, y - 119, x + 93, y - 132, x + 98, y - 141, x + 100, y - 154);

            // inearLeftUnder
            g2.setColor(new Color(162, 102, 96));
            bezierCurve(g2, x - 66, y - 145, x - 80, y - 150, x - 86, y - 150, x - 95, y - 144);

            // inearRightUnder
            bezierCurve(g2, x + 66, y - 138, x + 74, y - 146, x + 83, y - 147, x + 96, y - 140);

            // ear leftUnder
            floodfill(buffer, x - 84, y - 139, backgroundColor, new Color(250, 182, 170));
            floodfill(buffer, x - 78, y - 154, backgroundColor, new Color(247, 216, 202));

            // ear RightUnder
            floodfill(buffer, x + 82, y - 138, backgroundColor, new Color(250, 182, 170));
            floodfill(buffer, x + 89, y - 150, backgroundColor, new Color(247, 216, 202));
        } else if (stage == 2) {
            // ear Right
            bezierCurve(g2, x + 69, y - 139, x + 63, y - 148, x + 53, y - 154, x + 36, y - 162);
            bezierCurve(g2, x + 41, y - 159, x + 56, y - 172, x + 71, y - 172, x + 87, y - 172);
            bezierCurve(g2, x + 66, y - 138, x + 81, y - 152, x + 86, y - 162, x + 87, y - 171);

            // earleft
            bezierCurve(g2, x - 69, y - 139, x - 81, y - 150, x - 87, y - 162, x - 89, y - 172);
            bezierCurve(g2, x - 46, y - 159, x - 60, y - 170, x - 75, y - 173, x - 89, y - 172);
            bezierCurve(g2, x - 68, y - 139, x - 64, y - 151, x - 56, y - 155, x - 40, y - 160);

            // inearRight
            g2.setColor(new Color(162, 102, 96));
            bezierCurve(g2, x + 55, y - 157, x + 61, y - 162, x + 70, y - 162, x + 84, y - 157);

            // inearleft
            bezierCurve(g2, x - 86, y - 158, x - 78, y - 161, x - 70, y - 162, x - 56, y - 155);

            // earLeft
            floodfill(buffer, x - 64, y - 166, backgroundColor, new Color(247, 216, 202));

            // inearLeft
            floodfill(buffer, x - 70, y - 157, backgroundColor, new Color(250, 182, 170));

            // earRight
            floodfill(buffer, x + 61, y - 166, backgroundColor, new Color(247, 216, 202));

            // inearRight
            floodfill(buffer, x + 68, y - 157, backgroundColor, new Color(250, 182, 170));
        } else if (stage == 3) {
            // earLeftOn
            bezierCurve(g2, x - 21, y - 165, x - 30, y - 180, x - 42, y - 186, x - 62, y - 192);
            bezierCurve(g2, x - 62, y - 192, x - 63, y - 182, x - 62, y - 171, x - 52, y - 155);

            // earRighton
            bezierCurve(g2, x + 16, y - 162, x + 25, y - 182, x + 37, y - 187, x + 56, y - 193);
            bezierCurve(g2, x + 48, y - 154, x + 56, y - 166, x + 59, y - 177, x + 55, y - 193);

            // inearLeftOn
            g2.setColor(new Color(162, 102, 96));
            bezierCurve(g2, x - 38, y - 162, x - 44, y - 176, x - 52, y - 177, x - 62, y - 176);

            // inearRightOn
            bezierCurve(g2, x + 29, y - 162, x + 39, y - 176, x + 45, y - 178, x + 58, y - 177);

            // ear leftOn
            floodfill(buffer, x - 53, y - 168, backgroundColor, new Color(250, 182, 170));
            floodfill(buffer, x - 35, y - 175, backgroundColor, new Color(247, 216, 202));

            // ear RightOn
            floodfill(buffer, x + 48, y - 166, backgroundColor, new Color(250, 182, 170));
            floodfill(buffer, x + 50, y - 182, backgroundColor, new Color(247, 216, 202));
        }

        // eye
        floodfill(buffer, x - 46, y - 98, backgroundColor, new Color(45, 38, 36));
        floodfill(buffer, x + 44, y - 98, backgroundColor, new Color(45, 38, 36));

        // แก้ม
        floodfill(buffer, x - 64, y - 77, backgroundColor, new Color(242, 152, 159));
        floodfill(buffer, x + 59, y - 77, backgroundColor, new Color(242, 152, 159));

        // nose
        floodfill(buffer, x - 1, y - 77, backgroundColor, new Color(250, 185, 171));
        floodfill(buffer, x - 1, y - 105, backgroundColor, new Color(250, 185, 171));

        // รูจมูก
        floodfill(buffer, x - 12, y - 84, backgroundColor, new Color(45, 41, 35));
        floodfill(buffer, x + 11, y - 84, backgroundColor, new Color(45, 41, 35));

        // body
        floodfill(buffer, x, y - 129, backgroundColor, new Color(247, 216, 202));
    }

    private void cookie(Graphics2D g2, BufferedImage buffer, int x, int y) {
        /* cookie anima */
        g2.setColor(new Color(241, 181, 121));
        midpointCircle(g2, x + 1, y - 4, 20);

        g2.setColor(new Color(99, 61, 24));
        midpointCircle(g2, x - 12, y - 4, 2);
        midpointCircle(g2, x - 2, y - 12, 2);
        midpointCircle(g2, x + 12, y - 12, 2);
        midpointCircle(g2, x + 13, y - 1, 2);
        midpointCircle(g2, x + 1, y - 2, 2);
        midpointCircle(g2, x - 9, y + 6, 2);
        midpointCircle(g2, x + 4, y + 12, 2);
        midpointCircle(g2, x + 15, y + 8, 2);

        /* Flood Fill anima cookie */
        floodfill(buffer, x - 10, y - 3, new Color(buffer.getRGB(x - 10, y - 3)), new Color(241, 181, 121));
        floodfill(buffer, x + 3, y + 12, new Color(buffer.getRGB(x + 3, y + 12)), new Color(97, 59, 22));
        floodfill(buffer, x + 1, y - 1, new Color(buffer.getRGB(x + 1, y - 1)), new Color(97, 59, 22));
        floodfill(buffer, x - 2, y - 11, new Color(buffer.getRGB(x - 2, y - 11)), new Color(97, 59, 22));
        floodfill(buffer, x + 15, y + 8, new Color(buffer.getRGB(x + 15, y + 8)), new Color(97, 59, 22));
        floodfill(buffer, x + 13, y - 1, new Color(buffer.getRGB(x + 13, y - 1)), new Color(97, 59, 22));
        floodfill(buffer, x - 12, y - 4, new Color(buffer.getRGB(x - 12, y - 4)), new Color(97, 59, 22));
        floodfill(buffer, x + 12, y - 12, new Color(buffer.getRGB(x + 12, y - 12)), new Color(97, 59, 22));
        floodfill(buffer, x - 9, y + 6, new Color(buffer.getRGB(x - 9, y + 6)), new Color(97, 59, 22));
        floodfill(buffer, x - 1, y - 3, new Color(229, 128, 118), new Color(241, 181, 121));
    }

    private BufferedImage floodfill(BufferedImage m, int x, int y, Color targetColor, Color replacementColor) {
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<Point>();

        if (m.getRGB(x, y) == targetColor.getRGB()) {
            g2.setColor(replacementColor);
            plot(g2, x, y, 1);
            q.add(new Point(x, y));
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            // South
            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }

            // North
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }

            // East
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }

            // West
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1, p.y));
            }
        }

        return m;
    }

    private void drawNose(Graphics g2, int x, int y) {
        bezierCurve(g2, x, y, x + 2, y - 2, x + 5, y - 2, x + 5, y);
        bezierCurve(g2, x, y, x + 2, y + 2, x + 5, y + 2, x + 5, y);
    }

    private void drawEye(Graphics g2, int x, int y, int size) {
        int controlPoint1Offset = size / 2;
        int controlPoint2Offset = size;

        bezierCurve(g2, x, y, x + controlPoint1Offset, y - controlPoint1Offset, x + controlPoint2Offset,
                y - controlPoint2Offset, x + 2 * controlPoint2Offset, y);
        bezierCurve(g2, x, y, x + controlPoint1Offset, y + controlPoint1Offset, x + controlPoint2Offset,
                y + controlPoint2Offset, x + 2 * controlPoint2Offset, y);
    }

    private void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;

            int x = (int) (Math.pow((1 - t), 3) * x1 +
                    3 * t * Math.pow((1 - t), 2) * x2 +
                    3 * Math.pow(t, 2) * (1 - t) * x3 +
                    Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 +
                    3 * t * Math.pow((1 - t), 2) * y2 +
                    3 * Math.pow(t, 2) * (1 - t) * y3 +
                    Math.pow(t, 3) * y4);

            plot(g, x, y, 1);
        }
    }

    private void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);

        double sx = (x1 < x2) ? 1 : -1;
        double sy = (y1 < y2) ? 1 : -1;

        boolean isSwap = false;

        if (dy > dx) {
            double dd = dx;
            dx = dy;
            dy = dd;
            isSwap = true;
        }

        double D = 2 * dy - dx;
        double x = x1;
        double y = y1;

        for (int i = 1; i < dx; i++) {
            plot(g, (int) x, (int) y, 1);

            if (D >= 0) {
                if (isSwap) {
                    x += sx;
                } else {
                    y += sy;
                }
                D -= 2 * dx;
            }

            if (isSwap) {
                y += sy;
            } else {
                x += sx;
            }

            D += 2 * dy;
        }
    }

    public void midpointCircle(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int d = 1 - r;

        int dx = 2 * x;
        int dy = 2 * y;

        while (x <= y) {
            plot(g, x + xc, y + yc, 1);
            plot(g, -x + xc, y + yc, 1);
            plot(g, x + xc, -y + yc, 1);
            plot(g, -x + xc, -y + yc, 1);
            plot(g, y + xc, x + yc, 1);
            plot(g, -y + xc, x + yc, 1);
            plot(g, y + xc, -x + yc, 1);
            plot(g, -y + xc, -x + yc, 1);

            x++;
            dx += 2;
            d = d + dx + 1;
            if (d >= 0) {
                y--;
                dy -= 2;
                d = d - dy;
            }
        }
    }

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}
