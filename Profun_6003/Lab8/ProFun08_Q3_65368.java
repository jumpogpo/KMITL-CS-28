import java.util.Arrays;
import java.util.Scanner;

public class ProFun08_Q3_65368 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        topK(arr);
    }

    static void topK(int [] intArr) {
        Scanner sc = new Scanner(System.in);
        int[] emptyArr = new int[intArr.length];
        int input = 1;

        while (true) {
            System.out.print("Please input a number: ");
            input = sc.nextInt();

            if (input <= 0) break;

            if (Arrays.equals(intArr, emptyArr)) {
                intArr[0] = input;
            } else {
                int minValue = Integer.MAX_VALUE;
                int index = -1;

                for (int i = 0; i < intArr.length; i++) {
                    if (intArr[i] <= minValue && intArr[i] > 0 && intArr[i] > input) {
                        minValue = intArr[i];
                        index = i;
                    }
                }

                insertArr(intArr, index + 1, input);
            }

            System.out.println(Arrays.toString(intArr));
        }

        sc.close();
    }

    static int[] insertArr(int[] arr, int index, int value) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = value;
        return arr;
    }

}
