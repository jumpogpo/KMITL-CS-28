import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // Col
        int N = sc.nextInt(); //Row
        int[][] arr = new int[N][M];

        if ( M >= 1 && M <= 1000000) {
            if ( N >= 1 && N <= 1000000) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        int n = sc.nextInt();
                        arr[i][j] = n;
                    }
                }

                sc.close();

                int[][] aRef = new int[N+2][M+2];
                
                for (int i = 1; i <= M; i++) {
                    for (int j = 1; j <= N; j++) {
                        aRef[j][i] = arr[j-1][i-1];
                    }
                }
            
                for (int i = 0; i <= M; i++) {
                    for (int j = 0; j <= N; j++) {
                        if (aRef[j][i] == 9) {
                            if (aRef[j-1][i] == 1 || aRef[j][i-1] == 1 || aRef[j][i+1] == 1 || aRef[j+1][i] == 1) {
                                System.out.print("Yes");
                            } else {
                                System.out.print("No");
                            }
                        }
                    }
                }
            }
        }
    }
}