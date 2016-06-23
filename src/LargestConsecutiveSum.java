import java.util.ArrayList;
import java.util.List;

/**
 * Created by tang on 10/22/14.
 */
public class LargestConsecutiveSum {
    private int [] numbers;

    public LargestConsecutiveSum(int n) {
        numbers = new int[n];

        for (int i = 0; i < n; i ++) {
            numbers[i] = (int) (Math.random() * 100 % 10);

            if (((int) (Math.random() * 100 % 2)) == 1) {
                numbers[i] *= -1;
            }
        }
    }

    public void printSequence() {
        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }
    }

    public int getLargestConsecutiveSum() {
        int largest = 0;
        int current = 0;

        for (int i = 0; i < numbers.length; i++) {
            current += numbers[i];

            if (current < 0) {
                current = 0;
            }
            else if (current > largest) {
                largest = current;
            }
        }

        return largest;
    }

    public static void main(String [] args) {
        LargestConsecutiveSum test = new LargestConsecutiveSum(10);

        test.printSequence();
        System.out.println("\nLargest consecutive sum is: " + test.getLargestConsecutiveSum());
    }
}
