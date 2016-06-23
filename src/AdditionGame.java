/**
 * http://community.topcoder.com/stat?c=problem_statement&pm=11317
 */
public class AdditionGame {
    public static int getMaximumPoints(int a, int b, int c, int n) {
        int maxPoints = 0;

        for (int i = 0; i < n; i++) {
            if (a > b) {
                if (a > c) {
                    maxPoints += a;
                    a = decrement(a);
                }
                else {
                    maxPoints += c;
                    c = decrement(c);
                }
            }
            else if (b > c) {
                maxPoints += b;
                b = decrement(b);
            }
            else {
                maxPoints += c;
                c = decrement(c);
            }
        }

        return maxPoints;
    }

    private static int decrement(int number) {
        return number > 1 ? number - 1 : 1;
    }

    public static void main(String [] args) {
        System.out.println(getMaximumPoints(3,5,48,40));
    }
}
