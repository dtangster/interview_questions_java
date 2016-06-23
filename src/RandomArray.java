/**
 * Created by tang on 10/23/14.
 */
public abstract class RandomArray {
    protected int [] numbers;

    public RandomArray(int n) {
        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = (int) (Math.random() * 1000 % 50);
        }
    }

    public void printNumbers() {
        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }
    }

    public abstract void sort();
}
