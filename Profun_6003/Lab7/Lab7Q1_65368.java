public class Lab7Q1_65368 {
    public static void main(String[] args) {
        System.out.println("Factorial of 10! is " + factorial(10));
    }

    static int factorial(int num) {
        int result = num;

        for (int i = result - 1; i > 0; i--) {
            result *= i;
        }

        return result;
    }
}
