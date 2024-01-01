/*
 * HappyNewYear
 *
 * Make by 65050171 and 65050368
 *
 * 2023-12-30
 * 
 * This file make by student id 65050171 and 65050368
 */

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class HappyNewYear extends JPanel {
    public static void main(String[] args) {
        HappyNewYear m = new HappyNewYear();
        JFrame frame = new JFrame();

        frame.add(m);
        frame.setTitle("Happy New Year 🎄🎅🏻❄️");
        frame.setResizable(false);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        BufferedImage originalImage;

        try {
            originalImage = ImageIO.read(new File("image.png"));
            // g.drawImage(resizeImage(originalImage, 584, 561), 0, 0, null);
        } catch (IOException e) {
            System.out.println(e);
        }

        /* Background */
        Color backgroundColor = new Color(153, 0, 0);
        Color outlineColor = new Color(87, 54, 53);

        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, 600, 600);

        /* Snow */
        g2.setColor(new Color(255, 250, 250));
        snow(g2, 229, 121);
        snow(g2, 249, 201);
        snow(g2, 500, 128);
        snow(g2, 520, 240);
        snow(g2, 208, 440);
        snow(g2, 206, 385);
        snow(g2, 556, 450);
        snow(g2, 546, 367);
        snow(g2, 537, 201);
        snow(g2, 502, 211);
        snow(g2, 486, 169);
        snow(g2, 261, 243);
        snow(g2, 243, 279);
        snow(g2, 324, 111);

        /* Letter Two */
        g2.setColor(new Color(118, 0, 0));
        drawLetterTwo(g2, 0, 0);
        drawLetterTwo(g2, 0, 141);

        /* Letter Zero */
        bezierCurve(g2, 105, 95, 106, 65, 118, 50, 142, 49);
        bezierCurve(g2, 105, 95, 108, 130, 125, 140, 144, 140);
        bezierCurve(g2, 142, 49, 165, 45, 180, 74, 178, 90);
        bezierCurve(g2, 179, 90, 178, 111, 178, 131, 144, 140);
        bezierCurve(g2, 124, 94, 126, 79, 125, 65, 142, 64);
        bezierCurve(g2, 124, 94, 124, 103, 123, 120, 142, 124);
        bezierCurve(g2, 142, 64, 160, 65, 157, 83, 159, 94);
        bezierCurve(g2, 159, 92, 160, 115, 150, 125, 142, 124);

        bezierCurve(g2, 126, 79, 131, 72, 135, 69, 142, 70);
        bezierCurve(g2, 157, 79, 153, 74, 150, 70, 142, 70);
        bezierCurve(g2, 111, 122, 118, 134, 128, 140, 144, 143);
        bezierCurve(g2, 173, 122, 169, 130, 161, 137, 144, 143);

        /* Letter Four */
        int xPoly[] = {146, 121, 146};
        int yPoly[] = {212, 246, 248};
        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
        g2.drawPolygon(poly);

        bresenhamLine(g2, 140, 190, 102, 248);
        bresenhamLine(g2, 140, 190, 165, 190);
        bresenhamLine(g2, 164, 191, 164, 250);
        bresenhamLine(g2, 103, 247, 103, 267);
        bresenhamLine(g2, 164, 247, 177, 247);
        bresenhamLine(g2, 175, 247, 175, 267);
        bresenhamLine(g2, 103, 266, 147, 266);
        bresenhamLine(g2, 146, 263, 146, 282);
        bresenhamLine(g2, 175, 266, 162, 266);
        bresenhamLine(g2, 146, 281, 166, 281);
        bresenhamLine(g2, 164, 262, 164, 282);
        bresenhamLine(g2, 103, 262, 147, 262);
        bresenhamLine(g2, 164, 262, 176, 262);

        /* Gift Box 6 */
        g2.setColor(new Color(249, 179, 23));
        bresenhamLine(g2, 131, 473, 192, 473);
        bresenhamLine(g2, 129, 483, 145, 483);
        bresenhamLine(g2, 155, 483, 165, 483);
        bresenhamLine(g2, 170, 483, 192, 483);
        bresenhamLine(g2, 191, 473, 191, 485);
        bresenhamLine(g2, 184, 483, 184, 495);
        bresenhamLine(g2, 184, 501, 184, 508);

        g2.setColor(new Color(250, 79, 66));
        bresenhamLine(g2, 144, 474, 144, 489);
        bresenhamLine(g2, 155, 474, 155, 489);
        bresenhamLine(g2, 155, 495, 155, 507);
        bresenhamLine(g2, 144, 502, 144, 508);

        g2.setColor(new Color(246, 157, 15));
        bresenhamLine(g2, 129, 486, 145, 486);
        bresenhamLine(g2, 155, 486, 165, 486);
        bresenhamLine(g2, 168, 486, 186, 486);

        g2.setColor(new Color(249, 86, 73));
        bezierCurve(g2, 140, 473, 132, 468, 120, 463, 136, 455);
        bezierCurve(g2, 145, 472, 138, 466, 135, 462, 135, 455);
        bezierCurve(g2, 144, 471, 158, 450, 169, 453, 171, 462);
        bezierCurve(g2, 149, 473, 157, 464, 165, 461, 170, 463);
        bresenhamLine(g2, 147, 464, 139, 468);

        g2.setColor(new Color(211, 19, 16));
        bezierCurve(g2, 159, 473, 163, 470, 167, 467, 171, 463);
        bezierCurve(g2, 157, 472, 162, 468, 164, 465, 164, 462);
        bezierCurve(g2, 136, 455, 141, 455, 144, 459, 147, 464);

        /* Gift Box 5 */
        g2.setColor(new Color(253, 63, 49));
        bresenhamLine(g2, 59, 468, 59, 481);
        bresenhamLine(g2, 59, 480, 64, 480);
        bresenhamLine(g2, 63, 480, 63, 525);
        bresenhamLine(g2, 59, 468, 132, 468);
        bresenhamLine(g2, 130, 468, 130, 480);
        bresenhamLine(g2, 128, 479, 132, 479);
        bresenhamLine(g2, 128, 478, 128, 505);
        bresenhamLine(g2, 63, 480, 70, 480);
        bresenhamLine(g2, 74, 480, 90, 480);
        bresenhamLine(g2, 98, 480, 105, 480);
        bresenhamLine(g2, 103, 468, 103, 483);
        bresenhamLine(g2, 111, 468, 111, 482);
        bresenhamLine(g2, 111, 495, 111, 503);
        bresenhamLine(g2, 82, 469, 82, 491);
        bresenhamLine(g2, 82, 501, 82, 507);

        g2.setColor(new Color(205, 35, 28));
        bresenhamLine(g2, 63, 483, 70, 483);
        bresenhamLine(g2, 74, 483, 88, 483);
        bresenhamLine(g2, 120, 483, 129, 483);

        g2.setColor(new Color(253, 221, 62));
        bresenhamLine(g2, 69, 468, 69, 507);
        bresenhamLine(g2, 74, 468, 74, 507);

        g2.setColor(new Color(252, 184, 40));
        bezierCurve(g2, 83, 467, 70, 462, 75, 457, 81, 453);
        bezierCurve(g2, 92, 467, 86, 462, 82, 457, 82, 453);
        bezierCurve(g2, 94, 467, 102, 462, 107, 457, 111, 453);
        bezierCurve(g2, 106, 467, 119, 461, 120, 458, 117, 453);

        g2.setColor(new Color(189, 117, 11));
        bezierCurve(g2, 94, 468, 93, 461, 90, 456, 82, 452);
        bezierCurve(g2, 94, 464, 98, 458, 101, 453, 116, 453);

        /* Gift Box 4 */
        g2.setColor(new Color(250, 148, 54));
        bresenhamLine(g2, 6, 478, 60, 478);
        bresenhamLine(g2, 6, 478, 6, 490);
        bresenhamLine(g2, 6, 489, 11, 489);
        bresenhamLine(g2, 9, 490, 9, 525);

        bresenhamLine(g2, 9, 492, 35, 492);
        bresenhamLine(g2, 40, 492, 64, 492);

        bresenhamLine(g2, 34, 478, 34, 509);
        bresenhamLine(g2, 39, 478, 39, 501);

        bresenhamLine(g2, 10, 489, 35, 489);
        bresenhamLine(g2, 38, 489, 64, 489);

        g2.setColor(new Color(149, 199, 34));
        bezierCurve(g2, 34, 478, 30, 478, 25, 481, 21, 487);
        bezierCurve(g2, 36, 476, 31, 473, 25, 475, 16, 487);
        bezierCurve(g2, 25, 476, 21, 472, 18, 468, 27, 462);
        bezierCurve(g2, 27, 475, 23, 469,22, 464, 24, 464);
        bezierCurve(g2, 37, 475, 34, 460, 29, 464, 22, 468);
        bezierCurve(g2, 38, 469, 34, 464, 29, 462, 23, 465);
        bezierCurve(g2, 38, 469, 41, 463, 45, 461, 53, 462);
        bezierCurve(g2, 39, 474, 40, 471, 45, 465, 52, 463);
        bezierCurve(g2, 53, 462, 55, 469, 52, 474, 49, 477);
        bezierCurve(g2, 46, 475, 49, 471, 52, 467, 53, 463);
        bezierCurve(g2, 39, 478, 45, 477, 48, 482, 51, 489);
        bezierCurve(g2, 38, 475, 44, 473, 54, 483, 55, 489);
        bresenhamLine(g2, 16, 484, 22, 488);

        /* Gift Box 3 */
        g2.setColor(new Color(60, 88, 204));
        bresenhamLine(g2, 141, 507, 197, 507);
        bresenhamLine(g2, 195, 507, 195, 521);
        bresenhamLine(g2, 195, 520, 192, 520);
        bresenhamLine(g2, 194, 519, 194, 562);
        bresenhamLine(g2, 193, 519, 162, 519);
        bresenhamLine(g2, 134, 519, 160, 519);
        bresenhamLine(g2, 194, 523, 162, 523);
        bresenhamLine(g2, 134, 523, 160, 523);
        bresenhamLine(g2, 159, 507, 159, 562);
        bresenhamLine(g2, 163, 507, 163, 562);
        bresenhamLine(g2, 193, 561, 133, 561);
        bresenhamLine(g2, 194, 546, 185, 562);
        bresenhamLine(g2, 194, 532, 175, 562);
        bresenhamLine(g2, 194, 519, 165, 562);
        bresenhamLine(g2, 193, 507, 163, 549);   
        bresenhamLine(g2, 156, 507, 134, 537);
        bresenhamLine(g2, 159, 520, 133, 555);
        bresenhamLine(g2, 147, 507, 134, 525);
        bresenhamLine(g2, 184, 508, 162, 536);
        bresenhamLine(g2, 172, 508, 163, 520);
        bresenhamLine(g2, 159, 550, 151, 562);
        bresenhamLine(g2, 159, 536, 139, 562);

        g2.setColor(new Color(105, 215, 248));
        bezierCurve(g2, 162, 503, 167, 498, 172, 497, 180, 495);
        bezierCurve(g2, 163, 506, 166, 503, 169, 502, 176, 501);
        bresenhamLine(g2, 166, 481, 171, 484);
        bresenhamLine(g2, 184, 495, 193, 496);
        bresenhamLine(g2, 183, 499, 191, 501);
        bresenhamLine(g2, 192, 496, 187, 503);
        bezierCurve(g2, 159, 508, 159, 501, 155, 495, 142, 491);
        bezierCurve(g2, 162, 506, 161, 495, 156, 486, 148, 488);
        bezierCurve(g2, 159, 492, 161, 488, 164, 483, 167, 481);
        bezierCurve(g2, 162, 493, 164, 489, 168, 486, 171, 483);
        bezierCurve(g2, 161, 496, 165, 489, 172, 480, 182, 492);
        bezierCurve(g2, 162, 499, 170, 492, 174, 489, 182, 493); 
        
        g2.setColor(new Color(28, 156, 202));
        bezierCurve(g2, 152, 508, 140, 501, 140, 493, 147, 488);
        bezierCurve(g2, 157, 508, 149, 501, 145, 496, 144, 490);
        bezierCurve(g2, 167, 507, 176, 501, 183, 496, 182, 493);
        bezierCurve(g2, 175, 508, 182, 502, 184, 496, 183, 493);

        /* Gift Box 2 */
        g2.setColor(new Color(250, 112, 110));
        bresenhamLine(g2, 73, 491, 78, 484);
        bezierCurve(g2, 88, 504, 81, 500, 76, 496, 72, 492);
        bezierCurve(g2, 100, 505, 89, 498, 81, 491, 77, 485);

        bezierCurve(g2, 93, 479, 105, 486, 106, 495, 101, 505);
        bezierCurve(g2, 93, 479, 101, 479, 106, 484, 106, 496);
        bezierCurve(g2, 104, 505, 113, 490, 122, 488, 129, 492);
        bezierCurve(g2, 106, 495, 113, 489, 123, 480, 129, 492);
        bezierCurve(g2, 115, 487, 120, 482, 123, 482, 128, 479);
        bezierCurve(g2, 105, 491, 110, 482, 119, 475, 124, 473);
        bresenhamLine(g2, 124, 473, 128, 480);

        g2.setColor(new Color(220, 51, 47));
        bezierCurve(g2, 90, 497, 86, 487, 87, 481, 93, 479);
        bezierCurve(g2, 100, 505, 95, 496, 92, 486, 93, 479);
        bezierCurve(g2, 117, 505, 125, 499, 129, 495, 129, 492);
        bezierCurve(g2, 104, 505, 117, 499, 125, 493, 129, 492);

        g2.setColor(new Color(143, 200, 22));
        bresenhamLine(g2, 141, 517, 141, 503);
        bresenhamLine(g2, 134, 517, 134, 562);
        bresenhamLine(g2, 70, 561, 136, 561);
        bresenhamLine(g2, 64, 517, 64, 503);
        bresenhamLine(g2, 65, 517, 80, 517);
        bresenhamLine(g2, 83, 517, 113, 517);
        bresenhamLine(g2, 141, 504, 63, 506);
        bresenhamLine(g2, 116, 517, 143, 517);
        bresenhamLine(g2, 71, 517, 71, 562);

        g2.setColor(new Color(140, 188, 13));
        bresenhamLine(g2, 71, 521, 80, 521);
        bresenhamLine(g2, 83, 521, 113, 521);
        bresenhamLine(g2, 116, 521, 135, 521);

        g2.setColor(new Color(253, 113, 119));
        bresenhamLine(g2, 78, 506, 78, 562);
        bresenhamLine(g2, 82, 506, 82, 562);

        g2.setColor(new Color(216, 82, 78));
        bresenhamLine(g2, 111, 505, 111, 562);
        bresenhamLine(g2, 116, 505, 116, 562);

        g2.setColor(new Color(141, 198, 17));
        bresenhamLine(g2, 91, 506, 91, 562);

        /* Gift Box 1 */
        g2.setColor(new Color(170, 58, 232));
        bezierCurve(g2, 30, 523, 22, 519, 15, 515, 13, 508);
        bezierCurve(g2, 34, 522, 26, 517, 19, 512, 16, 506);
        bezierCurve(g2, 46, 523, 55, 517, 61, 514, 63, 509);
        bezierCurve(g2, 58, 503, 64, 504, 62, 507, 63, 509);
        bezierCurve(g2, 42, 523, 53, 516, 56, 512, 60, 505);

        g2.setColor(new Color(198, 142, 218));
        bezierCurve(g2, 13, 508, 15, 507, 24, 495, 37, 515);
        bezierCurve(g2, 35, 523, 34, 516, 25, 505, 18, 505);
        bezierCurve(g2, 35, 512, 35, 508, 40, 501, 48, 492);
        bezierCurve(g2, 38, 513, 40, 508, 43, 503, 49, 495);
        bezierCurve(g2, 37, 515, 43, 506, 51, 501, 58, 502);
        bezierCurve(g2, 40, 523, 40, 513, 49, 502, 63, 507);
        bresenhamLine(g2, 47, 492, 50, 496);

        g2.setColor(new Color(250, 112, 108));
        bresenhamLine(g2, 0, 524, 72, 524);
        bresenhamLine(g2, 0, 532, 12, 532);
        bresenhamLine(g2, 16, 532, 54, 532);
        bresenhamLine(g2, 58, 532, 72, 532);
        bresenhamLine(g2, 0, 561, 73, 561);

        bresenhamLine(g2, 2, 532, 2, 562);
        bresenhamLine(g2, 27, 525, 27, 562);

        g2.setColor(new Color(214, 9, 10));
        bresenhamLine(g2, 2, 535, 12, 535);
        bresenhamLine(g2, 16, 535, 53, 535);
        bresenhamLine(g2, 58, 535, 72, 535);

        g2.setColor(new Color(210, 152, 228));
        bresenhamLine(g2, 11, 524, 11, 562);
        bresenhamLine(g2, 15, 524, 15, 562);

        g2.setColor(new Color(163, 52, 211));
        bresenhamLine(g2, 52, 524, 52, 562);
        bresenhamLine(g2, 57, 524, 57, 562);

        /* Star */
        g2.setColor(new Color(207, 58, 28));
        bresenhamLine(g2, 377, 141, 359, 149);
        bresenhamLine(g2, 361, 147, 365, 126);
        bresenhamLine(g2, 365, 127, 350, 112);
        bresenhamLine(g2, 352, 113, 373, 111);
        bresenhamLine(g2, 372, 111, 381, 95);
        bresenhamLine(g2, 380, 96, 389, 112);
        bresenhamLine(g2, 388, 111, 409, 114);
        bresenhamLine(g2, 408, 114, 392, 130);
        bresenhamLine(g2, 394, 128, 397, 147);
        bresenhamLine(g2, 397, 147, 382, 139);
        bezierCurve(g2, 373, 158, 377, 153, 377, 145, 377, 141);
        bezierCurve(g2, 389, 153, 388, 150, 386, 146, 385, 140);

        g2.setColor(new Color(255, 212, 0));
        bresenhamLine(g2, 356, 136, 345, 145);
        bresenhamLine(g2, 347, 122, 339, 121);
        bresenhamLine(g2, 356, 104, 348, 98);
        bresenhamLine(g2, 369, 99, 366, 91);
        bresenhamLine(g2, 393, 106, 401, 95);
        bresenhamLine(g2, 409, 109, 417, 105);
        bresenhamLine(g2, 403, 126, 419, 130);
        bresenhamLine(g2, 404, 137, 413, 143);

        /* Cat 16 */
        g2.setColor(new Color(127, 141, 141));
        bezierCurve(g2, 348, 224, 356, 213, 356, 198, 352, 183);
        bezierCurve(g2, 408, 183, 405, 190, 407, 195, 415, 200);
        bezierCurve(g2, 356, 174, 370, 182, 380, 174, 381, 161);
        bezierCurve(g2, 380, 160, 383, 178, 391, 180, 404, 174);

        g2.setColor(outlineColor);

        bresenhamLine(g2, 372, 160, 388, 160);
        bresenhamLine(g2, 363, 221, 369, 241);
        bresenhamLine(g2, 379, 237, 390, 237);
        bresenhamLine(g2, 387, 222, 388, 238);
        bresenhamLine(g2, 401, 222, 397, 237);
        bresenhamLine(g2, 367, 159, 369, 164);
        bresenhamLine(g2, 392, 158, 390, 163);

        bezierCurve(g2, 367, 236, 335, 233, 347, 195, 358, 171);
        bezierCurve(g2, 358, 171, 362, 149, 368, 150, 374, 161);
        bezierCurve(g2, 387, 161, 391, 151, 396, 147, 402, 166);
        bezierCurve(g2, 402, 166, 416, 200, 422, 214, 414, 224);
        bezierCurve(g2, 417, 217, 419, 199, 420, 182, 436, 178);
        bezierCurve(g2, 437, 178, 443, 185, 436, 191, 431, 198);
        bezierCurve(g2, 433, 194, 425, 212, 425, 235, 399, 237);
        bezierCurve(g2, 381, 222, 379, 240, 379, 245, 371, 241);
        bezierCurve(g2, 388, 236, 389, 245, 405, 245, 399, 236);

        bresenhamLine(g2, 361, 183, 345, 183);
        bresenhamLine(g2, 362, 187, 345, 187);
        bresenhamLine(g2, 400, 185, 415, 185);
        bezierCurve(g2, 347, 178, 353, 178, 357, 179, 360, 180);
        bezierCurve(g2, 398, 180, 403, 177, 407, 176, 412, 176);
        bezierCurve(g2, 400, 183, 403, 182, 407, 180, 415, 180);

        bezierCurve(g2, 365, 177, 366, 175, 368, 175, 370, 177);
        bezierCurve(g2, 390, 176, 392, 175, 394, 175, 395, 177);
        
        g2.setColor(new Color(247, 167, 163));
        drawCheek(g2, 359, 185, 6);
        drawCheek(g2, 390, 184, 6);

        g2.setColor(new Color(140, 141, 125));
        bezierCurve(g2, 374, 182, 377, 195, 382, 185, 382, 181);
        bezierCurve(g2, 381, 185, 385, 189, 389, 187, 389, 181);

        g2.setColor(new Color(41, 45, 51));
        drawNose(g2, 379, 180);

        /* Cat 15 */
        g2.setColor(outlineColor);

        bresenhamLine(g2, 448, 240, 467, 240);

        bezierCurve(g2, 440, 269, 432, 291, 415, 315, 452, 319);
        bezierCurve(g2, 445, 272, 441, 293, 441, 305, 453, 317);
        bezierCurve(g2, 473, 268, 475, 283, 475, 296, 467, 309);
        bezierCurve(g2, 476, 265, 475, 276, 509, 306, 473, 316);
        bezierCurve(g2, 453, 317, 454, 303, 452, 290, 460, 289);
        bezierCurve(g2, 460, 289, 466, 293, 465, 300, 461, 306);
        bezierCurve(g2, 453, 315, 450, 332, 457, 330, 459, 321);
        bezierCurve(g2, 435, 247, 436, 263, 434, 273, 459, 275);
        bezierCurve(g2, 436, 248, 428, 230, 435, 224, 448, 240);
        bezierCurve(g2, 466, 239, 475, 225, 483, 225, 477, 247);
        bezierCurve(g2, 476, 247, 480, 263, 476, 271, 459, 275);

        bezierCurve(g2, 435, 245, 455, 248, 438, 230, 433, 232);
        bezierCurve(g2, 478, 232, 475, 230, 461, 248, 477, 246);

        bezierCurve(g2, 456, 243, 435, 247, 430, 266, 457, 271);
        bezierCurve(g2, 456, 244, 480, 247, 482, 267, 457, 271);

        bezierCurve(g2, 444, 253, 445, 249, 452, 249, 453, 254);
        bezierCurve(g2, 444, 253, 445, 260, 452, 260, 453, 254);
        bezierCurve(g2, 461, 255, 464, 250, 466, 250, 468, 254);
        bezierCurve(g2, 461, 255, 464, 260, 466, 260, 468, 254);

        g2.setColor(new Color(186, 87, 72));
        bezierCurve(g2, 421, 265, 426, 262, 429, 262, 441, 262);
        bezierCurve(g2, 422, 269, 427, 266, 432, 265, 438, 265);
        bezierCurve(g2, 427, 273, 430, 270, 435, 268, 435, 267);
        bezierCurve(g2, 496, 263, 493, 261, 485, 261, 477, 261);
        bezierCurve(g2, 482, 265, 482, 265, 488, 266, 496, 268);
        bezierCurve(g2, 476, 264, 482, 265, 488, 266, 496, 268);
        bezierCurve(g2, 473, 267, 480, 268, 486, 269, 492, 272);

        g2.setColor(new Color(232, 157, 151));
        bezierCurve(g2, 443, 263, 445, 261, 449, 261, 450, 263);
        bezierCurve(g2, 443, 263, 445, 265, 449, 265, 450, 263);
        bezierCurve(g2, 462, 263, 464, 261, 468, 261, 469, 263);
        bezierCurve(g2, 462, 263, 464, 265, 468, 265, 469, 263);

        g2.setColor(new Color(148, 18, 15));
        bezierCurve(g2, 453, 262, 455, 265, 456, 265, 456, 262);
        bezierCurve(g2, 456, 262, 457, 264, 460, 264, 460, 262);

        g2.setColor(new Color(252, 255, 210));
        plot(g2, 446, 252, 3);
        plot(g2, 465, 253, 2);

        /* Cat 14 */
        g2.setColor(outlineColor);

        bresenhamLine(g2, 408, 301, 406, 316);
        bresenhamLine(g2, 392, 301, 393, 308);
        bresenhamLine(g2, 388, 304, 388, 312);
        bresenhamLine(g2, 372, 302, 378, 324);
        bresenhamLine(g2, 369, 244, 373, 247);
        bresenhamLine(g2, 408, 241, 406, 246);
        bresenhamLine(g2, 352, 264, 368, 269);
        bresenhamLine(g2, 349, 272, 367, 272);
        bresenhamLine(g2, 411, 269, 426, 266);
        bresenhamLine(g2, 411, 271, 425, 271);

        bezierCurve(g2, 363, 248, 357, 291, 345, 320, 383, 324);
        bezierCurve(g2, 362, 247, 365, 238, 368, 237, 376, 244);
        bezierCurve(g2, 362, 247, 365, 238, 368, 237, 376, 244);
        bezierCurve(g2, 375, 245, 384, 243, 390, 243, 400, 245);
        bezierCurve(g2, 402, 244, 407, 235, 410, 235, 415, 246);
        bezierCurve(g2, 414, 245, 425, 283, 426, 296, 424, 307);
        bezierCurve(g2, 367, 276, 360, 276, 356, 277, 351, 278);
        bezierCurve(g2, 410, 266, 415, 264, 418, 262, 424, 262);

        bezierCurve(g2, 376, 264, 378, 261, 382, 261, 383, 264);
        bezierCurve(g2, 396, 263, 398, 260, 401, 260, 402, 263);

        g2.setColor(new Color(247, 166, 162));
        bezierCurve(g2, 368, 272, 370, 267, 377, 267, 379, 272);
        bezierCurve(g2, 368, 272, 370, 278, 377, 278, 379, 272);
        bezierCurve(g2, 400, 269, 402, 264, 409, 264, 411, 269);
        bezierCurve(g2, 400, 269, 401, 276, 409, 276, 411, 269);

        g2.setColor(new Color(148, 18, 15));
        bezierCurve(g2, 387, 272, 387, 276, 389, 275, 390, 273);
        bezierCurve(g2, 390, 272, 392, 275, 394, 275, 394, 272);

        /* Cat 13 */
        g2.setColor(new Color(255, 163, 62));
        
        bezierCurve(g2, 286, 312, 295, 300, 294, 284, 291, 271);
        bezierCurve(g2, 295, 263, 305, 276, 317, 262, 317, 250);
        bezierCurve(g2, 341, 263, 329, 274, 318, 261, 317, 250);
        bezierCurve(g2, 345, 275, 344, 283, 345, 285, 351, 289);

        g2.setColor(outlineColor);

        bresenhamLine(g2, 310, 250, 324, 250);
        bresenhamLine(g2, 338, 312, 334, 325);
        bresenhamLine(g2, 323, 311, 323, 316);
        bresenhamLine(g2, 317, 311, 317, 320);
        bresenhamLine(g2, 301, 310, 306, 322);

        bezierCurve(g2, 302, 243, 294, 267, 275, 299, 290, 319);
        bezierCurve(g2, 302, 242, 307, 245, 310, 249, 311, 250);
        bezierCurve(g2, 323, 250, 330, 241, 333, 241, 337, 251);
        bezierCurve(g2, 337, 251, 342, 268, 359, 293, 351, 311);
        bezierCurve(g2, 351, 312, 356, 308, 352, 292, 357, 284);
        bezierCurve(g2, 336, 325, 344, 328, 354, 317, 358, 310);
        bezierCurve(g2, 335, 325, 339, 329, 333, 329, 330, 329);
        bezierCurve(g2, 303, 267, 304, 265, 306, 265, 308, 267);
        bezierCurve(g2, 326, 267, 328, 264, 330, 264, 332, 267);

        bresenhamLine(g2, 304, 248, 307, 252);
        bresenhamLine(g2, 329, 248, 326, 252);
        bresenhamLine(g2, 283, 273, 300, 273);
        bresenhamLine(g2, 285, 276, 300, 276);
        bresenhamLine(g2, 336, 275, 352, 275);
        bezierCurve(g2, 283, 268, 290, 268, 295, 269, 299, 271);
        bezierCurve(g2, 335, 270, 339, 268, 342, 267, 348, 265);
        bezierCurve(g2, 337, 273, 342, 270, 344, 270, 352, 270);

        g2.setColor(new Color(91, 94, 89));
        bezierCurve(g2, 311, 272, 312, 280, 319, 276, 319, 271);
        bezierCurve(g2, 326, 272, 323, 280, 319, 276, 319, 271);

        g2.setColor(new Color(44, 49, 54));
        drawNose(g2, 316, 270);

        g2.setColor(new Color(247, 166, 162));
        bezierCurve(g2, 299, 274, 300, 269, 308, 269, 307, 274);
        bezierCurve(g2, 299, 274, 300, 279, 308, 279, 307, 274);
        bezierCurve(g2, 327, 274, 328, 269, 336, 269, 335, 274);
        bezierCurve(g2, 327, 274, 328, 279, 336, 279, 335, 274);

        /* Cat 12 */
        g2.setColor(outlineColor);
        
        bresenhamLine(g2, 472, 315, 494, 315);

        bezierCurve(g2, 462, 346, 453, 373, 435, 386, 471, 402);
        bezierCurve(g2, 493, 350, 499, 374, 480, 380, 483, 393);
        bezierCurve(g2, 501, 347, 504, 360, 514, 373, 510, 390);
        bezierCurve(g2, 458, 320, 460, 330, 448, 345, 481, 355);
        bezierCurve(g2, 480, 355, 499, 351, 504, 341, 501, 325);
        bezierCurve(g2, 493, 316, 508, 300, 505, 309, 501, 325);
        bezierCurve(g2, 459, 320, 456, 297, 462, 308, 473, 315);
        bezierCurve(g2, 470, 351, 470, 367, 472, 377, 477, 391);

        bezierCurve(g2, 458, 307, 463, 308, 472, 317, 465, 323);
        bezierCurve(g2, 465, 323, 458, 326, 461, 326, 457, 312);
        bezierCurve(g2, 493, 315, 494, 325, 497, 327, 500, 325);

        bezierCurve(g2, 464, 330, 468, 322, 473, 322, 476, 330);
        bezierCurve(g2, 464, 330, 468, 338, 473, 338, 476, 330);
        bezierCurve(g2, 486, 330, 490, 322, 495, 322, 498, 330);
        bezierCurve(g2, 486, 330, 490, 338, 495, 338, 498, 330);
        bezierCurve(g2, 467, 330, 468, 325, 473, 325, 472, 330);
        bezierCurve(g2, 467, 330, 468, 334, 473, 334, 472, 330);
        bezierCurve(g2, 489, 330, 490, 325, 495, 325, 494, 330);
        bezierCurve(g2, 489, 330, 490, 334, 495, 334, 494, 330);

        g2.setColor(new Color(188, 91, 75));
        bezierCurve(g2, 497, 340, 507, 339, 513, 342, 521, 344);
        bezierCurve(g2, 499, 343, 509, 347, 514, 348, 523, 351);
        bezierCurve(g2, 497, 345, 505, 348, 510, 349, 516, 354);
        bezierCurve(g2, 464, 344, 459, 345, 455, 348, 448, 349);
        bezierCurve(g2, 464, 342, 456, 343, 449, 344, 440, 348);
        bezierCurve(g2, 464, 340, 456, 339, 447, 339, 440, 342);

        g2.setColor(new Color(144, 144, 125));
        bezierCurve(g2, 477, 342, 478, 344, 480, 348, 481, 340);
        bezierCurve(g2, 481, 340, 482, 343, 482, 347, 485, 342);

        g2.setColor(new Color(255, 173, 168));
        bezierCurve(g2, 466, 343, 468, 341, 470, 341, 471, 343);
        bezierCurve(g2, 466, 343, 468, 345, 470, 345, 471, 343);
        bezierCurve(g2, 491, 343, 493, 341, 495, 341, 496, 343);
        bezierCurve(g2, 491, 343, 493, 345, 495, 345, 496, 343);

        g2.setColor(new Color(255, 173, 168));
        bezierCurve(g2, 478, 338, 481, 336, 483, 336, 483, 338);
        bezierCurve(g2, 478, 338, 481, 340, 483, 340, 483, 338);

        g2.setColor(new Color(255, 255, 215));
        plot(g2, 468, 327, 3);
        plot(g2, 490, 327, 3);

        g2.setColor(new Color(116, 9, 10));
        bezierCurve(g2, 466, 350, 462, 373, 465, 386, 472, 402);
        bezierCurve(g2, 497, 346, 499, 371, 493, 384, 488, 394);

        /* Cat 11 */
        g2.setColor(outlineColor);

        bresenhamLine(g2, 397, 315, 420, 315);
        bresenhamLine(g2, 361, 388, 377, 397);
        bresenhamLine(g2, 380, 390, 392, 391);
        bresenhamLine(g2, 390, 384, 394, 389);
        bresenhamLine(g2, 404, 379, 405, 396);
        bresenhamLine(g2, 421, 380, 428, 396);
        bresenhamLine(g2, 393, 316, 397, 320);
        bresenhamLine(g2, 422, 316, 419, 320);
        bresenhamLine(g2, 373, 330, 391, 333);
        bresenhamLine(g2, 389, 335, 367, 335);
        bresenhamLine(g2, 389, 339, 367, 339);
        bresenhamLine(g2, 424, 334, 439, 334);
        bresenhamLine(g2, 422, 337, 442, 338);
        bresenhamLine(g2, 425, 340, 440, 342);
        bresenhamLine(g2, 405, 333, 405, 342);

        bezierCurve(g2, 386, 318, 367, 349, 350, 369, 353, 392);
        bezierCurve(g2, 386, 319, 390, 305, 393, 305, 398, 315);
        bezierCurve(g2, 419, 315, 429, 290, 432, 347, 434, 391);
        bezierCurve(g2, 377, 370, 380, 378, 381, 387, 381, 391);
        bezierCurve(g2, 376, 397, 382, 398, 384, 395, 381, 392);
        bezierCurve(g2, 404, 391, 410, 391, 417, 389, 423, 385);
        bezierCurve(g2, 394, 330, 395, 333, 396, 333, 398, 330);
        bezierCurve(g2, 413, 330, 414, 323, 420, 323, 421, 330);
        bezierCurve(g2, 413, 330, 414, 336, 420, 336, 421, 330);

        plot(g2, 418, 329, 2);

        g2.setColor(new Color(43, 48, 53));
        drawNose(g2, 403, 332);

        g2.setColor(new Color(247, 168, 163));
        drawCheek(g2, 385, 338, 6);
        drawCheek(g2, 415, 338, 6);

        g2.setColor(new Color(149, 0, 0));
        bezierCurve(g2, 359, 362, 368, 366, 368, 360, 364, 355);
        bezierCurve(g2, 365, 351, 381, 363, 383, 346, 370, 345);
        bezierCurve(g2, 433, 365, 426, 363, 426, 359, 433, 358);
        bezierCurve(g2, 431, 347, 424, 349, 422, 354, 432, 355);

        /* Cat 10 */
        g2.setColor(outlineColor);

        bresenhamLine(g2, 304, 321, 319, 321);
        bresenhamLine(g2, 287, 383, 290, 390);
        bresenhamLine(g2, 304, 385, 303, 400);
        bresenhamLine(g2, 303, 398, 313, 398);
        bresenhamLine(g2, 310, 384, 310, 400);
        bresenhamLine(g2, 327, 382, 322, 393);
        bresenhamLine(g2, 291, 348, 274, 343);
        bresenhamLine(g2, 290, 351, 272, 349);
        bresenhamLine(g2, 290, 354, 274, 355);
        bresenhamLine(g2, 330, 355, 348, 355);
        bresenhamLine(g2, 330, 353, 348, 351);
        bresenhamLine(g2, 330, 349, 345, 346);
        bresenhamLine(g2, 298, 321, 301, 327);
        bresenhamLine(g2, 321, 322, 319, 327);

        bezierCurve(g2, 253, 352, 264, 362, 266, 379, 273, 391);
        bezierCurve(g2, 253, 352, 264, 362, 266, 379, 273, 391);
        bezierCurve(g2, 305, 323, 293, 290, 272, 365, 274, 387);
        bezierCurve(g2, 317, 320, 323, 313, 325, 313, 330, 326);
        bezierCurve(g2, 256, 355, 245, 340, 257, 335, 267, 348);
        bezierCurve(g2, 266, 347, 271, 358, 273, 372, 275, 385);
        bezierCurve(g2, 330, 325, 340, 352, 350, 374, 337, 395);
        bezierCurve(g2, 304, 398, 302, 403, 300, 404, 295, 405);

        bezierCurve(g2, 295, 344, 297, 335, 303, 335, 304, 344);
        bezierCurve(g2, 295, 344, 297, 350, 303, 350, 304, 344);
        bezierCurve(g2, 314, 344, 316, 335, 322, 335, 323, 344);
        bezierCurve(g2, 314, 344, 316, 350, 322, 350, 323, 344);

        g2.setColor(new Color(182, 74, 61));
        bezierCurve(g2, 306, 353, 307, 356, 308, 356, 310, 353);
        bezierCurve(g2, 310, 352, 310, 356, 313, 356, 313, 353);

        g2.setColor(new Color(252, 255, 210));
        plot(g2, 300, 344, 2);
        plot(g2, 318, 344, 2);

        g2.setColor(new Color(247, 167, 163));
        drawCheek(g2, 293, 354, 4);
        drawCheek(g2, 320, 353, 4);

        g2.setColor(new Color(149, 155, 155));
        bezierCurve(g2, 275, 364, 281, 364, 285, 355, 280, 350);
        bezierCurve(g2, 338, 348, 334, 363, 334, 375, 340, 387);
        bezierCurve(g2, 284, 335, 286, 339, 289, 342, 293, 341);
        bezierCurve(g2, 293, 341, 296, 330, 301, 332, 306, 335);
        bezierCurve(g2, 305, 335, 307, 335, 309, 333, 310, 322);
        bezierCurve(g2, 310, 322, 312, 330, 313, 334, 314, 335);
        bezierCurve(g2, 314, 335, 317, 333, 323, 330, 327, 338);
        bresenhamLine(g2, 327, 338, 336, 335);

        /* Cat 9 */
        g2.setColor(outlineColor);
        
        bresenhamLine(g2, 480, 455, 485, 467);
        bresenhamLine(g2, 495, 455, 494, 467);
        bresenhamLine(g2, 505, 452, 509, 466);
        bresenhamLine(g2, 521, 451, 518, 467);
        bresenhamLine(g2, 494, 467, 508, 467);
        bresenhamLine(g2, 480, 394, 483, 398);
        bresenhamLine(g2, 514, 392, 511, 396);
        bresenhamLine(g2, 499, 413, 499, 422);
        bresenhamLine(g2, 477, 414, 462, 414);
        bresenhamLine(g2, 478, 418, 461, 419);
        bresenhamLine(g2, 478, 421, 464, 423);
        bresenhamLine(g2, 516, 412, 533, 407);
        bresenhamLine(g2, 519, 414, 537, 414);
        bresenhamLine(g2, 519, 419, 535, 419);

        bezierCurve(g2, 474, 396, 475, 424, 455, 460, 483, 466);
        bezierCurve(g2, 475, 396, 476, 388, 477, 388, 484, 394);
        bezierCurve(g2, 484, 395, 494, 393, 503, 392, 509, 393);
        bezierCurve(g2, 508, 393, 514, 386, 517, 386, 521, 396);
        bezierCurve(g2, 520, 396, 530, 421, 538, 447, 534, 464);
        bezierCurve(g2, 483, 466, 487, 471, 491, 469, 495, 467);
        bezierCurve(g2, 512, 467, 519, 466, 524, 465, 528, 457);
        bezierCurve(g2, 505, 467, 483, 475, 483, 488, 500, 485);
        bezierCurve(g2, 482, 409, 483, 406, 486, 406, 489, 409);
        bezierCurve(g2, 508, 407, 510, 404, 511, 404, 514, 407);

        g2.setColor(new Color(252, 255, 210));
        bezierCurve(g2, 501, 470, 498, 474, 500, 477, 502, 479);

        g2.setColor(new Color(123, 76, 32));
        bezierCurve(g2, 467, 437, 476, 441, 476, 450, 468, 456);
        bezierCurve(g2, 472, 409, 479, 409, 486, 403, 489, 395);
        bezierCurve(g2, 491, 393, 493, 403, 502, 403, 505, 393);
        bezierCurve(g2, 529, 422, 526, 432, 528, 438, 534, 444);

        g2.setColor(new Color(252, 255, 210));
        drawCheek(g2, 478, 418, 6);
        drawCheek(g2, 508, 416, 6);

        g2.setColor(new Color(44, 53, 61));
        drawNose(g2, 496, 413);

        /* Cat 8 */
        g2.setColor(outlineColor);
        
        bresenhamLine(g2, 399, 458, 406, 480);
        bresenhamLine(g2, 417, 456, 415, 480);
        bresenhamLine(g2, 423, 458, 426, 479);
        bresenhamLine(g2, 439, 456, 434, 472);
        bresenhamLine(g2, 415, 478, 428, 478);
        bresenhamLine(g2, 402, 477, 406, 478);
        bresenhamLine(g2, 394, 392, 397, 398);
        bresenhamLine(g2, 436, 391, 434, 398);
        bresenhamLine(g2, 395, 420, 378, 417);
        bresenhamLine(g2, 396, 423, 378, 423);
        bresenhamLine(g2, 396, 426, 380, 427);
        bresenhamLine(g2, 440, 418, 456, 414);
        bresenhamLine(g2, 439, 422, 461, 420);
        bresenhamLine(g2, 441, 427, 459, 428);

        bezierCurve(g2, 391, 396, 385, 433, 373, 461, 396, 475);
        bezierCurve(g2, 391, 396, 391, 387, 397, 387, 402, 395);
        bezierCurve(g2, 403, 395, 413, 393, 420, 393, 429, 395);
        bezierCurve(g2, 430, 395, 435, 385, 439, 385, 443, 395);
        bezierCurve(g2, 442, 395, 450, 411, 465, 465, 445, 475);
        bezierCurve(g2, 406, 479, 407, 482, 413, 482, 415, 479);
        bezierCurve(g2, 400, 412, 402, 415, 404, 416, 405, 412);
        bezierCurve(g2, 427, 412, 428, 415, 432, 415, 433, 412);

        g2.setColor(new Color(177, 61, 50));
        bezierCurve(g2, 414, 424, 415, 426, 417, 427, 418, 423);
        bezierCurve(g2, 418, 423, 419, 427, 421, 427, 422, 424);

        g2.setColor(new Color(149, 155, 155));
        bezierCurve(g2, 385, 463, 393, 452, 390, 442, 384, 431);
        bezierCurve(g2, 423, 394, 423, 406, 433, 413, 446, 410);
        bezierCurve(g2, 454, 436, 449, 441, 449, 449, 455, 451);
        bresenhamLine(g2, 403, 468, 417, 468);
        bresenhamLine(g2, 424, 468, 437, 468);

        g2.setColor(new Color(247, 167, 163));
        drawCheek(g2, 399, 424, 4);
        drawCheek(g2, 428, 425, 4);

        /* Cat 7 */
        g2.setColor(outlineColor);

        bresenhamLine(g2, 327, 394, 354, 394);
        bresenhamLine(g2, 315, 460, 319, 470);
        bresenhamLine(g2, 331, 461, 328, 483);
        bresenhamLine(g2, 344, 460, 346, 478);
        bresenhamLine(g2, 361, 457, 355, 478);
        bresenhamLine(g2, 339, 416, 339, 425);
        bresenhamLine(g2, 329, 476, 347, 476);
        bresenhamLine(g2, 359, 394, 355, 397);
        bresenhamLine(g2, 317, 393, 320, 397);
        bresenhamLine(g2, 315, 415, 301, 413);
        bresenhamLine(g2, 316, 419, 302, 419);
        bresenhamLine(g2, 316, 423, 302, 423);
        bresenhamLine(g2, 363, 423, 378, 425);
        bresenhamLine(g2, 362, 419, 379, 419);
        bresenhamLine(g2, 362, 416, 376, 413);

        bezierCurve(g2, 322, 410, 322, 407, 326, 407, 328, 410);
        bezierCurve(g2, 351, 409, 353, 406, 355, 406, 356, 409);
        bezierCurve(g2, 313, 395, 312, 429, 288, 465, 315, 473);
        bezierCurve(g2, 313, 396, 316, 385, 318, 385, 326, 393);
        bezierCurve(g2, 353, 394, 359, 388, 363, 388, 364, 395);
        bezierCurve(g2, 364, 393, 370, 413, 385, 460, 373, 477);
        bezierCurve(g2, 325, 482, 336, 475, 355, 485, 372, 467);
        bezierCurve(g2, 327, 498, 341, 493, 349, 493, 360, 490);

        g2.setColor(new Color(174, 124, 73));
        bezierCurve(g2, 311, 409, 319, 408, 325, 403, 328, 395);
        bezierCurve(g2, 333, 395, 337, 402, 341, 402, 347, 395);
        bezierCurve(g2, 376, 447, 370, 443, 370, 435, 373, 430);
        bezierCurve(g2, 336, 478, 332, 485, 333, 488, 342, 494);

        g2.setColor(new Color(247, 166, 162));
        drawCheek(g2, 317, 420, 5);
        drawCheek(g2, 352, 420, 5);
        
        g2.setColor(new Color(48, 53, 57));
        drawNose(g2, 337, 415);

        /* Cat 6 */
        g2.setColor(outlineColor);
        
        bresenhamLine(g2, 250, 387, 254, 392);
        bresenhamLine(g2, 290, 392, 288, 397);
        bresenhamLine(g2, 239, 449, 242, 469);
        bresenhamLine(g2, 256, 454, 250, 474);
        bresenhamLine(g2, 250, 471, 262, 473);
        bresenhamLine(g2, 261, 452, 261, 474);
        bresenhamLine(g2, 277, 455, 269, 474);
        bresenhamLine(g2, 229, 406, 244, 414);
        bresenhamLine(g2, 224, 411, 243, 416);
        bresenhamLine(g2, 241, 420, 224, 418);
        bresenhamLine(g2, 286, 418, 302, 417);
        bresenhamLine(g2, 286, 422, 300, 423);
        bresenhamLine(g2, 286, 426, 300, 428);

        bezierCurve(g2, 242, 391, 226, 439, 218, 462, 242, 468);
        bezierCurve(g2, 243, 390, 246, 381, 251, 381, 257, 390);
        bezierCurve(g2, 257, 390, 267, 389, 273, 389, 283, 394);
        bezierCurve(g2, 284, 394, 290, 386, 296, 386, 297, 398);
        bezierCurve(g2, 295, 395, 297, 444, 307, 466, 270, 474);
        bezierCurve(g2, 253, 411, 257, 407, 259, 408, 259, 411);
        bezierCurve(g2, 274, 413, 276, 410, 279, 410, 280, 413);
        bezierCurve(g2, 274, 413, 276, 410, 279, 410, 280, 413);
        bezierCurve(g2, 240, 468, 240, 474, 240, 474, 245, 474);
        bezierCurve(g2, 261, 473, 264, 478, 268, 478, 269, 473);

        g2.setColor(new Color(148, 15, 13));
        bezierCurve(g2, 262, 420, 262, 425, 264, 425, 266, 420);
        bezierCurve(g2, 266, 422, 266, 425, 268, 425, 269, 420);

        g2.setColor(new Color(247, 166, 162));
        drawCheek(g2, 242, 418, 6);
        drawCheek(g2, 275, 422, 6);

        /* Cat 5 */
        g2.setColor(outlineColor);
        
        bresenhamLine(g2, 515, 472, 532, 472);
        bresenhamLine(g2, 530, 472, 537, 462);
        bresenhamLine(g2, 506, 534, 512, 548);
        bresenhamLine(g2, 523, 532, 521, 548);
        bresenhamLine(g2, 520, 548, 532, 548);
        bresenhamLine(g2, 530, 533, 530, 548);
        bresenhamLine(g2, 544, 534, 539, 548);
        bresenhamLine(g2, 504, 497, 490, 495);
        bresenhamLine(g2, 504, 500, 491, 500);
        bresenhamLine(g2, 540, 496, 556, 493);
        bresenhamLine(g2, 540, 498, 555, 498);
        bresenhamLine(g2, 509, 470, 512, 476);
        bresenhamLine(g2, 535, 470, 531, 476);

        bezierCurve(g2, 507, 466, 494, 497, 475, 545, 510, 549);
        bezierCurve(g2, 537, 464, 554, 497, 561, 524, 556, 534);
        bezierCurve(g2, 508, 465, 513, 470, 515, 471, 516, 473);
        bezierCurve(g2, 511, 548, 512, 554, 519, 554, 521, 548);
        bezierCurve(g2, 530, 548, 533, 555, 545, 555, 540, 546);
        bezierCurve(g2, 540, 548, 571, 550, 565, 507, 579, 500);
        bezierCurve(g2, 557, 531, 560, 509, 565, 490, 575, 491);
        bezierCurve(g2, 573, 490, 577, 490, 580, 493, 579, 500);
        bezierCurve(g2, 508, 490, 509, 487, 511, 487, 513, 491);
        bezierCurve(g2, 532, 491, 534, 487, 535, 487, 537, 491);
        bezierCurve(g2, 532, 491, 534, 487, 535, 487, 537, 491);
        bezierCurve(g2, 517, 495, 515, 498, 521, 505, 522, 495);
        bezierCurve(g2, 523, 496, 526, 502, 530, 505, 531, 494);
        bezierCurve(g2, 504, 493, 500, 491, 496, 491, 490, 490);
        bezierCurve(g2, 540, 494, 545, 490, 547, 489, 552, 488);

        g2.setColor(new Color(255, 163, 62));
        bezierCurve(g2, 500, 486, 515, 495, 520, 483, 522, 474);
        bezierCurve(g2, 547, 487, 535, 495, 523, 483, 522, 474);
        bezierCurve(g2, 492, 534, 498, 532, 499, 512, 494, 497);
        bezierCurve(g2, 550, 497, 545, 504, 551, 510, 555, 514);

        g2.setColor(new Color(247, 167, 163));
        drawCheek(g2, 504, 497, 5);
        drawCheek(g2, 534, 497, 5);

        g2.setColor(new Color(37, 42, 49));
        drawNose(g2, 520, 494);

        /* Cat 4 */
        g2.setColor(outlineColor);

        bresenhamLine(g2, 438, 476, 465, 476);
        bresenhamLine(g2, 468, 475, 465, 479);
        bresenhamLine(g2, 432, 475, 436, 479);
        bresenhamLine(g2, 429, 535, 432, 546);
        bresenhamLine(g2, 443, 535, 442, 552);
        bresenhamLine(g2, 455, 535, 457, 552);
        bresenhamLine(g2, 470, 533, 466, 549);
        bresenhamLine(g2, 441, 550, 458, 550);
        bresenhamLine(g2, 429, 498, 415, 498);
        bresenhamLine(g2, 471, 498, 487, 498);
        bresenhamLine(g2, 450, 496, 450, 505);
        bresenhamLine(g2, 434, 561, 476, 561);

        bezierCurve(g2, 426, 478, 430, 504, 401, 532, 430, 548);
        bezierCurve(g2, 427, 479, 429, 468, 432, 468, 438, 475);
        bezierCurve(g2, 463, 475, 467, 470, 473, 470, 474, 477);
        bezierCurve(g2, 474, 477, 477, 501, 498, 535, 474, 560);
        bezierCurve(g2, 479, 543, 467, 555, 443, 550, 434, 560);
        bezierCurve(g2, 425, 488, 432, 488, 439, 484, 441, 475);
        bezierCurve(g2, 443, 476, 448, 482, 453, 482, 458, 476);
        bezierCurve(g2, 434, 490, 436, 486, 438, 487, 439, 489);
        bezierCurve(g2, 460, 490, 461, 487, 465, 487, 466, 490);
        bezierCurve(g2, 431, 546, 431, 555, 438, 555, 440, 550);
        bezierCurve(g2, 416, 493, 425, 494, 420, 493, 429, 496);
        bezierCurve(g2, 429, 502, 425, 502, 422, 501, 415, 503);
        bezierCurve(g2, 470, 495, 475, 494, 479, 492, 482, 492);
        bezierCurve(g2, 471, 502, 476, 502, 481, 502, 487, 504);
        bezierCurve(g2, 446, 552, 445, 555, 444, 558, 445, 560);
        bezierCurve(g2, 480, 506, 479, 512, 479, 517, 483, 525);

        g2.setColor(new Color(45, 50, 55));
        drawNose(g2, 448, 495);

        g2.setColor(new Color(247, 167, 163));
        drawCheek(g2, 431, 499, 5);
        drawCheek(g2, 462, 499, 5);

        /* Cat 3 */
        g2.setColor(outlineColor);

        bresenhamLine(g2, 340, 545, 354, 553);
        bresenhamLine(g2, 370, 543, 377, 556);
        bresenhamLine(g2, 382, 538, 382, 551);
        bresenhamLine(g2, 397, 539, 401, 550);
        bresenhamLine(g2, 372, 480, 374, 484);
        bresenhamLine(g2, 397, 480, 395, 485);
        bresenhamLine(g2, 383, 498, 383, 505);
        bresenhamLine(g2, 350, 504, 365, 504);
        bresenhamLine(g2, 365, 501, 352, 501);
        bresenhamLine(g2, 368, 499, 355, 495);
        bresenhamLine(g2, 398, 499, 413, 499);
        bresenhamLine(g2, 399, 502, 413, 502);
        bresenhamLine(g2, 400, 505, 412, 505);
        bresenhamLine(g2, 339, 561, 360, 561);

        bezierCurve(g2, 364, 485, 347, 516, 325, 541, 339, 562);
        bezierCurve(g2, 340, 545, 340, 554, 350, 560, 360, 561);
        bezierCurve(g2, 364, 485, 368, 470, 370, 470, 377, 482);
        bezierCurve(g2, 377, 483, 383, 481, 387, 481, 393, 483);
        bezierCurve(g2, 393, 483, 399, 472, 400, 472, 403, 484);
        bezierCurve(g2, 403, 485, 406, 511, 410, 527, 406, 546);
        bezierCurve(g2, 356, 530, 359, 538, 359, 545, 359, 549);
        bezierCurve(g2, 353, 552, 358, 554, 364, 552, 359, 549);
        bezierCurve(g2, 359, 548, 365, 550, 368, 550, 372, 549);
        bezierCurve(g2, 377, 556, 381, 555, 390, 554, 382, 550);
        bezierCurve(g2, 382, 548, 389, 547, 394, 546, 398, 544);
        bezierCurve(g2, 400, 548, 401, 550, 416, 555, 406, 544);
        bezierCurve(g2, 373, 494, 375, 497, 376, 497, 377, 494);
        bezierCurve(g2, 390, 495, 392, 490, 395, 490, 397, 495);
        bezierCurve(g2, 390, 495, 392, 499, 395, 499, 397, 495);

        plot(g2, 394, 494, 2);
        drawNose(g2, 381, 496);

        g2.setColor(new Color(253, 255, 210));
        drawCheek(g2, 365, 503, 5);
        drawCheek(g2, 392, 503, 5);

        /* Cat 2 */
        g2.setColor(outlineColor);

        bresenhamLine(g2, 283, 474, 286, 477);
        bresenhamLine(g2, 319, 475, 317, 478);
        bresenhamLine(g2, 300, 496, 300, 505);
        bresenhamLine(g2, 280, 528, 284, 547);
        bresenhamLine(g2, 296, 531, 293, 550);
        bresenhamLine(g2, 300, 530, 301, 551);
        bresenhamLine(g2, 315, 531, 309, 548);
        bresenhamLine(g2, 293, 550, 302, 550);
        bresenhamLine(g2, 265, 503, 279, 504);
        bresenhamLine(g2, 318, 498, 332, 498);
        bresenhamLine(g2, 319, 501, 334, 500);

        bezierCurve(g2, 319, 497, 323, 495, 327, 494, 333, 494);
        bezierCurve(g2, 266, 493, 271, 495, 276, 495, 280, 497);
        bezierCurve(g2, 263, 499, 267, 499, 274, 499, 279, 500);
        bezierCurve(g2, 302, 550, 304, 552, 313, 552, 309, 549);
        bezierCurve(g2, 283, 546, 284, 553, 292, 553, 294, 548);
        bezierCurve(g2, 296, 505, 300, 503, 302, 503, 304, 505);
        bezierCurve(g2, 296, 505, 300, 507, 302, 507, 304, 505);
        bezierCurve(g2, 298, 494, 300, 492, 301, 492, 302, 494);
        bezierCurve(g2, 298, 494, 300, 496, 301, 496, 302, 494);
        bezierCurve(g2, 287, 491, 289, 494, 291, 494, 292, 491);
        bezierCurve(g2, 310, 491, 312, 494, 313, 494, 315, 491);
        bezierCurve(g2, 276, 478, 270, 509, 257, 540, 283, 549);
        bezierCurve(g2, 276, 478, 282, 465, 282, 465, 288, 475);
        bezierCurve(g2, 288, 476, 296, 473, 305, 473, 314, 476);
        bezierCurve(g2, 314, 476, 320, 469, 321, 469, 324, 476);
        bezierCurve(g2, 324, 476, 330, 514, 342, 547, 310, 549);

        g2.setColor(new Color(247, 171, 75));
        bezierCurve(g2, 296, 474, 300, 484, 280, 495, 275, 487);
        bezierCurve(g2, 267, 525, 274, 522, 271, 518, 268, 512);
        bezierCurve(g2, 329, 508, 325, 518, 320, 528, 329, 534);
        bezierCurve(g2, 301, 531, 305, 535, 305, 539, 302, 543);

        g2.setColor(new Color(247, 166, 162));
        drawCheek(g2, 281, 501, 5);
        drawCheek(g2, 310, 501, 5);

        /* Cat 1 */
        g2.setColor(outlineColor);
        
        bresenhamLine(g2, 209, 478, 198, 529);
        bresenhamLine(g2, 199, 528, 200, 544);
        bresenhamLine(g2, 214, 474, 220, 478);
        bresenhamLine(g2, 220, 478, 243, 478);
        bresenhamLine(g2, 242, 478, 250, 472);
        bresenhamLine(g2, 249, 472, 253, 480);
        bresenhamLine(g2, 253, 479, 258, 510);
        bresenhamLine(g2, 213, 532, 217, 548);
        bresenhamLine(g2, 228, 535, 225, 550);
        bresenhamLine(g2, 238, 535, 239, 549);
        bresenhamLine(g2, 250, 534, 247, 547);
        bresenhamLine(g2, 247, 546, 251, 548);
        bresenhamLine(g2, 216, 479, 219, 481);
        bresenhamLine(g2, 247, 478, 244, 481);
        bresenhamLine(g2, 200, 494, 212, 497);
        bresenhamLine(g2, 197, 499, 211, 500);
        bresenhamLine(g2, 231, 498, 231, 503);
        bresenhamLine(g2, 250, 495, 264, 495);
        bresenhamLine(g2, 251, 500, 264, 500);
        bresenhamLine(g2, 251, 503, 264, 503);
        bresenhamLine(g2, 217, 560, 246, 560);

        bezierCurve(g2, 209, 478, 212, 470, 212, 470, 220, 478);
        bezierCurve(g2, 204, 541, 214, 555, 238, 540, 246, 560);
        bezierCurve(g2, 200, 543, 205, 560, 211, 561, 216, 560);
        bezierCurve(g2, 234, 549, 265, 554, 268, 529, 258, 505);
        bezierCurve(g2, 217, 493, 217, 490, 222, 490, 222, 493);
        bezierCurve(g2, 241, 492, 241, 489, 246, 489, 246, 492);
        bezierCurve(g2, 229, 496, 231, 495, 232, 495, 233, 496);
        bezierCurve(g2, 229, 496, 231, 499, 232, 499, 233, 496);

        g2.setColor(new Color(251, 173, 168));
        bezierCurve(g2, 212, 502, 213, 498, 220, 498, 221, 500);
        bezierCurve(g2, 212, 502, 213, 506, 220, 506, 221, 500);
        bezierCurve(g2, 242, 502, 241, 497, 247, 498, 248, 501);
        bezierCurve(g2, 242, 502, 241, 506, 247, 506, 248, 501);

        g2.setColor(new Color(149, 155, 155));
        bezierCurve(g2, 234, 550, 236, 557, 238, 556, 232, 561);
        bezierCurve(g2, 200, 525, 205, 525, 208, 507, 202, 507);
        bezierCurve(g2, 225, 478, 225, 484, 238, 484, 238, 478);
        bezierCurve(g2, 240, 479, 245, 489, 245, 489, 255, 491);

        /* Flood Fill Cat 1 */
        floodfill(buffer, 233, 526, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 240, 556, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 202, 518, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 232, 481, backgroundColor, new Color(149, 155, 155));   
        floodfill(buffer, 248, 484, backgroundColor, new Color(149, 155, 155));   
        floodfill(buffer, 218, 502, backgroundColor, new Color(251, 173, 168));
        floodfill(buffer, 246, 501, backgroundColor, new Color(251, 173, 168));
        floodfill(buffer, 230, 496, backgroundColor, new Color(44, 49, 54));
        
        /* Flood Fill Cat 2 */
        floodfill(buffer, 298, 522, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 324, 499, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 324, 497, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 285, 484, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 327, 527, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 269, 521, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 302, 539, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 284, 502, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 314, 502, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 300, 504, backgroundColor, new Color(61, 65, 66));
        floodfill(buffer, 300, 494, backgroundColor, new Color(61, 65, 66));

        /* Flood Fill Cat 3 */
        floodfill(buffer, 382, 515, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 393, 496, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 362, 499, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 403, 501, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 403, 504, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 369, 504, backgroundColor, new Color(253, 255, 210));
        floodfill(buffer, 395, 504, backgroundColor, new Color(253, 255, 210));
        floodfill(buffer, 383, 495, backgroundColor, new Color(58, 61, 62));

        /* Flood Fill Cat 4 */
        floodfill(buffer, 452, 521, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 475, 496, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 433, 482, backgroundColor, new Color(174, 124, 73));
        floodfill(buffer, 441, 558, backgroundColor, new Color(174, 124, 73));
        floodfill(buffer, 450, 477, backgroundColor, new Color(174, 124, 73));
        floodfill(buffer, 480, 513, backgroundColor, new Color(174, 124, 73));
        floodfill(buffer, 435, 500, backgroundColor, new Color(247, 167, 163));
        floodfill(buffer, 466, 500, backgroundColor, new Color(247, 167, 163));
        floodfill(buffer, 451, 495, backgroundColor, new Color(45, 50, 55));

        /* Flood Fill Cat 5 */
        floodfill(buffer, 528, 524, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 545, 493, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 546, 497, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 531, 483, backgroundColor, new Color(255, 163, 62));
        floodfill(buffer, 495, 519, backgroundColor, new Color(255, 163, 62));
        floodfill(buffer, 552, 509, backgroundColor, new Color(255, 163, 62));
        floodfill(buffer, 508, 498, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 537, 498, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 523, 494, backgroundColor, new Color(37, 42, 49));

        /* Flood Fill Cat 6 */
        floodfill(buffer, 265, 435, backgroundColor, new Color(127, 100, 83));
        floodfill(buffer, 249, 418, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 282, 422, backgroundColor, new Color(247, 166, 162));

        /* Flood Fill Cat 7 */
        floodfill(buffer, 340, 453, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 330, 489, backgroundColor, new Color(174, 124, 73));
        floodfill(buffer, 374, 439, backgroundColor, new Color(174, 124, 73));
        floodfill(buffer, 341, 396, backgroundColor, new Color(174, 124, 73));
        floodfill(buffer, 321, 401, backgroundColor, new Color(174, 124, 73));
        floodfill(buffer, 323, 420, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 357, 421, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 339, 414, backgroundColor, new Color(48, 53, 57));

        /* Flood Fill Cat 8 */
        floodfill(buffer, 417, 446, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 386, 450, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 440, 403, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 426, 470, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 453, 442, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 410, 473, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 403, 425, backgroundColor, new Color(247, 167, 163));
        floodfill(buffer, 431, 425, backgroundColor, new Color(247, 167, 163));

        /* Flood Fill Cat 9 */
        floodfill(buffer, 499, 435, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 502, 471, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 523, 412, backgroundColor, new Color(247, 171, 75));
        floodfill(buffer, 470, 448, backgroundColor, new Color(123, 76, 32));
        floodfill(buffer, 530, 430, backgroundColor, new Color(123, 76, 32));
        floodfill(buffer, 497, 395, backgroundColor, new Color(123, 76, 32));
        floodfill(buffer, 480, 402, backgroundColor, new Color(123, 76, 32));
        floodfill(buffer, 495, 481, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 484, 419, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 514, 417, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 498, 412, backgroundColor, new Color(44, 53, 61));

        /* Flood Fill Cat 10 */
        floodfill(buffer, 310, 363, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 339, 368, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 280, 357, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 302, 331, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 323, 329, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 280, 352, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 338, 353, backgroundColor, new Color(149, 155, 155));
        floodfill(buffer, 297, 354, backgroundColor, new Color(247, 167, 163));
        floodfill(buffer, 324, 354, backgroundColor, new Color(247, 167, 163));

        /* Flood Fill Cat 11 */
        floodfill(buffer, 405, 357, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 383, 334, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 379, 338, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 428, 336, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 428, 339, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 417, 329, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 364, 361, backgroundColor, new Color(149, 0, 0));
        floodfill(buffer, 371, 349, backgroundColor, new Color(149, 0, 0));
        floodfill(buffer, 430, 352, backgroundColor, new Color(149, 0, 0));
        floodfill(buffer, 431, 363, backgroundColor, new Color(149, 0, 0));
        floodfill(buffer, 391, 340, backgroundColor, new Color(247, 168, 163));
        floodfill(buffer, 421, 340, backgroundColor, new Color(247, 168, 163));
        floodfill(buffer, 406, 332, backgroundColor, new Color(43, 48, 53));

        /* Flood Fill Cat 12 */
        floodfill(buffer, 459, 367, backgroundColor, new Color(30, 31, 33));
        floodfill(buffer, 503, 383, backgroundColor, new Color(30, 31, 33));
        floodfill(buffer, 479, 329, backgroundColor, new Color(30, 31, 33));
        floodfill(buffer, 461, 307, backgroundColor, new Color(30, 31, 33));
        floodfill(buffer, 464, 309, backgroundColor, new Color(30, 31, 33));
        floodfill(buffer, 467, 373, backgroundColor, new Color(45, 45, 45));
        floodfill(buffer, 487, 385, backgroundColor, new Color(45, 45, 45));
        floodfill(buffer, 480, 367, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 461, 315, backgroundColor, new Color(246, 164, 160));
        floodfill(buffer, 499, 318, backgroundColor, new Color(246, 164, 160));
        floodfill(buffer, 470, 330, backgroundColor, new Color(81, 85, 83));
        floodfill(buffer, 492, 330, backgroundColor, new Color(81, 85, 83));
        floodfill(buffer, 466, 329, backgroundColor, new Color(250, 253, 208));
        floodfill(buffer, 487, 329, backgroundColor, new Color(250, 253, 208));
        floodfill(buffer, 471, 325, backgroundColor, new Color(250, 253, 208));
        floodfill(buffer, 492, 325, backgroundColor, new Color(250, 253, 208));
        floodfill(buffer, 481, 338, backgroundColor, new Color(255, 173, 168));
        floodfill(buffer, 468, 343, backgroundColor, new Color(255, 173, 168));
        floodfill(buffer, 493, 343, backgroundColor, new Color(255, 173, 168));

        /* Flood Fill Cat 13 */
        floodfill(buffer, 316, 292, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 294, 271, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 293, 275, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 340, 270, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 288, 293, backgroundColor, new Color(255, 163, 62));
        floodfill(buffer, 346, 283, backgroundColor, new Color(255, 163, 62));
        floodfill(buffer, 307, 255, backgroundColor, new Color(255, 163, 62));
        floodfill(buffer, 332, 258, backgroundColor, new Color(255, 163, 62));
        floodfill(buffer, 304, 275, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 332, 274, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 318, 270, backgroundColor, new Color(44, 49, 54));

        /* Flood Fill Cat 14 */
        floodfill(buffer, 391, 287, backgroundColor, new Color(127, 100, 83));
        floodfill(buffer, 416, 265, backgroundColor, new Color(127, 100, 83));
        floodfill(buffer, 416, 270, backgroundColor, new Color(127, 100, 83));
        floodfill(buffer, 374, 272, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 405, 269, backgroundColor, new Color(247, 166, 162));
        
        /* Flood Fill Cat 15 */
        floodfill(buffer, 436, 297, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 458, 282, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 481, 292, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 458, 273, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 441, 234, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 438, 232, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 436, 231, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 438, 239, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 472, 240, backgroundColor, new Color(247, 166, 162));
        floodfill(buffer, 459, 296, backgroundColor, new Color(131, 104, 87));
        floodfill(buffer, 456, 253, backgroundColor, new Color(131, 104, 87));
        floodfill(buffer, 448, 263, backgroundColor, new Color(232, 157, 151));
        floodfill(buffer, 465, 263, backgroundColor, new Color(232, 157, 151));

        /* Flood Fill Cat 16 */
        floodfill(buffer, 384, 210, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 356, 181, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 357, 185, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 404, 179, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 404, 184, backgroundColor, new Color(252, 255, 210));
        floodfill(buffer, 351, 206, backgroundColor, new Color(127, 141, 141));
        floodfill(buffer, 374, 168, backgroundColor, new Color(127, 141, 141));
        floodfill(buffer, 394, 169, backgroundColor, new Color(127, 141, 141));
        floodfill(buffer, 410, 192, backgroundColor, new Color(127, 141, 141));
        floodfill(buffer, 366, 184, backgroundColor, new Color(247, 167, 163));
        floodfill(buffer, 396, 185, backgroundColor, new Color(247, 167, 163));
        floodfill(buffer, 381, 179, backgroundColor, new Color(41, 45, 51));

        /* Star */
        floodfill(buffer, 383, 123, backgroundColor, new Color(255, 212, 0));

        /* Gift Box 1 */
        floodfill(buffer, 6, 546, backgroundColor, new Color(250, 112, 108));
        floodfill(buffer, 21, 546, backgroundColor, new Color(250, 112, 108));
        floodfill(buffer, 4, 528, backgroundColor, new Color(250, 112, 108));
        floodfill(buffer, 20, 529, backgroundColor, new Color(250, 112, 108));
        floodfill(buffer, 41, 530, backgroundColor, new Color(249, 119, 117));
        floodfill(buffer, 65, 528, backgroundColor, new Color(249, 119, 117));
        floodfill(buffer, 38, 545, backgroundColor, new Color(250, 84, 76));
        floodfill(buffer, 64, 547, backgroundColor, new Color(250, 84, 76));
        floodfill(buffer, 13, 543, backgroundColor, new Color(210, 152, 228));
        floodfill(buffer, 54, 543, backgroundColor, new Color(163, 52, 211));
        floodfill(buffer, 45, 533, backgroundColor, new Color(214, 9, 10));
        floodfill(buffer, 65, 533, backgroundColor, new Color(214, 9, 10));
        floodfill(buffer, 21, 533, backgroundColor, new Color(214, 9, 10));
        floodfill(buffer, 8, 533, backgroundColor, new Color(214, 9, 10));
        floodfill(buffer, 23, 518, backgroundColor, new Color(170, 58, 232));
        floodfill(buffer, 58, 513, backgroundColor, new Color(170, 58, 232));
        floodfill(buffer, 37, 509, backgroundColor, new Color(198, 142, 218));
        floodfill(buffer, 37, 519, backgroundColor, new Color(198, 142, 218));
        floodfill(buffer, 27, 512, backgroundColor, new Color(250, 148, 54));

        /* Gift Box 2 */
        floodfill(buffer, 81, 536, backgroundColor, new Color(253, 113, 119));
        floodfill(buffer, 114, 529, backgroundColor, new Color(216, 82, 78));
        floodfill(buffer, 74, 537, backgroundColor, new Color(176, 219, 50));
        floodfill(buffer, 72, 513, backgroundColor, new Color(176, 219, 50));
        floodfill(buffer, 86, 542, backgroundColor, new Color(176, 219, 50));
        floodfill(buffer, 86, 511, backgroundColor, new Color(176, 219, 50));
        floodfill(buffer, 102, 540, backgroundColor, new Color(143, 200, 22));
        floodfill(buffer, 101, 511, backgroundColor, new Color(143, 200, 22));
        floodfill(buffer, 127, 537, backgroundColor, new Color(143, 200, 22));
        floodfill(buffer, 128, 514, backgroundColor, new Color(143, 200, 22));
        floodfill(buffer, 79, 495, backgroundColor, new Color(250, 112, 110));
        floodfill(buffer, 103, 488, backgroundColor, new Color(250, 112, 110));
        floodfill(buffer, 118, 482, backgroundColor, new Color(250, 112, 110));
        floodfill(buffer, 89, 489, backgroundColor, new Color(220, 51, 47));
        floodfill(buffer, 120, 500, backgroundColor, new Color(220, 51, 47));
        floodfill(buffer, 74, 519, backgroundColor, new Color(140, 188, 13));
        floodfill(buffer, 87, 519, backgroundColor, new Color(140, 188, 13));
        floodfill(buffer, 100, 518, backgroundColor, new Color(95, 156, 0));
        floodfill(buffer, 125, 519, backgroundColor, new Color(95, 156, 0));

        /* Gift Box 3 */
        floodfill(buffer, 161, 533, backgroundColor, new Color(73, 192, 236));
        floodfill(buffer, 191, 557, backgroundColor, new Color(129, 147, 229));
        floodfill(buffer, 180, 545, backgroundColor, new Color(129, 147, 229));
        floodfill(buffer, 172, 530, backgroundColor, new Color(129, 147, 229));
        floodfill(buffer, 155, 557, backgroundColor, new Color(129, 147, 229));
        floodfill(buffer, 147, 540, backgroundColor, new Color(129, 147, 229));
        floodfill(buffer, 140, 526, backgroundColor, new Color(129, 147, 229));
        floodfill(buffer, 185, 513, backgroundColor, new Color(129, 147, 229));
        floodfill(buffer, 167, 513, backgroundColor, new Color(129, 147, 229));
        floodfill(buffer, 148, 515, backgroundColor, new Color(129, 147, 229));
        floodfill(buffer, 187, 550, backgroundColor, new Color(60, 88, 204));
        floodfill(buffer, 175, 537, backgroundColor, new Color(60, 88, 204));
        floodfill(buffer, 167, 524, backgroundColor, new Color(60, 88, 204));
        floodfill(buffer, 150, 549, backgroundColor, new Color(60, 88, 204));
        floodfill(buffer, 144, 530, backgroundColor, new Color(60, 88, 204));
        floodfill(buffer, 192, 514, backgroundColor, new Color(60, 88, 204));
        floodfill(buffer, 175, 513, backgroundColor, new Color(60, 88, 204));
        floodfill(buffer, 155, 515, backgroundColor, new Color(60, 88, 204));
        floodfill(buffer, 143, 510, backgroundColor, new Color(60, 88, 204));
        floodfill(buffer, 179, 520, backgroundColor, new Color(101, 121, 207));
        floodfill(buffer, 144, 521, backgroundColor, new Color(101, 121, 207));
        floodfill(buffer, 185, 520, backgroundColor, new Color(27, 48, 166));
        floodfill(buffer, 169, 520, backgroundColor, new Color(27, 48, 166));
        floodfill(buffer, 150, 520, backgroundColor, new Color(27, 48, 166));
        floodfill(buffer, 135, 521, backgroundColor, new Color(27, 48, 166));
        floodfill(buffer, 148, 503, backgroundColor, new Color(28, 156, 202));
        floodfill(buffer, 176, 505, backgroundColor, new Color(28, 156, 202));
        floodfill(buffer, 155, 492, backgroundColor, new Color(105, 215, 248));
        floodfill(buffer, 163, 488, backgroundColor, new Color(105, 215, 248));
        floodfill(buffer, 168, 492, backgroundColor, new Color(105, 215, 248));
        floodfill(buffer, 172, 500, backgroundColor, new Color(105, 215, 248));
        floodfill(buffer, 187, 498, backgroundColor, new Color(105, 215, 248));

        /* Gift Box 4 */
        floodfill(buffer, 11, 484, backgroundColor, new Color(250, 172, 84));
        floodfill(buffer, 45, 484, backgroundColor, new Color(250, 172, 84));
        floodfill(buffer, 57, 483, backgroundColor, new Color(250, 172, 84));
        floodfill(buffer, 26, 500, backgroundColor, new Color(250, 148, 54));
        floodfill(buffer, 51, 499, backgroundColor, new Color(250, 148, 54));
        floodfill(buffer, 43, 493, backgroundColor, new Color(250, 148, 54));
        floodfill(buffer, 53, 508, backgroundColor, new Color(250, 148, 54));
        floodfill(buffer, 58, 521, backgroundColor, new Color(250, 148, 54));
        floodfill(buffer, 24, 490, backgroundColor, new Color(239, 93, 16));
        floodfill(buffer, 46, 490, backgroundColor, new Color(239, 93, 16));
        floodfill(buffer, 37, 487, backgroundColor, new Color(148, 198, 33));
        floodfill(buffer, 19, 484, backgroundColor, new Color(149, 199, 34));
        floodfill(buffer, 52, 485, backgroundColor, new Color(149, 199, 34));
        floodfill(buffer, 37, 470, backgroundColor, new Color(149, 199, 34));
        floodfill(buffer, 49, 474, backgroundColor, new Color(149, 199, 34));
        floodfill(buffer, 24, 473, backgroundColor, new Color(102, 148, 10));
        floodfill(buffer, 32, 475, backgroundColor, new Color(133, 191, 23));

        /* Gift Box 5 */
        floodfill(buffer, 65, 474, backgroundColor, new Color(252, 113, 99));
        floodfill(buffer, 77, 474, backgroundColor, new Color(253, 113, 99));
        floodfill(buffer, 67, 492, backgroundColor, new Color(253, 63, 49));
        floodfill(buffer, 67, 522, backgroundColor, new Color(253, 63, 49));
        floodfill(buffer, 77, 503, backgroundColor, new Color(253, 63, 49));
        floodfill(buffer, 78, 483, backgroundColor, new Color(253, 63, 49));
        floodfill(buffer, 87, 475, backgroundColor, new Color(225, 42, 32));
        floodfill(buffer, 84, 504, backgroundColor, new Color(225, 42, 32));
        floodfill(buffer, 115, 472, backgroundColor, new Color(225, 42, 32));
        floodfill(buffer, 72, 485, backgroundColor, new Color(253, 221, 62));
        floodfill(buffer, 107, 477, backgroundColor, new Color(253, 221, 62));
        floodfill(buffer, 108, 501, backgroundColor, new Color(253, 221, 62));
        floodfill(buffer, 66, 482, backgroundColor, new Color(205, 35, 28));
        floodfill(buffer, 77, 482, backgroundColor, new Color(205, 35, 28));
        floodfill(buffer, 84, 482, backgroundColor, new Color(205, 35, 28));
        floodfill(buffer, 126, 482, backgroundColor, new Color(205, 35, 28));
        floodfill(buffer, 82, 463, backgroundColor, new Color(252, 184, 40));
        floodfill(buffer, 113, 461, backgroundColor, new Color(252, 184, 40));
        floodfill(buffer, 88, 458, backgroundColor, new Color(189, 117, 11));
        floodfill(buffer, 102, 458, backgroundColor, new Color(189, 117, 11));

        /* Gift Box 6 */
        floodfill(buffer, 136, 480, backgroundColor, new Color(249, 201, 67));
        floodfill(buffer, 172, 479, backgroundColor, new Color(249, 201, 67));
        floodfill(buffer, 135, 493, backgroundColor, new Color(249, 179, 23));
        floodfill(buffer, 182, 504, backgroundColor, new Color(249, 179, 23));
        floodfill(buffer, 174, 494, backgroundColor, new Color(249, 179, 23));
        floodfill(buffer, 166, 506, backgroundColor, new Color(249, 179, 23));
        floodfill(buffer, 158, 486, backgroundColor, new Color(249, 179, 23));
        floodfill(buffer, 156, 502, backgroundColor, new Color(249, 179, 23));
        floodfill(buffer, 182, 487, backgroundColor, new Color(249, 179, 23));
        floodfill(buffer, 156, 489, backgroundColor, new Color(249, 179, 23));
        floodfill(buffer, 150, 497, backgroundColor, new Color(250, 79, 66));
        floodfill(buffer, 149, 481, backgroundColor, new Color(250, 79, 66));
        floodfill(buffer, 146, 505, backgroundColor, new Color(250, 79, 66));
        floodfill(buffer, 180, 485, backgroundColor, new Color(246, 157, 15));
        floodfill(buffer, 158, 485, backgroundColor, new Color(246, 157, 15));
        floodfill(buffer, 133, 485, backgroundColor, new Color(246, 157, 15));
        floodfill(buffer, 135, 467, backgroundColor, new Color(249, 86, 73));
        floodfill(buffer, 157, 461, backgroundColor, new Color(249, 86, 73));
        floodfill(buffer, 141, 463, backgroundColor, new Color(211, 19, 16));
        floodfill(buffer, 165, 465, backgroundColor, new Color(211, 19, 16));

        /* Letter Two */
        floodfill(buffer, 62, 130, backgroundColor, new Color(253, 244, 40));
        floodfill(buffer, 62, 272, backgroundColor, new Color(253, 244, 40));
        floodfill(buffer, 58, 66, backgroundColor, new Color(118, 0, 0));
        floodfill(buffer, 58, 207, backgroundColor, new Color(118, 0, 0));
        floodfill(buffer, 58, 140, backgroundColor, new Color(118, 0, 0));
        floodfill(buffer, 58, 281, backgroundColor, new Color(118, 0, 0));

        /* Letter Zerro */
        floodfill(buffer, 141, 58, backgroundColor, new Color(253, 244, 40));
        floodfill(buffer, 142, 66, backgroundColor, new Color(118, 0, 0));
        floodfill(buffer, 141, 141, backgroundColor, new Color(118, 0, 0));

        /* Letter Four */
        floodfill(buffer, 134, 257, backgroundColor, new Color(253, 244, 40));

        /* Snow */
        floodfill(buffer, 230, 121, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 250, 201, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 501, 128, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 521, 240, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 209, 440, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 207, 385, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 557, 450, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 547, 367, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 538, 201, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 503, 212, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 487, 169, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 262, 243, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 244, 279, backgroundColor, new Color(255, 250, 250));
        floodfill(buffer, 325, 111, backgroundColor, new Color(255, 250, 250));

        /* Draw */
        g.drawImage(buffer, 0, 0, null);
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

    private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(resultingImage, 0, 0, null);
        g2d.dispose();

        return resizedImage;
    }

    private void drawNose(Graphics g2, int x, int y) {
        bezierCurve(g2, x, y, x + 2, y - 2, x + 5, y - 2, x + 5, y);
        bezierCurve(g2, x, y, x + 2, y + 2, x + 5, y + 2, x + 5, y);
    }

    private void drawCheek(Graphics g2, int x, int y, int size) {
        int controlPoint1Offset = size / 2;
        int controlPoint2Offset = size;

        bezierCurve(g2, x, y, x + controlPoint1Offset, y - controlPoint1Offset, x + controlPoint2Offset,
                y - controlPoint2Offset, x + 2 * controlPoint2Offset, y);
        bezierCurve(g2, x, y, x + controlPoint1Offset, y + controlPoint1Offset, x + controlPoint2Offset,
                y + controlPoint2Offset, x + 2 * controlPoint2Offset, y);
    }

    private void drawLetterTwo(Graphics g2, int x, int y) {
        bezierCurve(g2, x + 27, y + 76, x + 30, y + 55, x + 47, y + 49, x + 60, y + 48);
        bezierCurve(g2, x + 60, y + 48, x + 85, y + 53, x + 90, y + 63, x + 91, y + 76);
        bezierCurve(g2, x + 44, y + 76, x + 47, y + 68, x + 52, y + 64, x + 59, y + 63);
        bezierCurve(g2, x + 59, y + 63, x + 70, y + 66, x + 71, y + 71, x + 73, y + 75);
        bezierCurve(g2, x + 72, y + 73, x + 80, y + 82, x + 46, y + 107, x + 28, y + 124);
        bezierCurve(g2, x + 91, y + 73, x + 94, y + 87, x + 76, y + 102, x + 54, y + 121);
        bresenhamLine(g2, x + 27, y + 76, x + 46, y + 76);
        bresenhamLine(g2, x + 28, y + 124, x + 28, y + 143);
        bresenhamLine(g2, x + 28, y + 136, x + 93, y + 136);
        bresenhamLine(g2, x + 53, y + 122, x + 93, y + 122);
        bresenhamLine(g2, x + 92, y + 121, x + 92, y + 143);
    
        bresenhamLine(g2, x + 28, y + 142, x + 93, y + 142);
        bezierCurve(g2, x + 45, y + 76, x + 49, y + 71, x + 52, y + 68, x + 58, y + 67);
        bezierCurve(g2, x + 57, y + 67, x + 64, y + 67, x + 67, y + 70, x + 73, y + 74);
    }

    private void snow(Graphics g2, int x, int y) {
        bezierCurve(g2, x, y, x, y - 1, x + 1, y - 3, x + 6, y - 4);
        bezierCurve(g2, x, y, x, y + 3, x + 2, y + 5, x + 6, y + 4);
        bezierCurve(g2, x + 9, y, x + 9, y - 1, x + 8, y - 3, x + 7, y - 4);
        bezierCurve(g2, x + 9, y, x + 9, y + 3, x + 8, y + 5, x + 7, y + 4);
    }
}