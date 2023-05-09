import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int power;
        int[][] matrixArr = {
            {1, 2, 3, 4, 5},
            {1, 2, 3 ,4 ,5},
            {1, 2, 3 ,4 ,5},
            {1, 2, 3 ,4 ,5},
            {1, 2, 3 ,4 ,5},
        };

        Matrix matrixObj = new Matrix(matrixArr);
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input amount of power: ");
        power = sc.nextInt();
        sc.close();

        if (power < 1) {
            System.out.println("Please input power more than 0");
        } else {
            matrixObj.powerMatrix(power);
            System.out.printf("[Result of power %d]%n%s", power, matrixObj);
        }
    }
}