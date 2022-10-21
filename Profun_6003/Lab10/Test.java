import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,-2, 3, 4, -5};
        System.out.println(Arrays.toString(negativesToZero(arr, arr.length - 1)));
    }

    public static int[] negativesToZero(int[] a, int idx) {
        if (a[idx] < 0) a[idx] = 0;
        if (idx == 0) return a;
        return negativesToZero(a, idx - 1);
    }
}
