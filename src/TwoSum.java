import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            int remainder = target - numbers[i];
            Integer firstIndex = map.get(remainder);

            if (firstIndex != null) {
                int [] output = {firstIndex, i + 1};
                return output;
            }

            Integer index = map.get(numbers[i]);

            if (index == null) {
                map.put(numbers[i], i + 1);
            }
        }

        return null;
    }

    public static void main(String [] args) {
        
    }
}