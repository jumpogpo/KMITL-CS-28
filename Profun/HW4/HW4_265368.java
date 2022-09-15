import java.util.Scanner;

public class HW4_265368 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        int x = 1;

        while (x > 0) {
            System.out.println("Please input number");
            x = input.nextInt();

            if (x % 2 == 0 && x > 0) {
                sum += x;
            }

            System.out.println("Sum: " + sum);
        }

        input.close();
    }
}
