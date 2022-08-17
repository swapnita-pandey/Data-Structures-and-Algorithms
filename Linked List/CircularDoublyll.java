
// Java program to illustrate inserting a Node in
// a Circular Doubly Linked list in begging, end
// and middle
import java.util.*;

class CircularDoublyll {

    static Node start;

    // Structure of a Node
    static class Node {
        int data;
        Node next;
        Node prev;
    };

    // Function to insert at the end
    static void insertEnd(int value) {
        // If the list is empty, create a single node
        // circular and doubly list
        if (start == null) {
            Node new_node = new Node();
            new_node.data = value;
            new_node.next = new_node.prev = new_node;
            start = new_node;
            return;
        }

        // If list is not empty

        /* Find last node */
        Node last = (start).prev;

        // Create Node dynamically
        Node new_node = new Node();
        new_node.data = value;

        // Start is going to be next of new_node
        new_node.next = start;

        // Make new node previous of start
        (start).prev = new_node;

        // Make last previous of new node
        new_node.prev = last;

        // Make new node next of old last
        last.next = new_node;
    }

    // Function to insert Node at the beginning
    // of the List,
    static void insertBegin(int value) {
        // Pointer points to last Node
        Node last = (start).prev;

        Node new_node = new Node();
        new_node.data = value; // Inserting the data

        // setting up previous and next of new node
        new_node.next = start;
        new_node.prev = last;

        // Update next and previous pointers of start
        // and last.
        last.next = (start).prev = new_node;

        // Update start pointer
        start = new_node;
    }

    // Function to insert node with value as value1.
    // The new node is inserted after the node with
    // with value2
    static void insertAfter(int value1,
            int value2) {
        Node new_node = new Node();
        new_node.data = value1; // Inserting the data

        // Find node having value2 and next node of it
        Node temp = start;
        while (temp.data != value2)
            temp = temp.next;
        Node next = temp.next;

        // insert new_node between temp and next.
        temp.next = new_node;
        new_node.prev = temp;
        new_node.next = next;
        next.prev = new_node;
    }

    static void display(Node start) {
        Node temp = start;

        while (temp.next != start) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%d ", temp.data);
    }

    static Node insert(Node start, int value) {
        // If the list is empty, create a single node
        // circular and doubly list
        if (start == null) {
            Node new_node = new Node();
            new_node.data = value;
            new_node.next = new_node.prev = new_node;
            start = new_node;
            return start;
        }

        // If list is not empty

        // Find last node /
        Node last = (start).prev;

        // Create Node dynamically
        Node new_node = new Node();
        new_node.data = value;

        // Start is going to be next of new_node
        new_node.next = start;

        // Make new node previous of start
        (start).prev = new_node;

        // Make last previous of new node
        new_node.prev = last;

        // Make new node next of old last
        last.next = new_node;
        return start;
    }

    static Node deleteNode(Node start, int key) {
        // If list is empty
        if (start == null)
            return null;

        // Find the required node
        // Declare two pointers and initialize them
        Node curr = start, prev_1 = null;
        while (curr.data != key) {
            // If node is not present in the list
            if (curr.next == start) {
                System.out.printf("\nList doesn't have node with value = %d", key);
                return start;
            }

            prev_1 = curr;
            curr = curr.next;
        }

        // Check if node is the only node in list
        if (curr.next == start && prev_1 == null) {
            (start) = null;
            return start;
        }

        // If list has more than one node,
        // check if it is the first node
        if (curr == start) {
            // Move prev_1 to last node
            prev_1 = (start).prev;

            // Move start ahead
            start = (start).next;

            // Adjust the pointers of prev_1 and start node
            prev_1.next = start;
            (start).prev = prev_1;
        }

        // check if it is the last node
        else if (curr.next == start) {
            // Adjust the pointers of prev_1 and start node
            prev_1.next = start;
            (start).prev = prev_1;
        } else {
            // create new pointer, points to next of curr node
            Node temp = curr.next;

            // Adjust the pointers of prev_1 and temp node
            prev_1.next = temp;
            temp.prev = prev_1;
        }
        return start;
    }

    /* Driver code */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* Start with the empty list */
        Node start = null;

        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter the nodes: ");
        for (int i = 0, s; i < n; i++) {
            s = sc.nextInt();
            start = insert(start, s);
        }

        System.out.print("Created circular doubly linked list is: ");
        display(start);

        System.out.println("\nEnter node to delete: ");
        int s = sc.nextInt();
        start = deleteNode(start, s);

        System.out.print("Circular doubly linked list after deletion is: ");
        display(start);

        /*
         * // Insert 5. So linked list becomes 5.null
         * insertEnd(5);
         * 
         * // Insert 4 at the beginning. So linked
         * // list becomes 4.5
         * insertBegin(4);
         * 
         * // Insert 7 at the end. So linked list
         * // becomes 4.5.7
         * insertEnd(7);
         * 
         * // Insert 8 at the end. So linked list
         * // becomes 4.5.7.8
         * insertEnd(8);
         * 
         * // Insert 6, after 5. So linked list
         * // becomes 4.5.6.7.8
         * insertAfter(6, 5);
         */

    }
}

// This code is contributed by Rajput-Ji
