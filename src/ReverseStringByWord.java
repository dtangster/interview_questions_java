import java.util.Stack;

public class ReverseStringByWord {

    public static String reverseIterative(String text) {
        Stack<String> words = new Stack<String>();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (character == ' ' && buffer.length() != 0) {
                words.push(buffer.toString());
                buffer = new StringBuffer();
            }
            else {
                buffer.append(character);
            }
        }

        if (buffer.length() > 0) {
            words.push(buffer.toString());
            buffer = new StringBuffer();
        }

        while (!words.isEmpty()) {
            buffer.append(words.pop() + " ");
        }

        return buffer.toString();
    }

    public static String reverseRecursive(String text) {
        return _reverseRecursive(text, 0);
    }

    private static String _reverseRecursive(String text, int index) {
        if (index >= text.length()) {
            return "";
        }

        StringBuffer buffer = new StringBuffer();

        while (index < text.length() && text.charAt(index) != ' ') {
            buffer.append(text.charAt(index));
            index++;
        }

        while (index < text.length() && text.charAt(index) == ' ') {
            index++;
        }

        return _reverseRecursive(text, index) + " " + buffer.toString();
    }

    public static void main(String [] args) {
        String input = "Hi my name is David!";

        System.out.println(ReverseStringByWord.reverseIterative(input));
        System.out.println(ReverseStringByWord.reverseRecursive(input));
    }
}
