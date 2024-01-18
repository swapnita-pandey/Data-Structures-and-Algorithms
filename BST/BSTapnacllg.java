import java.util.*;

// BST makes search efficient
public class BSTapnacllg
{
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val)
    {
        // O(H) as the same pattern is followed to check the position 
        // of node insertion as is used for searching a node in a BST
        // Left and right subtrees are also BST with no duplicates
        if(root == null)
        {
            root = new Node(val);
            return root;
        }

        // Left subtree nodes < root
        if(root.data > val)
        {
            // left subtree
            root.left = insert(root.left, val);
        }
        // right subtree nodes > root
        else
        {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root)
    {
        // Inorder traversal will give a sorted sequence
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node delete(Node root, int val)
    {
        if(root.data > val)
        {
            root.left = delete(root.left, val);
        }
        else if(root.data < val)
        {
            root.right = delete(root.right, val);
        }
        else
        {
            // root.data == val
            // case 1
            if(root.left == null && root.right == null)
            {
                return null;
            }

            // case 2
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }

            // case 3
            // Inorder Successor is leftmost in Right Subtree
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static void printInRange(Node root, int X, int Y)
    {
        if(root == null)
        {
            return;
        }

        if(root.data >= X && root.data <= Y)
        {
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        }
        else if(root.data >= Y)
        {
            printInRange(root.left, X, Y);
        }
        else
        {
            printInRange(root.right, X, Y);
        }
    }

    public static Node inorderSuccessor(Node root)
    {
        while(root.left != null)
        {
            root = root.left;
        }
        return root;
    }

    public static boolean search(Node root, int key)
    {
        // O(H) ~ O(log N) in most cases
        // In worst case, i.e., in case if we find a skewed tree
        // Time complexity is worst i.e., O(N)
        if(root == null)
        {
            return false;
        }

        // If key value is greater than root value than 
        // it will be found in the left subtree
        if(root.data > key)
        {
            // Left Subtree
            return search(root.left, key);
        }
        else if(root.data == key)
        {
            return true;
        }

        // If key value is smaller than root value than 
        // it will be found in the right subtree
        else
        {
            return search(root.right, key);
        }
    }

    public static void printPath(ArrayList<Integer> path)
    {
        for(int i = 0; i < path.size(); i++)
        {
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path)
    {
        if(root == null)
        {
            return;
        }

        path.add(root.data);

        // Leaf
        if(root.left == null && root.right == null)
        {
            printPath(path);
        }
        else
        {
            // Non-Leaf
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String args[])
    {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i < values.length; i++)
        {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
        System.out.println();

        // search(root, key)
        if(search(root, 6))
        {
            System.out.println("Found");
        }
        else
        {
            System.out.println("Not found");
        }
        System.out.println();

        // delete(root, val);
        delete(root, 4);
        inorder(root);
        System.out.println();
        System.out.println();

        // printInRange(root, X, Y);
        printInRange(root, 6, 10);
        System.out.println();
        System.out.println();

        printInRange(root, 3, 12);
        System.out.println();
        System.out.println();

        printRoot2Leaf(root, new ArrayList<>());
    }
}