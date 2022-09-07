import java.util.Arrays;

public class Lab6Q2_165368 {
    public static void main(String[] args) {
        int [] data = {7, 1, 2, -1, 3, 4, 10, -12, 3, 21, -9};

        /* [Solution 1] */

        Arrays.sort(data);
        System.out.println(data[data.length - 1]); 
        

        /* [Solution 2] */
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }

        System.out.println(max);
    }
}