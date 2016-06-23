import java.util.HashMap;
import java.util.Map;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=6081
 */
public class BootsExchange {
    public static int exchangeCount(int [] left, int [] right) {
        Map<Integer, Integer> boots = new HashMap<Integer, Integer>();
        int exchangeCount = 0;

        for (int leftSize : left) {
            Integer count = boots.get(leftSize);

            if (count == null) {
                boots.put(leftSize, 1);
            }
            else {
                boots.put(leftSize, count + 1);
            }
        }

        for (int rightSize : right) {
            Integer count = boots.get(rightSize);

            if (count == null || count == 0) {
                exchangeCount++;
            }
            else {
                boots.put(rightSize, count - 1);
            }
        }

        return exchangeCount;
    }

    public static void main(String [] args) {
        int [] left = {1, 3, 1};
        int [] right = {1, 2, 3};

        System.out.println(exchangeCount(left, right));
    }
}
