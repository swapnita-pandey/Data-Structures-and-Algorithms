import java.util.*;

import javax.lang.model.util.ElementScanner6;

class intersection {

    static Node head1 = null, head2 = null;
    static Node intersect = null;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node insertAtEnd(Node head, int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new Node(new_data);
            return head;
        }

        new_node.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
        return head;
    }

    static void printList(Node head) {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    static Node sortIntersect(Node head1, Node head2) {
        Node t1 = head1;
        Node t2 = head2;
        while (t1 != null && t2 != null) {
            if (t1.data == t2.data) {
                intersect = insertAtEnd(intersect, t1.data);
                t1 = t1.next;
                t2 = t2.next;
            } else if (t1.data < t2.data) {
                t1 = t1.next;
            } else {
                t2 = t2.next;
            }
        }
        return intersect;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in the first Linked List: ");
        int n = sc.nextInt();

        System.out.println("Enter the first Linked List: ");
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            head1 = insertAtEnd(head1, s);
        }

        System.out.println("Enter number of elements in the second Linked List: ");
        n = sc.nextInt();

        System.out.println("Enter the second Linked List: ");
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            head2 = insertAtEnd(head2, s);
        }

        System.out.println("Linked List 1: ");
        printList(head1);

        System.out.println("Linked List 2: ");
        printList(head2);

        intersect = sortIntersect(head1, head2);
        System.out.println("Linked List Intersection: ");
        printList(intersect);
        sc.close();
    }
}