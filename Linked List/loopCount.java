import java.util.*;

class loopCount {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public int count(Node n) {
        int c = 1;
        Node tnode = n;
        while (tnode.next != n) {
            c++;
            tnode = tnode.next;
        }
        return c;
    }

    // Floyd's Cycle Finding Algorithm O(n) O(1)
    public int findLoop(Node head) {
        int c = 0;
        Node t = head;
        Node t1 = head;
        while (t != null && t1 != null && t1.next != null) {
            t = t.next;
            t1 = t1.next.next;
            if (t == t1 && c != 1) {
                c = count(t);
                break;
                // return true;
            }
        }
        return c;

    }

    public void insertAtEnd(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new Node(new_data);
            return;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        return;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        loopCount llist = new loopCount();
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            llist.insertAtEnd(s);
        }

        System.out.println("Linked List: ");
        llist.printList();
        System.out.println();

        llist.head.next.next.next.next = llist.head;

        System.out.println(llist.findLoop(llist.head));

    }
}