import java.util.*;

class count {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // using iteration
    /*
     * public int getCount()
     * {
     * Node temp = head;
     * int count = 0;
     * while(temp != null)
     * {
     * count++;
     * temp = temp.next;
     * }
     * return count;
     * }
     */

    // using recursion but this method will take O(n) auxiliary space
    /*
     * public int getCountRec(Node node)
     * {
     * //Base case
     * if (node == null)
     * return 0;
     * 
     * //Count is this node plus rest of the list
     * return 1 + getCountRec(node.next);
     * }
     * 
     * //Wrapper over getCountRec()
     * public int getCount()
     * {
     * return getCountRec(head);
     * }
     */

    // using tail recursion
    public int getCountRec(Node node, int count) {
        // Base case
        if (node == null)
            return count;

        // Move to the next node and increase count
        return getCountRec(node.next, 1 + count);
    }

    // Wrapper over getCountRec()
    public int getCount() {
        return getCountRec(head, 0);
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
        count llist = new count();
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            llist.insertAtEnd(s);
        }

        System.out.println("Linked List: ");
        llist.printList();

        System.out.println("\nNumber of nodes: " + llist.getCount());
    }
}