import java.util.Arrays;

public class Lab7_650368_max_square_and_edit_distance {
    public static void main(String[] args) {
        // int[][] data = {
        //     { 0, 0, 1, 0, 0 },
        //     { 1, 1, 1, 1, 1 },
        //     { 0, 1, 1, 1, 1 },
        //     { 1, 1, 1, 1, 0 }
        // };
        int[][] data = {
            { 0, 1, 1, 0, 1 },
            { 1, 1, 0, 1, 0 },
            { 0, 1, 1, 1, 0 },
            { 1, 1, 1, 1, 0 },
            { 1, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0 }
        };

        int maxSize = L7_T1_MaxSquare.find_max_area_recurse_entry(data);
        System.out.println("T1 Q1: " + maxSize);

        L7_T1_MaxSquare.q1_2_maximum_size_square_sub_matrix(data);

        String s1 = "horse";
        String s2 = "ros";
        int minEdit = q2_string_edit_distance(s1, s2);
        System.out.println("T2: " + minEdit);
    }

    private static int q2_string_edit_distance(String str1, String str2) {
        // begin preparation
        int[][] cache = new int[str1.length() + 1][str2.length() + 1];
        for (int[] row : cache)
            Arrays.fill(row, Integer.MAX_VALUE);
        int r;
        for (r = 0; r < cache.length; r++) {
            cache[r][str2.length()] = str1.length() - r; // edit from "str2.length() - r" to "str1.length() - r"
        }
        for (int c = 0; c < cache[0].length; c++) {
            cache[str1.length()][c] = str2.length() - c; // edit form "str1.length() - c" to "str2.length() - c"
        }
        // end preparation
        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                // your code
                cache[i][j] = (str1.charAt(i) == str2.charAt(j))
                        ? cache[i + 1][j + 1]
                        : 1 + Math.min(cache[i + 1][j], Math.min(cache[i][j + 1], cache[i + 1][j + 1]));
            }
        }
        return cache[0][0];
    }
}

class L7_T1_MaxSquare {
    private static int[][] matrix;
    private static int rows;
    private static int cols;
    private static int max_so_far_for_recursion = -1;

    public static int find_max_area_recurse_entry(int[][] mat) {
        // begin preparation
        matrix = mat;
        rows = matrix.length;
        cols = matrix[0].length;
        // end preparation
        q1_1_find_max_area_recurse(matrix, 0, 0);
        return max_so_far_for_recursion * max_so_far_for_recursion;
    }

    public static void q1_2_maximum_size_square_sub_matrix(int[][] data) {
        int m = data.length;
        int n = data[0].length;
        int maxSize = Integer.MIN_VALUE;
        int[][] sub = new int[m][n];
        for (int i = 0; i < m; i++) {
            sub[i][0] = data[i][0];
        }
        for (int i = 0; i < n; i++) {
            sub[0][i] = data[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sub[i][j] = (data[i][j] == 0) ? 0
                        : 1 + Math.min(sub[i - 1][j], Math.min(sub[i][j - 1], sub[i - 1][j - 1]));
                maxSize = Math.max(maxSize, sub[i][j]);
            }
        }
        System.out.println("T1 Q2: " + (maxSize * maxSize));
    }

    private static int q1_1_find_max_area_recurse(int[][] mat, int r, int c) {
        if (r == rows || c == cols)
            return 0;
        // your code
        int size = 1 + Math.min(q1_1_find_max_area_recurse(mat, r + 1, c), Math.min(
                q1_1_find_max_area_recurse(mat, r, c + 1), q1_1_find_max_area_recurse(mat, r + 1, c + 1)));

        if (mat[r][c] == 0)
            return 0;

        max_so_far_for_recursion = (size > max_so_far_for_recursion) ? size : max_so_far_for_recursion;
        return size;
    }
}
