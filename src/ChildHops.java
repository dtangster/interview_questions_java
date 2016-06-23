import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ChildHops {

    public int waysToHopUpStairs(int steps) {
        return hops(steps, 0);
    }

    public int hops(int steps, int count) {
        if (count == steps) {
            return 1;
        }
        if (count > steps) {
            return 0;
        }

        int possibilies = 0;

        for (int i = 1; i <= 3; i++) {
            possibilies += hops(steps, count + i);
        }

        return possibilies;
    }

    public List<List<Integer>> sequencesToHopUpStairs(int steps) {
        List<List<Integer>> waysToHop = new ArrayList<List<Integer>>();

        getPossibleWays(steps, 0, new ArrayList<Integer>(), waysToHop);
        return waysToHop;
    }

    public void getPossibleWays(int steps, int count, List<Integer> sequence, List<List<Integer>> waysToHop) {
        if (steps == count) {
            waysToHop.add(sequence);
        }
        if (count > steps) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            List<Integer> newSequence = new ArrayList<Integer>(sequence);

            newSequence.add(i);
            getPossibleWays(steps, count + i, newSequence, waysToHop);
        }
    }

    public static void main(String [] args) {
        ChildHops childHops = new ChildHops();

        System.out.println(childHops.waysToHopUpStairs(6));
        System.out.println(childHops.sequencesToHopUpStairs(6));
        System.out.println(childHops.sequencesToHopUpStairs(6).size());
    }
}