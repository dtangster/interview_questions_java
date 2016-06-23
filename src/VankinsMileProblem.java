import java.util.HashMap;
import java.util.Map;

/**
 * CSS155 Hands-on #1, Problem 6
 */
public class VankinsMileProblem {
    public static void printMatrix(Integer [][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }

            System.out.println();
        }
    }

    public static int getLargestScore(Integer [][] matrix) {
        return _getLargestScore(matrix, 0, 0, 0, 0);
    }

    private static int _getLargestScore(Integer [][] matrix, int row, int col, int current, int largest) {
        if (row >= 5 || col >= 5) {
            return 0;
        }

        current += matrix[row][col];

        if (current < 0) {
            current = 0;
        }
        else if (current > largest) {
            largest = current;
        }

        int right = _getLargestScore(matrix, row, col + 1, current, largest);
        int down = _getLargestScore(matrix, row + 1, col, current, largest);

        if (right > largest) {
            largest = right;
        }
        if (down > largest) {
            largest = down;
        }

        return largest;
    }

    public static void main(String [] args) {
        Integer [][] matrix = new Integer [5][5];

        Integer [] row1 = { -1,  7, -8, 10, -5 };
        Integer [] row2 = { -4, -9,  8, -6,  0 };
        Integer [] row3 = {  5, -2, -6, -6,  7 };
        Integer [] row4 = { -7,  4,  7, -3, -3 };
        Integer [] row5 = {  7,  1, -6,  4, -9 };

        matrix[0] = row1;
        matrix[1] = row2;
        matrix[2] = row3;
        matrix[3] = row4;
        matrix[4] = row5;

        printMatrix(matrix);
        System.out.println(getLargestScore(matrix));
    }
}
