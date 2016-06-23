/**
 * Created by tang on 10/23/14.
 */
public class BubbleSort extends RandomArray {

    public BubbleSort(int n) {
        super(n);
    }

    public void sort() {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length - i; j++) {
                if (numbers[j] < numbers[j - 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String [] args) {
        BubbleSort bubbleSort = new BubbleSort(10);

        bubbleSort.printNumbers();
        bubbleSort.sort();
        bubbleSort.printNumbers();
    }
}
