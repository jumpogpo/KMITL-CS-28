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
             g.drawImage(resizeImage(originalImage, 584, 561), 0, 0, null);
         } catch (IOException e) {
             System.out.println(e);
         }
 
         /* Background */
         // g2.setColor(Color.WHITE);
         // g2.fillRect(0, 0, 600, 600);
 
         g2.setColor(Color.RED);
 
         /* Cat 11 */
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
         drawNose(g2, 403, 332);
         drawCheek(g2, 385, 338, 6);
         drawCheek(g2, 415, 338, 6);
 
         bezierCurve(g2, 359, 362, 368, 366, 368, 360, 364, 355);
         bezierCurve(g2, 365, 351, 381, 363, 383, 346, 370, 345);
         bezierCurve(g2, 433, 365, 426, 363, 426, 359, 433, 358);
         bezierCurve(g2, 431, 347, 424, 349, 422, 354, 432, 355);
 
         /* Cat 10 */
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
 
         bezierCurve(g2, 306, 353, 307, 356, 308, 356, 310, 353);
         bezierCurve(g2, 310, 352, 310, 356, 313, 356, 313, 353);
 
         bezierCurve(g2, 295, 344, 297, 335, 303, 335, 304, 344);
         bezierCurve(g2, 295, 344, 297, 350, 303, 350, 304, 344);
         bezierCurve(g2, 314, 344, 316, 335, 322, 335, 323, 344);
         bezierCurve(g2, 314, 344, 316, 350, 322, 350, 323, 344);
 
         plot(g2, 300, 344, 2);
         plot(g2, 318, 344, 2);
         drawCheek(g2, 293, 354, 4);
         drawCheek(g2, 320, 353, 4);
 
         bezierCurve(g2, 275, 364, 281, 364, 285, 355, 280, 350);
         bezierCurve(g2, 338, 348, 334, 363, 334, 375, 342, 387);
         bezierCurve(g2, 284, 335, 286, 339, 289, 342, 293, 341);
         bezierCurve(g2, 293, 341, 296, 330, 301, 332, 306, 335);
         bezierCurve(g2, 305, 335, 307, 335, 309, 333, 310, 322);
         bezierCurve(g2, 310, 322, 312, 330, 313, 334, 314, 335);
         bezierCurve(g2, 314, 335, 317, 333, 323, 330, 327, 338);
         bresenhamLine(g2, 327, 338, 336, 335);
 
         /* Cat 9 */
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
 
         bezierCurve(g2, 501, 470, 498, 474, 500, 477, 502, 479);
         
         bezierCurve(g2, 467, 437, 476, 441, 476, 450, 468, 456);
         bezierCurve(g2, 472, 409, 479, 409, 486, 403, 489, 395);
         bezierCurve(g2, 491, 393, 493, 403, 502, 403, 505, 393);
         bezierCurve(g2, 529, 422, 526, 432, 528, 438, 534, 444);
 
         drawCheek(g2, 478, 418, 6);
         drawCheek(g2, 508, 416, 6);
         drawNose(g2, 496, 413);
 
         /* Cat 8 */
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
         bresenhamLine(g2, 403, 468, 417, 468);
         bresenhamLine(g2, 423, 468, 437, 468);
 
         bezierCurve(g2, 391, 396, 385, 433, 373, 461, 396, 475);
         bezierCurve(g2, 391, 396, 391, 387, 397, 387, 402, 395);
         bezierCurve(g2, 403, 395, 413, 393, 420, 393, 429, 395);
         bezierCurve(g2, 430, 395, 435, 385, 439, 385, 443, 395);
         bezierCurve(g2, 442, 395, 450, 411, 465, 465, 445, 475);
         bezierCurve(g2, 406, 479, 407, 482, 413, 482, 415, 479);
         bezierCurve(g2, 400, 412, 402, 415, 404, 416, 405, 412);
         bezierCurve(g2, 427, 412, 428, 415, 432, 415, 433, 412);
         bezierCurve(g2, 414, 424, 415, 426, 417, 427, 418, 423);
         bezierCurve(g2, 418, 423, 419, 427, 421, 427, 422, 424);
 
         bezierCurve(g2, 385, 463, 393, 452, 390, 442, 384, 431);
         bezierCurve(g2, 423, 394, 423, 406, 433, 413, 446, 410);
         bezierCurve(g2, 454, 436, 449, 441, 449, 449, 455, 451);
 
         drawCheek(g2, 399, 424, 4);
         drawCheek(g2, 428, 425, 4);
 
         /* Cat 7 */
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
         bezierCurve(g2, 311, 409, 319, 408, 325, 403, 328, 395);
         bezierCurve(g2, 333, 395, 337, 402, 341, 402, 347, 395);
         bezierCurve(g2, 376, 447, 370, 443, 370, 435, 373, 430);
         bezierCurve(g2, 336, 478, 332, 485, 333, 488, 342, 494);
 
         drawCheek(g2, 317, 420, 5);
         drawCheek(g2, 352, 420, 5);
         drawNose(g2, 337, 415);
 
         /* Cat 6 */
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
 
         bezierCurve(g2, 242, 391, 226, 439, 218, 462, 241, 468);
         bezierCurve(g2, 243, 390, 246, 381, 251, 381, 257, 390);
         bezierCurve(g2, 257, 390, 267, 389, 273, 389, 283, 394);
         bezierCurve(g2, 284, 394, 290, 386, 296, 386, 297, 398);
         bezierCurve(g2, 295, 395, 297, 444, 307, 466, 270, 474);
         bezierCurve(g2, 253, 411, 257, 407, 259, 408, 259, 411);
         bezierCurve(g2, 274, 413, 276, 410, 279, 410, 280, 413);
         bezierCurve(g2, 274, 413, 276, 410, 279, 410, 280, 413);
         bezierCurve(g2, 240, 469, 240, 474, 240, 474, 244, 474);
         bezierCurve(g2, 261, 473, 264, 478, 268, 478, 269, 473);
         bezierCurve(g2, 262, 420, 262, 425, 264, 425, 266, 420);
         bezierCurve(g2, 266, 422, 266, 425, 268, 425, 269, 420);
 
         drawCheek(g2, 242, 418, 6);
         drawCheek(g2, 275, 422, 6);
 
         /* Cat 5 */
         bresenhamLine(g2, 515, 472, 530, 472);
         bresenhamLine(g2, 530, 472, 537, 462);
         bresenhamLine(g2, 506, 534, 512, 548);
         bresenhamLine(g2, 523, 532, 521, 548);
         bresenhamLine(g2, 520, 548, 530, 548);
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
         bezierCurve(g2, 500, 486, 515, 495, 520, 483, 522, 474);
         bezierCurve(g2, 545, 487, 535, 495, 523, 483, 522, 474);
         bezierCurve(g2, 545, 487, 535, 495, 523, 483, 522, 474);
         bezierCurve(g2, 508, 490, 509, 487, 511, 487, 513, 491);
         bezierCurve(g2, 532, 491, 534, 487, 535, 487, 537, 491);
         bezierCurve(g2, 532, 491, 534, 487, 535, 487, 537, 491);
         bezierCurve(g2, 517, 495, 515, 498, 521, 505, 522, 495);
         bezierCurve(g2, 523, 496, 526, 502, 530, 505, 531, 494);
         bezierCurve(g2, 492, 534, 498, 532, 499, 512, 494, 497);
         bezierCurve(g2, 504, 493, 500, 491, 496, 491, 490, 490);
         bezierCurve(g2, 540, 494, 545, 490, 547, 489, 552, 488);
         bezierCurve(g2, 550, 497, 545, 504, 551, 510, 555, 514);
 
         drawCheek(g2, 504, 497, 5);
         drawCheek(g2, 534, 497, 5);
         drawNose(g2, 520, 494);
 
         /* Cat 4 */
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
 
         drawNose(g2, 448, 495);
         drawCheek(g2, 431, 499, 5);
         drawCheek(g2, 462, 499, 5);
 
         /* Cat 3 */
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
 
         bezierCurve(g2, 364, 485, 347, 516, 325, 541, 338, 560);
         bezierCurve(g2, 340, 545, 340, 554, 350, 560, 359, 560);
         bezierCurve(g2, 364, 485, 368, 470, 370, 470, 377, 482);
         bezierCurve(g2, 377, 483, 383, 481, 387, 481, 393, 483);
         bezierCurve(g2, 393, 483, 399, 472, 400, 472, 403, 484);
         bezierCurve(g2, 403, 485, 406, 511, 410, 527, 406, 546);
         bezierCurve(g2, 356, 530, 359, 538, 359, 545, 359, 549);
         bezierCurve(g2, 354, 553, 358, 554, 364, 552, 359, 549);
         bezierCurve(g2, 359, 548, 365, 550, 368, 550, 372, 549);
         bezierCurve(g2, 377, 556, 381, 555, 390, 554, 382, 550);
         bezierCurve(g2, 382, 548, 389, 547, 394, 546, 397, 544);
         bezierCurve(g2, 400, 548, 401, 550, 416, 555, 406, 544);
         bezierCurve(g2, 373, 494, 375, 497, 376, 497, 377, 494);
         bezierCurve(g2, 390, 495, 392, 490, 395, 490, 397, 495);
         bezierCurve(g2, 390, 495, 392, 499, 395, 499, 397, 495);
 
         plot(g2, 395, 495, 2);
         drawNose(g2, 381, 496);
         drawCheek(g2, 365, 503, 5);
         drawCheek(g2, 392, 503, 5);
 
         /* Cat 2 */
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
         bezierCurve(g2, 301, 531, 305, 535, 305, 539, 302, 543);
         bezierCurve(g2, 302, 550, 304, 552, 313, 552, 309, 549);
         bezierCurve(g2, 283, 546, 284, 553, 292, 553, 294, 548);
         bezierCurve(g2, 296, 505, 300, 503, 302, 503, 304, 505);
         bezierCurve(g2, 296, 505, 300, 507, 302, 507, 304, 505);
         bezierCurve(g2, 298, 494, 300, 492, 301, 492, 302, 494);
         bezierCurve(g2, 298, 494, 300, 496, 301, 496, 302, 494);
         bezierCurve(g2, 296, 474, 300, 484, 280, 495, 275, 487);
         bezierCurve(g2, 267, 525, 274, 522, 271, 518, 268, 512);
         bezierCurve(g2, 329, 508, 325, 518, 320, 528, 329, 534);
         bezierCurve(g2, 287, 491, 289, 494, 291, 494, 292, 491);
         bezierCurve(g2, 310, 491, 312, 494, 313, 494, 315, 491);
         bezierCurve(g2, 276, 478, 270, 509, 257, 540, 283, 549);
         bezierCurve(g2, 276, 478, 282, 465, 282, 465, 288, 475);
         bezierCurve(g2, 288, 476, 296, 473, 305, 473, 314, 476);
         bezierCurve(g2, 314, 476, 320, 469, 321, 469, 324, 476);
         bezierCurve(g2, 324, 476, 330, 514, 342, 547, 310, 549);
 
         drawCheek(g2, 281, 501, 5);
         drawCheek(g2, 310, 501, 5);
 
         /* Cat 1 */
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
 
         bezierCurve(g2, 209, 478, 212, 470, 212, 470, 220, 478);
         bezierCurve(g2, 204, 541, 214, 555, 238, 540, 246, 560);
         bezierCurve(g2, 200, 543, 205, 560, 211, 561, 216, 560);
         bezierCurve(g2, 234, 550, 236, 557, 238, 556, 232, 561);
         bezierCurve(g2, 234, 549, 265, 554, 268, 529, 258, 505);
         bezierCurve(g2, 225, 478, 225, 484, 238, 484, 238, 478);
         bezierCurve(g2, 240, 479, 245, 489, 245, 489, 255, 491);
         bezierCurve(g2, 217, 493, 217, 490, 222, 490, 222, 493);
         bezierCurve(g2, 241, 492, 241, 489, 246, 489, 246, 492);
         bezierCurve(g2, 200, 525, 205, 525, 208, 507, 202, 507);
         bezierCurve(g2, 229, 496, 231, 495, 232, 495, 233, 496);
         bezierCurve(g2, 229, 496, 231, 499, 232, 499, 233, 496);
         bezierCurve(g2, 212, 502, 213, 498, 220, 498, 221, 500);
         bezierCurve(g2, 212, 502, 213, 506, 220, 506, 221, 500);
         bezierCurve(g2, 242, 502, 241, 497, 247, 498, 248, 501);
         bezierCurve(g2, 242, 502, 241, 506, 247, 506, 248, 501);
 
         /* Gift Box 1 */
         g2.setColor(new Color(249, 180, 76));
         bresenhamLine(g2, 10, 449, 10, 505);
         bresenhamLine(g2, 10, 504, -2, 504);
         bresenhamLine(g2, 18, 449, 18, 505);
         bresenhamLine(g2, 18, 504, 34, 504);
         bresenhamLine(g2, 0, 514, 11, 514);
         bresenhamLine(g2, 10, 514, 10, 601);
         bresenhamLine(g2, 18, 514, 34, 514);
         bresenhamLine(g2, 18, 514, 18, 601);
 
         g2.setColor(Color.BLACK);
         bresenhamLine(g2, 0, 449, 39, 449);
         bresenhamLine(g2, 38, 449, 38, 498);
 
         /* Gift Box 2 */
         bresenhamLine(g2, 66, 497, 66, 528);
         bresenhamLine(g2, 66, 527, 32, 527);
         bresenhamLine(g2, 66, 537, 32, 537);
         bresenhamLine(g2, 66, 537, 66, 601);
         bresenhamLine(g2, 75, 497, 75, 528);
         bresenhamLine(g2, 75, 527, 106, 527);
         bresenhamLine(g2, 75, 537, 106, 537);
         bresenhamLine(g2, 75, 537, 75, 601);
 
         bresenhamLine(g2, 33, 497, 106, 497);
         bresenhamLine(g2, 33, 497, 33, 601);
 
         /* Gift Box 3 */
         g2.setColor(new Color(172, 243, 55));
         bresenhamLine(g2, 134, 449, 134, 502);
         bresenhamLine(g2, 134, 501, 104, 501);
         bresenhamLine(g2, 142, 449, 142, 502);
         bresenhamLine(g2, 142, 501, 171, 501);
         bresenhamLine(g2, 105, 510, 135, 510);
         bresenhamLine(g2, 134, 510, 134, 601);
         bresenhamLine(g2, 142, 510, 171, 510);
         bresenhamLine(g2, 142, 510, 142, 601);
 
         g2.setColor(Color.BLACK);
         bresenhamLine(g2, 105, 449, 171, 449);
         bresenhamLine(g2, 105, 449, 105, 600);
         bresenhamLine(g2, 170, 449, 170, 514);
 
         /* Gift Box 4 */
         bresenhamLine(g2, 174, 514, 174, 533);
         bresenhamLine(g2, 174, 532, 149, 532);
         bresenhamLine(g2, 174, 539, 149, 539);
         bresenhamLine(g2, 174, 539, 174, 601);
         bresenhamLine(g2, 183, 514, 183, 533);
         bresenhamLine(g2, 183, 532, 200, 532);
         bresenhamLine(g2, 183, 539, 200, 539);
         bresenhamLine(g2, 183, 539, 183, 601);
 
         g2.setColor(Color.BLACK);
         bresenhamLine(g2, 150, 514, 201, 514);
         bresenhamLine(g2, 150, 514, 150, 601);
 
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
         
         bezierCurve(g2, x, y, x + controlPoint1Offset, y - controlPoint1Offset, x + controlPoint2Offset, y - controlPoint2Offset, x + 2 * controlPoint2Offset, y);
         bezierCurve(g2, x, y, x + controlPoint1Offset, y + controlPoint1Offset, x + controlPoint2Offset, y + controlPoint2Offset, x + 2 * controlPoint2Offset, y);
     }
 }
 