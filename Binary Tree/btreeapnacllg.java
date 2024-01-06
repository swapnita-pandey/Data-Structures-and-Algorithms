import java.util.*;

public class btreeapnacllg
{
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = right;
        }
    }

    static class BinaryTree
    {
        static int idx = -1;
        public static Node buildTree(int nodes[])
        {
            idx++;
            if(nodes[idx] == -1)
            {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node node) {
        // N -> L -> R
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node temp) {
        // L -> N -> R
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.data + " ");
        inorder(temp.right);
    }

    public static void postorder(Node node) {
        // L -> R -> N
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void levelOrder(Node root)
    {
        if(root == null)
        {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty())
        {
            Node currNode = q.remove();
            if(currNode == null)
            {
                System.out.println();
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                }
            }
            else
            {
                System.out.print(currNode.data + " ");
                if(currNode.left != null)
                {
                    q.add(currNode.left);
                }
                if(currNode.right != null)
                {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countOfNodes(Node root)
    {
        if(root == null)
            return 0;

        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root)
    {
        if(root == null)
            return 0;

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int height(Node root)
    {
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    public static int diameter(Node root)
    {
        if(root == null)
            return 0;

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) + 1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }

    static class TreeInfo
    {
        int ht;
        int diam;

        TreeInfo(int ht, int diam)
        {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root)
    {
        if(root == null)
        {
            return new TreeInfo(0,0);
        }
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;
        
        int mydiam = Math.max(diam3, Math.max(diam1, diam2));

        TreeInfo myInfo = new TreeInfo(myHeight, mydiam);

        return myInfo;
    }

    public static void main(String args[])
    {
        //pre-order sequence
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println();

        System.out.println("Preorder");
        preorder(root);
        System.out.println();
        System.out.println();

        System.out.println("Inorder");
        inorder(root);
        System.out.println();
        System.out.println();

        System.out.println("Postorder");
        postorder(root);
        System.out.println();
        System.out.println();

        System.out.println("LevelOrder");
        levelOrder(root);
        System.out.println();

        System.out.println("Count of Nodes: " + countOfNodes(root));
        System.out.println();

        System.out.println("Sum of Nodes: " + sumOfNodes(root));
        System.out.println();

        System.out.println("Height: " + height(root));
        System.out.println();

        System.out.println("Diameter: " + diameter(root));
        System.out.println();

        System.out.println("Diameter: " + diameter2(root).diam);
        System.out.println();
    }
}



/*
    public boolean isIdentical(TreeNode root, TreeNode subRoot)
    {
        if(root == null && subRoot == null)
        {
            return true;
        }

        if(root == null || subRoot == null)
        {
            return false;
        }

        if(root.val == subRoot.val)
        {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot)
    {
        if(subRoot == null)
        {
            return true;
        }

        if(root == null)
        {
            return false;
        }

        if(root.val == subRoot.val)
        {
            if(isIdentical(root, subRoot))
            {
                return true;
            }
        }
        return isSubtree(root.left, subTree) || isSubtree(root.right, subRoot);
    }
*/