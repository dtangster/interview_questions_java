import java.util.Arrays;

/**
 * Created by tang on 10/23/14.
 */
public class QuickSort extends RandomArray {

    public QuickSort(int n) {
        super(n);
    }

    public void sort() {
        quickSort(0, numbers.length - 1);
    }

    public void quickSort(int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(begin, end);
            quickSort(begin, pivotIndex - 1);
            quickSort(pivotIndex + 1, end);
        }
    }

    public int partition(int begin, int end) {
        int randomIndex = (int) (Math.random() * 1000 % (end - begin + 1) + begin);
        int temp = numbers[randomIndex];
        numbers[randomIndex] = numbers[end];
        numbers[end] = temp;

        int pivot = numbers[end];
        int i = begin;

        for (int j = begin; j < end; j++) {
            if (numbers[j] < pivot) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
            }
        }

        numbers[end] = numbers[randomIndex];
        numbers[i] = pivot;

        return i;
    }

    public static void main(String [] args) {
        QuickSort mergeSort = new QuickSort(10);

        mergeSort.printNumbers();
        mergeSort.sort();
        mergeSort.printNumbers();
    }
}
