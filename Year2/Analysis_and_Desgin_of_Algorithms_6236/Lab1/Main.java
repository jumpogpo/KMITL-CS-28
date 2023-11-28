import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        double root1, root2;

        System.out.println("Formula:\nAx^2 + bx + c");
        System.out.print("Please input A: ");
        a = sc.nextDouble();
        System.out.print("Please input b: ");
        b = sc.nextDouble();
        System.out.print("Please input c: ");
        c = sc.nextDouble();
        sc.close();

        double determinant = b * b - 4 * a * c;

        if (determinant > 0) {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
      
            System.out.format("root1 = %.2f and root2 = %.2f%n", root1, root2);
        } else if (determinant == 0) {
            root1 = root2 = -b / (2 * a);
            System.out.format("root1 = root2 = %.2f%n", root1);
        } else {      
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-determinant) / (2 * a);
            System.out.format("root1 = %.2f+%.2fi", real, imaginary);
            System.out.format("\nroot2 = %.2f-%.2fi%n", real, imaginary);
        }
    }
}