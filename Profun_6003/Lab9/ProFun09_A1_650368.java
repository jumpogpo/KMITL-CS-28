import java.util.Arrays;

public class ProFun09_A1_650368 {
    public static void main(String[] args) {
        int[] data = { 0, 1, 0, 1, 1, 0, 0, 0, 1};
        shake(data);
        System.out.println(Arrays.toString(data));
    }

    static int[] shake(int[] data) {
        int store = 0;
        int change = 1;

        while (change > 0) {
            change = 0;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] > data[i+1]) {
                    store = data[i];
                    data[i] = data[i+1];
                    data[i+1] = store;
                    change++;
                }
            }
        }

        return data;
    }
}