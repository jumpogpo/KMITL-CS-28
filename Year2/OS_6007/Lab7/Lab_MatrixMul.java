import java.util.Arrays;
public class Lab_MatrixMul {
    public static void main(String[] args) {
        int[][] inputA = { { 5, 6, 7 }, { 4, 8, 9 } };
        int[][] inputB = { { 6, 4 }, { 5, 7 }, { 1, 1 } };
        MyData matA = new MyData(inputA);
        MyData matB = new MyData(inputB);
        int matC_r = matA.data.length;
        int matC_c = matB.data[0].length;
        MyData matC = new MyData(matC_r, matC_c);
        /* Q4 construct 2D array for each "thread"
        with respected to each cell in matC,
        then start each thread */

        Thread[] threads = new Thread[matC_r * matC_c];
        int threadCount = 0;

        for (int i = 0; i < matC_r; i++) {
            for (int j = 0; j < matC_c; j++) {
                threads[threadCount] = new Thread(new MatrixMulThread(i, j, matA, matB, matC));
                threads[threadCount].start();
                threadCount++;
            }
        }

        // Q5 join each thread
        for (int i = 0; i < matC_r * matC_c; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }

        matC.show();
    }
}

class MatrixMulThread implements Runnable {
    int processing_row; int processing_col;
    MyData datA; MyData datB; MyData datC;
    MatrixMulThread(int tRow, int tCol, MyData a, MyData b, MyData c) {
        // Q1 code here
        processing_row = tRow;
        processing_col = tCol;
        datA = a;
        datB = b;
        datC = c;
    }
    /* Q2 */ public void run() {
        // Q3
        int sum = 0;
        for (int i = 0; i < datA.data[0].length; i++) {
            sum += datA.data[processing_row][i] * datB.data[i][processing_col];
        }
        datC.data[processing_row][processing_col] = sum;
        // System.out.println("perform sum of multiplication of assigned row and col");
    }
}

class MyData {
    int[][] data;
    MyData(int[][] m) { data = m; }
    MyData(int r, int c) {
        data = new int[r][c];
        for (int[] aRow : data)
        Arrays.fill(aRow, 9);
        // 9 will be overwritten anyway
    }
    void show() {
        System.out.println(Arrays.deepToString(data));
    }
} //class