import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] intArr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int swicth = 0;
        
        while (true) {
            System.out.print("n : ");
            int n = sc.nextInt();
            intArr[0] = n;
            if (n > 0)
                for (int i = 0; i < intArr.length - 1; i++)
                    if (intArr[i] < intArr[i + 1]) {
                        swicth = intArr[i];
                        intArr[i] = intArr[i + 1];
                        intArr[i + 1] = swicth;
                    }
            for (int i = 9; i > 0; i--) {
                swicth = intArr[i - 1];
                intArr[i - 1] = intArr[i];
                intArr[i] = swicth;
            }

            System.out.println(Arrays.toString(intArr));
            System.out.println();
        }

        sc.close();
    }
}
