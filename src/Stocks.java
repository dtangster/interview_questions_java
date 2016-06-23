/**
 * Created by tang on 1/18/15.
 */
public class Stocks {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int max = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
            }
        }

        return max - min;
    }

    public static void main(String [] args) {
        int [] numbers = {2, 1};
        System.out.println(maxProfit(numbers));
    }
}
