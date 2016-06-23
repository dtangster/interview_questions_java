import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class EightQueens {
    private static boolean [][] board;
    private static Point [] pieces;

    private static void initialize() {
        board = new boolean[8][];
        pieces = new Point[8];

        for (int i = 0; i < 8; i++) {
            board[i] = new boolean[8];
            pieces[i] = new Point();
        }
    }

    public static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.println(pieces[i]);
        }
    }

    public static void create() {
        initialize();
        _create(0, new HashSet<Integer>(), new HashSet<Integer>());
    }

    private static boolean _create(int pieceIndex, Set<Integer> usedRows, Set<Integer> usedCols) {
        Set<Integer> currentlyUsedRows = new HashSet<Integer>(usedRows);
        Set<Integer> currentlyUsedCols = new HashSet<Integer>(usedCols);

        for (int x = 0; x < 8; x++) {
            for (int y = 0; !currentlyUsedRows.contains(x) && y < 8; y++) {
                if (!currentlyUsedCols.contains(y) && isValid(x, y)) {
                    board[x][y] = true;
                    currentlyUsedRows.add(x);
                    currentlyUsedCols.add(y);
                    pieces[pieceIndex].setLocation(x, y);

                    if (pieceIndex == 7 || _create(pieceIndex + 1, currentlyUsedRows, currentlyUsedCols)) {
                        return true;
                    }

                    board[x][y] = false;
                    currentlyUsedRows.remove(x);
                    currentlyUsedCols.remove(y);
                }

            }
        }

        return false;
    }

    private static boolean isValid(int x, int y) {
        for (int i = 0; i < 8; i++) {
            if (board[x][i] && i != y || board[i][y] && i != x) {
                return false;
            }
        }

        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args) {
        EightQueens.create();
        EightQueens.print();
    }
}
