import java.util.LinkedList;

public class LinkedListNode {
    protected int data;
    protected LinkedListNode next;

    public static void print(LinkedListNode head) {
        System.out.println();

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public LinkedListNode reverseIterative() {
        LinkedListNode before = null;
        LinkedListNode after = this;

        while (after != null) {
            LinkedListNode temp = after.next;
            after.next = before;
            before = after;
            after = temp;
        }

        return before;
    }

    public LinkedListNode reverseRecursive() {
        return _reverseRecursive(null, this);
    }

    private LinkedListNode _reverseRecursive(LinkedListNode prev, LinkedListNode node) {
        if (node == null) {
            return prev;
        }

        LinkedListNode head = _reverseRecursive(node, node.next);
        node.next = prev;

        return head;
    }

    public static void main(String [] args) {
        LinkedListNode head = new LinkedListNode();
        LinkedListNode temp = head;
        head.data = 0;

        for (int i = 1; i < 10; i++) {
            temp.next = new LinkedListNode();
            temp = temp.next;
            temp.data = i;
        }

        LinkedListNode.print(head);
        LinkedListNode.print(head.reverseRecursive());
    }
}
