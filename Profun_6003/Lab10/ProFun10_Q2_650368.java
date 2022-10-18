public class ProFun10_Q2_650368 {
    public static int count, index = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 2};
        System.out.println(occurrences(arr, 2));
    }

    public static int occurrences(int[] a, int n) {
        if (index >= a.length) return count;
        if (a[index] == n) {
            count += 1;
        }

        index += 1;
        return occurrences(a, n);
    }
}
