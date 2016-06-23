import java.util.HashMap;
import java.util.Map;

/**
 * Created by tang on 1/3/15.
 */
public class BaseRepresentation {
    public static final Map<Integer, String> numberToHex = new HashMap<Integer, String>();

    static {
        for (int i = 0; i < 9; i++) {
            numberToHex.put(i, i + "");
        }

        numberToHex.put(10, "A");
        numberToHex.put(11, "B");
        numberToHex.put(12, "C");
        numberToHex.put(13, "D");
        numberToHex.put(14, "E");
        numberToHex.put(15, "F");
    }

    public static void printBinaryRepresentation(int number) {
        if (number == 0) {
            return;
        }

        printBinaryRepresentation(number / 2);

        if (number % 2 == 0) {
            System.out.print(0);
        }
        else {
            System.out.print(1);
        }
    }

    public static void printHexadecimalRepresentation(int number) {
        if (number == 0) {
            return;
        }

        printHexadecimalRepresentation(number / 16);
        System.out.print(numberToHex.get(number % 16));
    }

    public static void main(String [] args) {
        printBinaryRepresentation(16);
        System.out.println();
        printHexadecimalRepresentation(18);
    }
}
