public class Lab5Q365368 {
    public static void main(String[] args) {
        int sum = 0;

        for (int n = 1; n < 200; n++) {
            if (n % 10 == 0) {
                continue;
            } else {
                sum += n;
            }
        }

        System.out.println(sum);
    }
}