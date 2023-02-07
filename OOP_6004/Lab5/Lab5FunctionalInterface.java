import java.util.Arrays;

public class Lab5FunctionalInterface {
    static int[] data = { 28, 58, 8, 77, 48, 39 };
    static ArrayProcessor q1NumberOfEvenElement; // 4
    static ArrayProcessor q2IndexOfLargestEvenValue; // 1
    static ArrayProcessor myMedian; // n/2th element of sorted = 48
    public static void main(String[] args) {
        q1(); // 4
        q2(); // 1
        oneline(); // 48
    }

    static void q1() {
        q1NumberOfEvenElement = (data) -> {
            int count = 0;
            for (int num : data) {
                if (num % 2 == 0) count++;
            }
            return count;
        };

        System.out.println(q1NumberOfEvenElement.calculate(data));
    }

    static void q2() {
        q2IndexOfLargestEvenValue = (data) -> {
            int largest = 0;
            for (int i = 0; i < data.length; i++) {
                if (data[i] % 2 == 0 && data[i] > data[largest]) largest = i; 
            }

            return largest;
        };

        System.out.println(q2IndexOfLargestEvenValue.calculate(data));
    }

    static void oneline() {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);
        /* q3 */ //one statement
        myMedian = (data) -> data[data.length / 2];
        System.out.println(myMedian.calculate(tmp)); // 77
    }
}