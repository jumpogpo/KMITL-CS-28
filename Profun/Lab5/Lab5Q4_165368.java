public class Lab5Q4_165368 {
    public static void main(String[] args) {
        String str = "WWWWMMMMWMWMWMWMMMWWWWWM";
        int W = 0;
        int M = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'W') {
                W++;
            } else {
                M++;
            }
        }

        System.out.printf("Man: %d%nWomen: %d%n", M, W);
    }
}
