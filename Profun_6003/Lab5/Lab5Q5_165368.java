public class Lab5Q5_165368 {
    public static void main(String[] args) {
        int n = 10;

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (a == b) {
                    System.out.print(" ");
                } else if (a == 9-b) {
                    System.out.print(" ");
                } else {
                    System.out.print("x");
                }
            }

            System.out.println();
        }
    }
}

//  xxxxxxxx
// x xxxxxx x
// xx xxxx xx
// xxx xx xxx
// xxxx xxxx
// xxxx xxxx
// xxx xx xxx
// xx xxxx xx
// x xxxxxx x
//  xxxxxxxx