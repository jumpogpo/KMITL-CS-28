public class Lab7Q2_65368 {
    public static void main(String[] args) {
        int[] data = {7, 1, 2, -1, 3, 4, 10, -12, 3, 21, -9};
        int max = maxElement(data);
        System.out.println(max);
    }

    static int maxElement(int[] arr) {
        int currentMax = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > currentMax) {
                currentMax = arr[i];
            }
        }

        return currentMax;
    }
}
