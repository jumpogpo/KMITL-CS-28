public class Lab5Q5_465368 {
    public static void main(String[] args) {
        for (int e = 0; e < 3; e++) {
            for (int a = 1; a < 5; a++) {
                for (int b = 0; b < (6-a) - e; b++) {
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

        for  (int g = 0; g < 3; g++) {
            for (int f = 0; f < 4; f++) {
                System.out.print(" ");
            }

            for (int h = 0; h < 3; h++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}