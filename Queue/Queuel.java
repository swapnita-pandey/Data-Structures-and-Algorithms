import java.util.*;

class Queuel {

    static Node front, rear;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static void enqueue(int key) {
        Node temp = new Node(key);

        // If queue is empty, then new node is front and rear both
        if (rear == null) {
            front = rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        rear.next = temp;
        rear = temp;
    }

    static void dequeue() {
        // If queue is empty, return NULL.
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        // Store previous front and move front one node ahead
        Node temp = front;
        front = front.next;

        // If front becomes NULL, then change rear also as NULL
        if (front == null)
            rear = null;
    }

    static void printList() {
        System.out.println("Queue: ");
        Node tnode = front;
        while (tnode != rear) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.print(tnode.data + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Stackl sl = new Stackl();

        System.out.println("Enter number of elements to be added: ");
        int n = sc.nextInt();

        System.out.println("Enter the element to be pushed: ");
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            enqueue(s);
        }

        printList();

        dequeue();
        dequeue();

        printList();

        System.out.println("Front: " + front.data);
        System.out.println("Rear: " + rear.data);

        sc.close();
    }
}