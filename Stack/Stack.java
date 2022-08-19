import java.util.*;

class Stack {
    static final int MAX = 6;
    static int top = -1;
    static int a[] = new int[MAX];

    static void push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return;
        }
    }

    static int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }

    static int peek() {
        if (top < 0) {
            System.out.println("Stack Overflow");
            return 0;
        } else {
            int x = a[top];
            return x;
        }
    }

    static void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            push(s);
        }

        System.out.println("Top element is: " + peek());

        System.out.print("Stack: ");
        print();

        System.out.println(pop() + " element popped from Stack: ");
        System.out.print("Stack: ");
        print();

        sc.close();
    }
}