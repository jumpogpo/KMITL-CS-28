public class Lab5Q5_365368 {
    public static void main(String[] args) {
        int n = 4;

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < 3-a; b++) {
                System.out.print(" ");
            }

            for (int c = 0; c < a+1; c++) {
                System.out.print("P");
            }

            for (int d = 0; d < a; d++) {
                System.out.print("P");
            }

            System.out.println();

        }
    }
}