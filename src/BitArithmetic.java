import java.util.HashSet;
import java.util.Set;

public class BitArithmetic {
    public static int add(int x, int y) {
        int result = x ^ y;
        int carries = (x & y) << 1;

        while (carries > 0) {
            int newResult = result ^ carries;
            carries = (result & carries) << 1;
            result = newResult;
        }

        return result;
    }

    public static int recursiveAdd(int x, int y) {
        if (x == 0) {
            return y;
        }

        return recursiveAdd((x & y) << 1, x ^ y);
    }

    public static int multiply(int x, int y) {
        int result = 0;

        while (x != 0) {
            if ((x & 1) == 1) {
                result = add(result, y);
            }

            x >>= 1;
            y <<= 1;
        }

        return result;
    }

    public static int recursiveMultiply(int x, int y) {
        if (x == 0) {
            return 0;
        }

        int result = 0;

        if ((x & 1) == 1) {
            result = recursiveAdd(result, y);
        }

        return recursiveAdd(result, recursiveMultiply(x >> 1, y << 1));
    }

    public static int subtract(int x, int y) {
        int result = add(x, add(~y, 1));

        if (x > y) {
            int temp = result;

            temp |= (temp >>>  1);
            temp |= (temp >>>  2);
            temp |= (temp >>>  4);
            temp |= (temp >>>  8);
            temp |= (temp >>> 16);
            temp -= (temp >>> 1);
            result ^= temp;
        }

        return result;
    }

    public static void main(String [] args) {
        System.out.println(recursiveAdd(5, 9));
        System.out.println(recursiveMultiply(5, 4));
        System.out.println(subtract(8, 4));
    }
}
