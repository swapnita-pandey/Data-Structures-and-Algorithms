import java.util.*;

class BTree {
    static Node root;
    static Node temp = root;

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    static void insert(Node temp, int key) {

        if (temp == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    static void deleteDeepest(Node root, Node delNode) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        Node temp = null;

        // Do level order traversal until last node
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp == delNode) {
                temp = null;
                return;

            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else
                    q.add(temp.right);
            }

            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else
                    q.add(temp.left);
            }
        }
    }

    // Function to delete given element
    // in binary tree
    static void delete(Node root, int key) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
                return;
            } else
                return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null, keyNode = null;

        // Do level order traversal until
        // we find key and last node.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.key == key)
                keyNode = temp;

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        if (keyNode != null) {
            int x = temp.key;
            deleteDeepest(root, temp);
            keyNode.key = x;
        }
    }

    static void preorder(Node node) {
        // N -> L -> R
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node temp) {
        // L -> N -> R
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);
    }

    static void postorder(Node node) {
        // L -> R -> N
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of node: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            insert(root, k);
        }

        System.out.println("Preorder Traversal (N -> L -> R): ");
        preorder(root);
        System.out.println();

        System.out.println("Inorder Traversal (L -> N -> R): ");
        inorder(root);
        System.out.println();

        System.out.println("Postorder Traversal (L -> R -> N): ");
        postorder(root);
        System.out.println();

        sc.close();
    }
}