public class RotateMatrix {
    private int [][] matrix;

    public RotateMatrix(int n) {
        matrix = new int[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = new int[n];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 1000 % 11);
            }
        }
    }

    public void rotate() {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j]; // top left
                matrix[i][j] = matrix[n - j - 1][i]; // bottom left
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1]; // bottom right
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1]; // top right
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public void printMatrix() {
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf(" %2d", matrix[i][j]);
            }

            System.out.println();
        }
    }

    public static void main(String [] args) {
        RotateMatrix matrix = new RotateMatrix(5);
        matrix.printMatrix();
        matrix.rotate();
        matrix.printMatrix();
    }
}
