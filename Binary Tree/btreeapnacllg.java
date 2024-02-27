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

    // All three are DFS
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
        // O(n)
        // BFS
        // As soon as you take out null, add another null to the queue
        // so that you know that you have to add a new line now
        // Here we utilize the FIFO property of the queue
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = queue.size();

            // Process nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // Add the current level's values to the result
            result.add(currentLevel);
        }
        return result;
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
        // O(n)
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    public static int diameter(Node root)
    {
        // Case 1: Diameter through root
        // Case 2: Diameter does not go through root
        // O(N^2)
        if(root == null)
            return 0;

        // Diameter does not go through root
        // Case 1: Longest Diameter through left subtree
        int diam1 = diameter(root.left);

        // Diameter does not go through root
        // Case 2: Longest Diameter through right subtree
        int diam2 = diameter(root.right);

        // Diameter through root
        // Case 3: Height of left subtree + Height of right subtree + 1
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
        // Either both trees were initially empty, or we have reached the leaf nodes
        if(root == null && subRoot == null)
        {
            return true;
        }

        // Reached the leaf of one of them, 
        // but the other tree is still not completely matched
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
        // Because null is in every tree, so this empty 
        // subtree can be found in every Tree
        if(subRoot == null)
        {
            return true;
        }

        // If parent tree is null, no match can be found
        if(root == null)
        {
            return false;
        }

        // At any position where the value of the root 
        // matches the value of the subroot we will 
        // match the left and right subtrees

        // Created a separate function for matching the trees
        if(root.val == subRoot.val)
        {
            if(isIdentical(root, subRoot))
            {
                return true;
            }
        }
        // otherwise matching the left and right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
*/
