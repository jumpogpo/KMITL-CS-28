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
        // frame.setResizable(false);
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
            originalImage = ImageIO.read(new File("images.png"));
            // g.drawImage(resizeImage(originalImage, 584, 561), 0, 0, null);
        } catch (IOException e) {
            System.out.println(e);
        }

        /* Background */
        Color backgroundColor = new Color(153, 0, 0);
        Color outlineColor = new Color(87, 54, 53);

        g2.setColor(backgroundColor);
        // g2.fillRect(0, 0, 600, 600);

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

        drawNose(g2, 379, 180);
        bezierCurve(g2, 374, 182, 377, 195, 382, 185, 382, 181);
        bezierCurve(g2, 381, 185, 385, 189, 389, 187, 389, 181);

        bezierCurve(g2, 365, 177, 366, 175, 368, 175, 370, 177);
        bezierCurve(g2, 390, 176, 392, 175, 394, 175, 395, 177);
        
        g2.setColor(new Color(247, 167, 163));
        drawCheek(g2, 359, 185, 6);
        drawCheek(g2, 390, 184, 6);

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
}

        // /* Gift Box 1 */
        // g2.setColor(new Color(249, 180, 76));
        // bresenhamLine(g2, 10, 449, 10, 505);
        // bresenhamLine(g2, 10, 504, -2, 504);
        // bresenhamLine(g2, 18, 449, 18, 505);
        // bresenhamLine(g2, 18, 504, 34, 504);
        // bresenhamLine(g2, 0, 514, 11, 514);
        // bresenhamLine(g2, 10, 514, 10, 601);
        // bresenhamLine(g2, 18, 514, 34, 514);
        // bresenhamLine(g2, 18, 514, 18, 601);

        // g2.setColor(Color.BLACK);
        // bresenhamLine(g2, 0, 449, 39, 449);
        // bresenhamLine(g2, 38, 449, 38, 498);

        // /* Gift Box 2 */
        // bresenhamLine(g2, 66, 497, 66, 528);
        // bresenhamLine(g2, 66, 527, 32, 527);
        // bresenhamLine(g2, 66, 537, 32, 537);
        // bresenhamLine(g2, 66, 537, 66, 601);
        // bresenhamLine(g2, 75, 497, 75, 528);
        // bresenhamLine(g2, 75, 527, 106, 527);
        // bresenhamLine(g2, 75, 537, 106, 537);
        // bresenhamLine(g2, 75, 537, 75, 601);

        // bresenhamLine(g2, 33, 497, 106, 497);
        // bresenhamLine(g2, 33, 497, 33, 601);

        // /* Gift Box 3 */
        // g2.setColor(new Color(172, 243, 55));
        // bresenhamLine(g2, 134, 449, 134, 502);
        // bresenhamLine(g2, 134, 501, 104, 501);
        // bresenhamLine(g2, 142, 449, 142, 502);
        // bresenhamLine(g2, 142, 501, 171, 501);
        // bresenhamLine(g2, 105, 510, 135, 510);
        // bresenhamLine(g2, 134, 510, 134, 601);
        // bresenhamLine(g2, 142, 510, 171, 510);
        // bresenhamLine(g2, 142, 510, 142, 601);

        // g2.setColor(Color.BLACK);
        // bresenhamLine(g2, 105, 449, 171, 449);
        // bresenhamLine(g2, 105, 449, 105, 600);
        // bresenhamLine(g2, 170, 449, 170, 514);

        // /* Gift Box 4 */
        // bresenhamLine(g2, 174, 514, 174, 533);
        // bresenhamLine(g2, 174, 532, 149, 532);
        // bresenhamLine(g2, 174, 539, 149, 539);
        // bresenhamLine(g2, 174, 539, 174, 601);
        // bresenhamLine(g2, 183, 514, 183, 533);
        // bresenhamLine(g2, 183, 532, 200, 532);
        // bresenhamLine(g2, 183, 539, 200, 539);
        // bresenhamLine(g2, 183, 539, 183, 601);

        // g2.setColor(Color.BLACK);
        // bresenhamLine(g2, 150, 514, 201, 514);
        // bresenhamLine(g2, 150, 514, 150, 601);