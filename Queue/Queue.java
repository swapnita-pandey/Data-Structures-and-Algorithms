import java.util.*;

class Queue {

    static int front, rear, capacity;
    static int queue[];

    static void Enqueue(int data) {
        if (capacity == rear) {
            System.out.println("Queue is full");
            return;
        }

        else {
            queue[rear] = data;
            rear++;
        }
        return;
    }

    static void Dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }

        // shift all the elements from index 2 till rear
        // to the right by one
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }

            // store 0 at rear indicating there's no element
            if (rear < capacity)
                queue[rear] = 0;

            // decrement rear
            rear--;
        }
        return;
    }

    static void display() {
        int i;
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Queue: ");

        for (i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
        return;
    }

    static void Front() {
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Front Element is: " + queue[front]);
        return;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        front = rear = 0;
        capacity = 6;
        queue = new int[capacity];

        System.out.println("Enter number of elements to be added: ");
        int n = sc.nextInt();

        System.out.println("Enter the element to Enqueue: ");
        // adding element to rear of queue
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            Enqueue(s);
        }

        display();

        Dequeue();
        Dequeue();

        display();

        Front();

        display();

        sc.close();
    }
}