import java.util.HashSet;
import java.util.Set;

public class MatchParenthesis {
    private static Set<String> validParenthesis;

    public static void printValidParenthesis(int n) {
        validParenthesis = new HashSet<String>();
        _printValidParenthesis(n - 1, n, "(");

        for (String text : validParenthesis) {
            System.out.println(text);
        }
    }

    private static void _printValidParenthesis(int openRemaining, int closeRemaining, String sequence) {
        if (openRemaining < 0 || openRemaining > closeRemaining) {
            return;
        }

        if (openRemaining == 0 && closeRemaining == 0) {
            validParenthesis.add(sequence);
            return;
        }

        _printValidParenthesis(openRemaining - 1, closeRemaining, sequence + "(");
        _printValidParenthesis(openRemaining, closeRemaining - 1, sequence + ")");
    }

    public static void main(String [] args) {
        printValidParenthesis(4);
    }
}
