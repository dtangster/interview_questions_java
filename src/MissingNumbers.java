public class MissingNumbers {
    public static void printMissingNumbers(int [] numbers) { // 0-99 range only
        int current = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (current == numbers[i] - 1) {
                System.out.print(current);
            }
            else {
                System.out.print(current + "-" + (numbers[i] - 1));
            }

            if (numbers[i] != 99) {
                System.out.print(",");
            }

            current = numbers[i] + 1;
        }

        if (current < 100) {
            System.out.print(current);

            if (current != 99) {
                System.out.print("-99");
            }
        }
    }

    public static void main(String [] args) {
        int [] numbers = {1,5,7,51,99};
        printMissingNumbers(numbers);
    }
}
