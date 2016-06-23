/**
 * Created by tang on 10/28/14.
 */
public class RobotPath {
    public int possiblePathsToBottomRight(int x, int y) {
        return calculate(x, y, 1, 1);
    }

    public int calculate(int x, int y, int curX, int curY) {
        if (curX == x || curY == y) {
            return 1;
        }
        if (curX > x || curY > y) {
            return 0;
        }

        return calculate(x, y, curX + 1, curY) + calculate(x, y, curX, curY + 1);
    }

    public static void main(String [] args) {
        RobotPath robotPath = new RobotPath();

        System.out.println(robotPath.possiblePathsToBottomRight(3, 3));
    }
}
