import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=12029
 */
public class AndEquation {
    public static int AndEquation(int [] numbers) {
        if (numbers.length < 2 || numbers.length == 2 && numbers[0] != numbers[1]) {
            return -1;
        }

        Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
        int result = -1;

        for (int i : numbers) {
            Integer count = nums.get(i);
            result &= i;

            if (count == null) {
                nums.put(i, 1);
            }
            else if (i == 0) {
                return 0;
            }
            else {
                nums.put(i, count + 1);
            }
        }

        int testResult = -1;
        Integer count = nums.get(result);

        if (count != null) {
            if (count == 1) {
                nums.remove(result);
            }

            for (int i : nums.keySet()) {
                testResult &= i;
            }
        }

        return testResult == result ? result : -1;
    }

    public static void main(String [] args) {
        int [] numbers = { 191411,256951,191411,191411,191411,256951,195507,191411,192435,191411,
                           191411,195511,191419,191411,256947,191415,191475,195579,191415,191411,
                           191483,191411,191419,191475,256947,191411,191411,191411,191419,256947,
                           191411,191411,191411 };

        System.out.println(AndEquation(numbers));
    }
}
