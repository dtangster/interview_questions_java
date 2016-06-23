import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 4 men are on side X of a shaky bridge on a dark night. They want to cross the bridge to the other side, Y.
 * The bridge is only strong enough to support two men at a time. It is also necessary for the men crossing the
 * bridge to carry a lantern to guide their way, and the four men have only one lantern between them.
 *
 * Times to cross the bridge:
 *
 * A = 1 min
 * B = 2 min
 * C = 5 min
 * D = 10 min
 *
 * Solutions:
 *
 * {ABCD} ===== {} 0
 * {CD}   ===== {AB} 2 // #1 This step interchangeable to use A or B to cross back
 * {ACD}  ===== {B} 3
 * {A}    ===== {BCD} 13 // #2 Go back to the one you didnt choose from #1
 * {AB}   ===== {CD}  15
 * {}     ===== {ABCD}
 *
 * NOTES:
 *
 * Case 1: bring fastest and and slowest guy across
 *         return with fastest guy
 *         fastest guy bring next slowest guy across
 *         return with the fastest guy
 *
 * Case 2: bring two of the fastest guys across
 *         return with fastest guy
 *         bring two of the slowest guys across
 *         return with fastest guy
 *
 */
public class CrossBridgeProblem {
    public static int fastestWayToCross(List<Integer> stuck) {
        List<Integer> clone = new ArrayList<Integer>(stuck);
        Collections.sort(clone);

        return _fastestWayToCross(clone);
    }

    private static int _fastestWayToCross(List<Integer> stuck) {
        if (stuck.size() < 3) {
            return stuck.get(stuck.size() - 1);
        }

        int a = stuck.get(0);
        int b = stuck.get(1);
        int c = stuck.get(stuck.size() - 1);

        if (stuck.size() == 3) {
            return a + b + c;
        }

        int d = stuck.get(stuck.size() - 2);
        int case1 = c + a + d + a;
        int case2 = b + a + c + b;
        int fastestCase = case1 < case2 ? case1 : case2;

        stuck.remove(stuck.size() - 1);
        stuck.remove(stuck.size() - 1);

        if (fastestCase == case1) {
            System.out.println("Cross -> A = " + a + ", B = " + c + "\n"
                    + "Cross <- A = " + a + "\n"
                    + "Cross -> A = " + a + ", B = " + d + "\n"
                    + "Cross <- A = " + a + "\n");
        }
        else {
            System.out.println("Cross -> A = " + a + ", B = " + b + "\n"
                    + "Cross <- A = " + a + "\n"
                    + "Cross -> A = " + d + ", B = " + c + "\n"
                    + "Cross <- A = " + b + "\n");
        }

        return fastestCase + _fastestWayToCross(stuck);
    }

    public static void main(String [] args) {
        List<Integer> stuck = new ArrayList<Integer>();

        stuck.add(1);
        stuck.add(2);
        stuck.add(5);
        stuck.add(10);

        System.out.println(fastestWayToCross(stuck));
    }
}
