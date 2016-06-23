/**
 * Created by tang on 12/30/14.
 */
public class EightBalls {
    public static int findSpecialBall(int [] balls) {
        return _findSpecialBall(balls, 0, balls.length - 1);
    }

    private static int _findSpecialBall(int [] balls, int low, int high) {
        int length = high - low + 1;
        int mid = (length - 1) / 2 + low;
        int remainder = high;

        if ((length & 1) > 0) {
            mid--;
            high--;
        }

        int leftHalfTotal = _getSum(balls, low, mid);
        int rightHalfTotal = _getSum(balls, mid + 1, high);

        if (leftHalfTotal == rightHalfTotal) {
            if ((length & 1) > 0 && balls[remainder] != leftHalfTotal) {
                return remainder;
            }
            else {
                return -1;
            }
        }
        else if (length == 2) {
            int temp = 0;

            while (temp == low || temp == high) {
                temp++;
            }

            return balls[temp] == balls[low] ? high : low;
        }

        int indexFromLeftHalf = _findSpecialBall(balls, low, mid);

        if (indexFromLeftHalf != -1) {
            return indexFromLeftHalf;
        }
        else {
            return _findSpecialBall(balls, mid + 1, high);
        }
    }

    private static int _getSum(int [] args, int low, int high) {
        int sum = 0;

        while (low <= high) {
            sum += args[low++];
        }

        return sum;
    }

    public static void main(String [] args) {
        int [] balls = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 };

        System.out.println(findSpecialBall(balls));
    }
}
