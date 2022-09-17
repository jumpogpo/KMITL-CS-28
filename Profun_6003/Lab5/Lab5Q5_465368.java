import java.util.Scanner;

public class Lab5Q5_465368 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input your layer: ");
        int input = scan.nextInt();

        for (int e = 0; e < input; e++) {
            for (int a = 1; a < 5; a++) {
                for (int b = 0; b < ((input + 3) - a) - e; b++) {
                    System.out.print(" ");
                }
    
                for (int c = 0; c < a+e; c++) {
                    System.out.print("*");
                }
    
                for (int d = 0; d < (a-1)+e; d++) {
                    System.out.print("*");
                }
    
                System.out.println();
            }
        }

        for  (int g = 0; g < 4; g++) {
            for (int f = 0; f < input + 1 ; f++) {
                System.out.print(" ");
            }

            for (int h = 0; h < 3; h++) {
                System.out.print("*");
            }

            System.out.println();
        }

        scan.close();
    }
}