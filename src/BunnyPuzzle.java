/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=10740
 */
public class BunnyPuzzle {
    public static int waysToJump(int [] bunnies) {
        int ways = 0;

        for (int i = 1; i < bunnies.length; i++) {
            int posA = bunnies[i - 1];
            int posB = bunnies[i];

            int temp = 2 * posB - posA;

            if (i + 1 == bunnies.length || bunnies[i + 1] > temp) {
                ways++;
            }

            temp = 2 * posA - posB;

            if (i - 2 < 0 || bunnies[i - 2] < temp) {
                ways++;
            }
        }

        return ways;
    }

    public static void main(String [] args) {
        int [] bunnies = {-677, -45, -2, 3, 8, 29, 384, 867};

        System.out.println(waysToJump(bunnies));
    }
}
