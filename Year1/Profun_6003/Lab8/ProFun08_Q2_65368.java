public class ProFun08_Q2_65368 {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(kadane(arr));
    }

    static int kadane(int [] arr) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for(int index = 0; index < arr.length; index++) {
            max_ending_here = max_ending_here + arr[index];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }  
            
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }

        return max_so_far;
    }
}