public class Lab6Q2_265368 {
    public static void main(String[] args) {
        String input = "10 10 10 01 10 10";
        int count = 1;

        for (int i = 1; i < input.length() - 1; i += 3) {
            if (!input.substring(i+2, i+4).equals(input.substring(i-1, i+1))) {
                count++;
            }
        }

        System.out.println(count);
    }
}