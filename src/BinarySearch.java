import java.util.Arrays;

/**
 * Created by tang on 1/14/15.
 */
public class BinarySearch extends RandomArray {
    public BinarySearch(int n) {
        super(n);
    }

    public void sort() {

    }

    public int binarySearch(int target) {
        int low = 0;
        int high = numbers.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (numbers[mid] < target) {
                low = mid + 1;
            }
            else if (numbers[mid] > target) {
                high = mid - 1;
            }
            else {
                return mid;
            }
        }

        return mid;
    }

    public static void main(String [] args) {
        BinarySearch search = new BinarySearch(10);
        Arrays.sort(search.numbers);

        for (int x : search.numbers) {
            System.out.println(x);
        }

        System.out.println();
        System.out.println(search.binarySearch(40));
    }
}
