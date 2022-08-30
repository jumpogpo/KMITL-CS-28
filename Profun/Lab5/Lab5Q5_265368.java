public class Lab5Q5_265368 {
    public static void main(String[] args) {
        int n = 4;

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < (a+1); b++) {
                System.out.printf("%d ", n-b);
            }
    
            System.out.println();
        }
    }
}
