import java.util.Arrays;

public class Matrix {
    private int[][] matrixArr;

    public Matrix(int[][] inputMatrix) {
        matrixArr = inputMatrix;
    }

    public void powerMatrix(int powerAmount) {
        if (powerAmount == 1) return;

        int[][] currentMatrix = matrixArr;

        for (int power = 2; power <= powerAmount; power++) {
            int[][] multipleMatrixResult = new int[matrixArr.length][matrixArr[0].length];
            
            for (int i = 0; i < matrixArr.length; i++) {
                for (int j = 0; j < matrixArr[i].length; j++) {
                    for (int k = 0; k < matrixArr[i].length; k++) {
                        multipleMatrixResult[i][j] += currentMatrix[i][k] * matrixArr[k][j];
                    }
                }
            }
            currentMatrix = multipleMatrixResult;
        }

        matrixArr = currentMatrix;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        
        for (int[] row : matrixArr) {
            msg.append(Arrays.toString(row) + "\n");
        } 

        return msg.toString();
    }
}
