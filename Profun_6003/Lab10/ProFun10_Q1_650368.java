public class ProFun10_Q1_650368 {
    public static int count = 0;
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(appearsIn(arr, 2));
    }

    public static boolean appearsIn(int[] a, int n) {
        if (count > a.length - 1) return false;
        if (a[count] != n) {
            count += 1;
            return appearsIn(a, n);
        } else {
            return true;
        }
    }
}