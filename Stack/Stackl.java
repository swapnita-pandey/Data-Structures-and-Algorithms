import java.util.*;

class Stackl {

    static Node root;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static boolean isEmpty() {
        if (root == null)
            return true;
        return false;
    }

    static void push(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            root = newNode;
            newNode.next = temp;
        }
        System.out.println(data + " pushed to stack");
    }

    static int pop() {
        int popped = Integer.MIN_VALUE;
        if (root == null) {
            System.out.println("Stack is Empty");
        } else {
            popped = root.data;
            root = root.next;
        }
        return popped;
    }

    static int peek() {
        if (root == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        } else {
            return root.data;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Stackl sl = new Stackl();

        System.out.println("Enter number of elements to be added: ");
        int n = sc.nextInt();

        System.out.println("Enter the element to be pushed: ");
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            push(s);
        }

        System.out.println(pop() + " popped from stack.");

        System.out.println("Top element is: " + peek());

        sc.close();
    }
}