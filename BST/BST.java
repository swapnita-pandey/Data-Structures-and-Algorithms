import java.util.*;
import java.util.Queue;
import java.util.LinkedList;

class BST {
    static Node root;

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
            left = null;
            right = null;
        }
    }

    // Function to create a new BST node
    static Node newNode(int item)
    {
        Node temp = new Node(item);
        temp.val = item;
        temp.left = temp.right = null;
        return temp;
    }

    static Node insert(Node node, int key) {
        // If the tree is empty, return a new node
        if (node == null)
            return newNode(key);
  
        // Otherwise, recur down the tree
        if (key < node.val) {
            node.left = insert(node.left, key);
        }
        else if (key > node.val) {
            node.right = insert(node.right, key);
        }
  
        // Return the node
        return node;
    }

    // using loops
    public void insert(int key)
    {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node prev = null;
        Node temp = root;
        while (temp != null) {
            if (temp.val > key) {
                prev = temp;
                temp = temp.left;
            }
            else if (temp.val < key) {
                prev = temp;
                temp = temp.right;
            }
        }
        if (prev.val > key)
            prev.left = node;
        else
            prev.right = node;
    }
   
    static void deleteDeepest(Node delNode) {
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

    // Function to delete given element in binary tree
    static void delete(int key) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            if (root.val == key) {
                root = null;
                return;
            } else
                return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null, keyNode = null;

        // Do level order traversal until we find key and last node.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.val == key)
                keyNode = temp;

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        if (keyNode != null) {
            int x = temp.val;
            deleteDeepest(temp);
            keyNode.val = x;
        }
    }

    static void preorder(Node node) {
        // N -> L -> R
        if (node == null)
            return;

        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        // L -> N -> R
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    static void postorder(Node node) {
        // L -> R -> N
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val + " ");
    }

    static public Node search(Node root, int key)
    {
        // Base Cases: root is null or key is present at root
        if (root == null || root.val == key)
            return root;
    
        // Key is greater than root's key
        if (root.val < key)
            return search(root.right, key);
    
        // Key is smaller than root's key
        return search(root.left, key);
    }

    // Returns height of the BST
    static int height(Node node)
    {
        if (node == null)
            return 0;
        else {
  
            // Compute the depth of each subtree
            int lDepth = height(node.left);
            int rDepth = height(node.right);
  
            // Use the larger one
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    // Print nodes at a given level
    static void printGivenLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(" " + root.val);
        else if (level > 1) {
  
            // Recursive Call
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }
    
    // Function to line by line print
    // level order traversal a tree
    static void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    //Right view of a Binary Search Tree is set of nodes visible 
    //when tree is visited from Right side.
    // Function to print the right view of a binary tree.
    static void rightViewUtil(Node root, int level, int max_level)
    {
        // Base Case
        if (root == null)
            return;
  
        // If this is the last Node of its level
        if (max_level < level) {
            System.out.print(" " + root.val);
            max_level = level;
        }
  
        // Recur for right subtree
  
        rightViewUtil(root.right, level + 1, max_level);
    }

    // Wrapper over rightViewUtil()
    static void rightView(Node root)
    {
        int max_level = 0;
        rightViewUtil(root, 1, max_level);
    }

    static void leftViewUtil(Node root, int level, int max_level)
    {
        // Base Case
        if (root == null)
            return;
  
        // If this is the first node
        // of its level
        if (max_level < level) {
            System.out.print(" " + root.val);
            max_level = level;
        }
  
        // Recur for left
        leftViewUtil(root.left, level + 1, max_level);
        //leftViewUtil(root.right, level + 1, max_level);
    }
  
    // Wrapper over leftViewUtil()
    static void leftView(Node root)
    {
        int max_level = 0;
        leftViewUtil(root, 1, max_level);
    }

    // Function to delete the BST
    static Node emptyBST(Node root)
    {
        Node temp;
        if (root != null) {
    
            // Traverse to left subtree
            emptyBST(root.left);
    
            // Traverse to right subtree
            emptyBST(root.right);
    
            System.out.print("\nReleased node:"+ root.val);
            temp = root;
    
            // Require for free memory
            temp = null;
        }
        return root;
    }

    // Function to print leaf nodes from left to right
    static void printLeafNodes(Node root)
    {
        // If node is null, return
        if (root == null)
            return;
  
        // If node is leaf node, print its data
        if (root.left == null && root.right == null) {
            System.out.print(" " + root.val);
            return;
        }
  
        // If left child exists, check for leaf recursively
        if (root.left != null)
            printLeafNodes(root.left);
  
        // If right child exists, check for leaf recursively
        if (root.right != null)
            printLeafNodes(root.right);
    }

    // Function to print all non-leaf nodes in a tree
    static void printNonLeafNode(Node root)
    {
        // Base Cases
        if (root == null || (root.left == null && root.right == null))
            return;
  
        // If current node is non-leaf,
        if (root.left != null || root.right != null) {
            System.out.print(" " + root.val);
        }
  
        // If root is Not NULL and its one of its child is also not NULL
        printNonLeafNode(root.left);
        printNonLeafNode(root.right);
    }

    // Function to get the total count of nodes in a binary tree
    static int nodeCount(Node node)
    {
        if (node == null)
            return 0;
        else
            return nodeCount(node.left) + nodeCount(node.right) + 1;
    }

    // Function that returns the node with minimum key value found in that tree
    static Node minValueNode(Node node)
    {
        Node current = node;
  
        // Loop down to find the leftmost leaf
        while (current != null && current.left != null)
            current = current.left;
  
        return current;
    }

    // Function that deletes the key and returns the new root
    static Node deleteNode(Node root, int key)
    {
        // base Case
        if (root == null)
            return root;  
        // If the key to be deleted is smaller than the root's key, then it lies in left subtree
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
  
        // If the key to be deleted is
        // greater than the root's key,
        // then it lies in right subtree
        else if (key > root.val) {
  
            root.right = deleteNode(root.right, key);
        }
  
        // If key is same as root's key,
        // then this is the node
        // to be deleted
        else {
  
            // Node with only one child
            // or no child
            if (root.left == null) {
                Node temp = root.right;
                return temp;
            }
            else if (root.right == null) {
                Node temp = root.left;
                return temp;
            }
  
            // Node with two children:
            // Get the inorder successor(smallest
            // in the right subtree)
            Node temp = minValueNode(root.right);
  
            // Copy the inorder successor's
            // content to this node
            root.val = temp.val;
  
            // Delete the inorder successor
            root.right = deleteNode(root.right, temp.val);
        }
        return root;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of node: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            root = insert(root, k);
        }

        System.out.println("Enter the value of the node to search: ");
        int k = sc.nextInt();
        Node node = search(root, k);
        System.out.print(height(node) + " ");

        System.out.println("\nEnter the node to be deleted: ");
        k = sc.nextInt();
        delete(k);
        
        System.out.println("Inorder Traversal (L -> N -> R): ");
        inorder(root);
        System.out.println();

        System.out.println("Preorder Traversal (N -> L -> R): ");
        preorder(root);
        System.out.println();

        System.out.println("Postorder Traversal (L -> R -> N): ");
        postorder(root);
        System.out.println();

        System.out.println("Enter the level to print nodes at that level: ");
        int level = sc.nextInt();
        printGivenLevel(root, level);
        System.out.println();

        System.out.println("Levelorder Traversal: ");
        printLevelOrder();
        System.out.println();

        System.out.println("Right View of BST: ");
        rightView(root);
        System.out.println();

        System.out.println("Left View of BST: ");
        leftView(root);
        System.out.println();


        emptyBST(root);

        sc.close();
    }
}