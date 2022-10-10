import java.util.Arrays;
import java.util.Random;

public class ProFun08_Q3_650368 {
    public static void main(String[] args) {
        int[][] map = new int[8][13];
        markMap(map);

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    static int [][] markMap(int [][] bMap) {
        Random rand = new Random();
        int bomAmount = rand.nextInt(52);
        int[] position = {-1, 0, 1};

        for (int i = 0; i < bomAmount; i++) {
            int column = rand.nextInt(8);
            int row = rand.nextInt(13);
            bMap[column][row] = 9;
        }

        for (int c = 0; c < bMap.length; c++) {
            for (int r = 0; r < bMap[c].length; r++) {
                if (bMap[c][r] == 0) {
                    int bomb = 0;

                    for (int posC : position) {
                        for (int posR : position) {
                            if ((c + posC) < 0 || (c + posC) > 7 || (r + posR) < 0 || (r + posR) > 12) continue;
                            if (bMap[c + posC][r + posR] == 9) bomb++;
                        }
                    }

                    bMap[c][r] = bomb;
                }
            }
        }

        return bMap;
    }
}
