public class Lab5Q4_265368 {
    public static void main(String[] args) {
        String s1 = "I am happy"; // 0 with s1 = s1.toLowerCase();
        String s2 = "xyz"; // -1

        s1 = s1.toLowerCase();

        for (int i = 0; i < s1.length(); i++) {
            char letter = s1.charAt(i);

            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                System.out.println(i);
                break;
            }

            if (i == s1.length() - 1) {
                System.out.println(-1);
            }
        }

        for (int s = 0; s < s2.length(); s++) {
            char letter = s2.charAt(s);

            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
                System.out.println(s);
                break;
            }

            if (s == s2.length() - 1) {
                System.out.println(-1);
            }
        }
    }
}
