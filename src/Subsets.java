import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Subsets <T> {
    private Set<T> sets = new LinkedHashSet<T>();

    public boolean addItem(T item) {
        return sets.add(item);
    }

    public void printSets() {
        System.out.println(sets);
    }

    public Set<Set<T>> getSubsets() {
        Set<Set<T>> subsets = new LinkedHashSet<Set<T>>();
        _getSubsets(sets, new LinkedHashSet<T>(), subsets);
        return subsets;
    }

    private void _getSubsets(Set<T> remaining, Set<T> current, Set<Set<T>> subsets) {
        Set<T> remainingClone = new LinkedHashSet<T>(remaining);
        subsets.add(current);

        for (T t : remainingClone) {
            Set<T> newSet = new LinkedHashSet<T>(current);
            Set<T> remainingCloneClone = new LinkedHashSet<T>(remaining);

            newSet.add(t);
            remainingCloneClone.remove(t);
            _getSubsets(remainingCloneClone, newSet, subsets);
        }
    }

    public static void main(String [] args) {
        Subsets subsets = new Subsets<Integer>();

        for (int i = 0; i < 9; i++) {
            subsets.addItem(i);
        }

        subsets.printSets();
        System.out.println(subsets.getSubsets());
    }
}
