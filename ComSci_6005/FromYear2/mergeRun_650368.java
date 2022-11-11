import java.util.Arrays;

public class mergeRun_650368 {
    public static void main(String[] args) {
        int[] x = {2, 4, 6, 15, 7, 10, 13, 18, 3, 20, 21, 23, 1, 5, 8, 22};
        mergeRun(x, 2, 2);
    }

    static void mergeRun(int [] x, int p, int q){
        int n = (int) Math.pow(2, p);
        int m = (int) Math.pow(2,q);
        int t = (int) Math.pow(2, p*q);
        int s = 0, e = 1, f = 1, tmp = 1, k = 0, expo = 1, r = (int) Math.pow(2, expo), plus = r, now = 0;

        for(int z = 0; z < n-1; z++){
            int [] left = new int[f*m]; 
            int [] right = new int[f*m];
            int i = 0, j = 0;

            copy(x, s, e*m-1, left);
            System.out.println(Arrays.toString(left));

            s += (f*m);
            e += tmp;
            copy(x, s, e*m-1, right);
            System.out.println(Arrays.toString(right));

            if (s == t - (f*m)) {
                s = 0;
                f++;
                e = f;
                tmp++;
            } else {
                s += (f*m);
                e += tmp;
            }

            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    x[k++] = left[i++];
                } else {
                    x[k++] = right[j++];
                }
            }

            while (i < left.length) { 
                x[k++] = left[i++];
            }

            while (j <  right.length) { 
                x[k++] = right[j++];
            }

            k = (r+now)*m;

            if (k == t) {
                k = 0;
                expo++;
                r = (int) Math.pow(2, expo);
                plus = r;
            } else {
                now += plus;
            }

            System.out.println(Arrays.toString(x));
        }
    }

    static void copy(int[] x, int i, int j, int[] arr) {
        int b = 0;

        for(int a = i; a <= j; a++){
            arr[b] = x[a];
            b++;
        }
    }
}