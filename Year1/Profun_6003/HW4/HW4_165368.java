import java.util.Scanner;

public class HW4_165368 {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        
        if (Input.hasNextDouble()) {
            double F = Input.nextDouble();
            System.out.println(((F - 32) / 9) * 5);
        } else {
            System.out.println("Please input a number only");
        }

        Input.close();
    }
}