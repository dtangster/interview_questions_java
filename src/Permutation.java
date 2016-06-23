import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class Permutation {
    public static Set<String> permutate(String text) {
        return _permutate("", text);
    }

    private static Set<String> _permutate(String prefix, String remaining) {
        int length = remaining.length();
        Set<String> words = new LinkedHashSet<String>();

        if (prefix.length() > 0) {
            words.add(prefix);
        }

        for (int i = 0; i < length; i++) {
            words.addAll(_permutate(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1)));
        }

        return words;
    }

    public static void main(String [] args) {
        System.out.println(permutate("abc"));
    }
}
