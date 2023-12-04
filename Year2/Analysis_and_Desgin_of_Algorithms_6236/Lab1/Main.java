import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c;

        System.out.println("Formula:\nAx^2 + bx + c");
        System.out.print("Please input a: ");
        a = sc.nextDouble();
        System.out.print("Please input b: ");
        b = sc.nextDouble();
        System.out.print("Please input c: ");
        c = sc.nextDouble();
        sc.close();

        if (a != 0) {
            double d = b * b - 4 * a * c;
    
            if (d > 0) {
                double root1 = (-b + Math.sqrt(d)) / (2 * a);
                double root2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("มีสองรากจริง: " + root1 + " และ " + root2);
            } else if (d == 0) {
                double root = -b / (2 * a);
                System.out.println("มีรากเดียว: " + root);
            } else {
                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-d) / (2 * a);
                System.out.println("ไม่มีรากจริง: " + realPart + " + " + imaginaryPart + "i และ " + realPart + " - " + imaginaryPart + "i");
            }
        } else {
            if (b == 0) {
                System.out.println("หาคำตอบไม่ได้");
            } else {
                System.out.println(-c / b);
            }
        }
    }
}