import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks <T> {
    int capacity;
    List<Stack<T>> stacks;
    Stack<T> current;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<Stack<T>>();
        current = new Stack<T>();
        stacks.add(current);
    }

    public void push(T data) {
        current.push(data);

        if (current.size() == capacity) {
            current = new Stack<T>();
            stacks.add(current);
        }
    }

    public T pop() {
        if (current.empty()) {
            if (stacks.size() == 1) {
                System.out.println("Nothing to pop");
                return null;
            }
            else {
                stacks.remove(stacks.size() - 1);
                current = stacks.get(stacks.size() - 1);
            }
        }

        return current.pop();
    }

    public T popAt(int index) {
        Stack<T> requestedStack = stacks.get(index);

        if (!requestedStack.empty()) {
            return requestedStack.pop();
        }

        return null; // Temp fix to remove compile error
    }

    public static void main(String [] args) {
        SetOfStacks<Integer> test = new SetOfStacks<Integer>(5);

        for (int i = 0; i < 5; i++) {
            test.push(i);
        }

        for (int i = 0; i < 6; i++) {
            test.pop();
        }
    }
}
