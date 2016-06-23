import java.util.Arrays;

/**
 * Created by tang on 10/23/14.
 */
public class MergeSort extends RandomArray {

    public MergeSort(int n) {
        super(n);
    }

    public void sort() {
        mergeSort(0, numbers.length - 1);
    }

    public void mergeSort(int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;

            mergeSort(begin, mid);
            mergeSort(mid + 1, end);
            merge(begin, mid, end);
        }
    }

    public void merge(int begin, int mid, int end) {
        int [] leftHalf = new int[mid - begin + 1];
        int [] rightHalf = new int[end - mid];

        for (int i = begin, j = 0; i <= mid; i++, j++) {
            leftHalf[j] = numbers[i];
        }

        for (int i = mid + 1, j = 0; i <= end; i++, j++) {
            rightHalf[j] = numbers[i];
        }

        int i = 0; // left half index
        int j = 0; // right half index

        for (int k = 0, l = begin; k <= end - begin; k++, l++) {
            if (j == rightHalf.length || i < leftHalf.length && leftHalf[i] < rightHalf[j]) {
                numbers[l] = leftHalf[i];
                i++;
            }
            else {
                numbers[l] = rightHalf[j];
                j++;
            }
        }
    }

    public static void main(String [] args) {
        MergeSort mergeSort = new MergeSort(10);

        mergeSort.printNumbers();
        mergeSort.sort();
        mergeSort.printNumbers();
    }
}
