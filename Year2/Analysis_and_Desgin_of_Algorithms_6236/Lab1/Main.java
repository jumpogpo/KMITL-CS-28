import java.util.Scanner;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c;

        System.out.println("Formula:\nAx^2 + bx + c");
        System.out.print("Please input a: ");
        a = sc.nextDouble();

        if (a == 0) {
            System.out.println("a can't be 0");
            sc.close();
            return;
        }

        System.out.print("Please input b: ");
        b = sc.nextDouble();
        System.out.print("Please input c: ");
        c = sc.nextDouble();
        sc.close();

        double d = b * b - 4 * a * c;
        double sqrt_val = sqrt(abs(d));
 
        if (d > 0) {
            System.out.println("\nRoots are real and different");
 
            System.out.println((double)(-b + sqrt_val) / (2 * a) + "\n" + (double)(-b - sqrt_val) / (2 * a));
        } else if (d == 0) {
            System.out.println("\nRoots are real and same");
            System.out.println(-(double)b / (2 * a) + "\n" + -(double)b / (2 * a));
        } else {
            System.out.println("\nRoots are complex");
            System.out.println(-(double)b / (2 * a) + " + i" + sqrt_val / (2 * a) + "\n" + -(double)b / (2 * a) + " - i" + sqrt_val / (2 * a));
        }
    }
}