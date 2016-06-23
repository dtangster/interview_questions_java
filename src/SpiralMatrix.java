public class SpiralMatrix {
    public static int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        int count = 1;

        for (int i = 0; i <= n / 2; i++) {
            for (int j = i; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = count++;
                }
            }
            for (int j = i; j < n; j++) {
                if (matrix[j][n - i - 1] == 0) {
                    matrix[j][n - i - 1] = count++;
                }
            }
            for (int j = i; j < n; j++) {
                if (matrix[n - i - 1][n - j - 1] == 0) {
                    matrix[n - i - 1][n - j - 1] = count++;
                }
            }
            for (int j = i; j < n; j++) {
                if (matrix[n - j - 1][i] == 0) {
                    matrix[n - j - 1][i] = count++;
                }
            }
        }

        return matrix;
    }

    public static void main(String [] args) {
        int [][] matrix = generateMatrix(5);
        System.out.println(matrix);
    }
}
