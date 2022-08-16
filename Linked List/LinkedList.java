class LinkedList {
    Node head; // head of list

    /*
     * Linked list Node. This inner class is made static so that
     * main() can access it
     */
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        } // Constructor
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    /* method to create a simple linked list with 3 nodes */
    public static void main(String[] args) {
        /* Start with the empty list. */
        LinkedList llist = new LinkedList();

        llist.head = new Node(1);
        Node second = new Node(2);
        llist.head.next = second; // Link first node with the second node

        Node third = new Node(3);
        second.next = third; // Link second node with the third node

        third.next = null;

        llist.printList();

    }
}
