import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

class BTree {
    var root: Node? = null
    var temp = root

    private fun insert(temp: Node?, key: Int) {
        var temp = temp
        if (temp == null) {
            root = Node(key)
            return
        }
        val q: Queue<Node?> = LinkedList()
        q.add(temp)

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek()
            q.remove()
            if (temp!!.left == null) {
                temp.left = Node(key)
                break
            } else q.add(temp.left)
            if (temp.right == null) {
                temp.right = Node(key)
                break
            } else q.add(temp.right)
        }
    }

    private fun deleteDeepest(root: Node?, delNode: Node?) {
        val q: Queue<Node?> = LinkedList()
        q.add(root)
        var temp: Node? = null

        // Do level order traversal until last node
        while (!q.isEmpty()) {
            temp = q.peek()
            q.remove()
            if (temp === delNode) {
                temp = null
                return
            }
            if (temp!!.right != null) {
                if (temp.right === delNode) {
                    temp.right = null
                    return
                } else q.add(temp.right)
            }
            if (temp.left != null) {
                if (temp.left === delNode) {
                    temp.left = null
                    return
                } else q.add(temp.left)
            }
        }
    }

    // Function to delete given element
    // in binary tree
    fun delete(root: Node?, key: Int) {
        var root: Node? = root ?: return
        if (root!!.left == null && root.right == null) {
            if (root.data == key) {
                root = null
                return
            } else return
        }
        val q: Queue<Node?> = LinkedList()
        q.add(root)
        var temp: Node? = null
        var keyNode: Node? = null

        // Do level order traversal until
        // we find key and last node.
        while (!q.isEmpty()) {
            temp = q.peek()
            q.remove()
            if (temp!!.data == key) keyNode = temp
            if (temp.left != null) q.add(temp.left)
            if (temp.right != null) q.add(temp.right)
        }
        if (keyNode != null) {
            val x: Int = temp!!.data
            deleteDeepest(root, temp)
            keyNode.data = x
        }
    }

    private fun preorder(node: Node?) {
        // N -> L -> R
        if (node == null) return
        print(node.data.toString() + " ")
        preorder(node.left)
        preorder(node.right)
    }

    private fun inorder(temp: Node?) {
        // L -> N -> R
        if (temp == null) return
        inorder(temp.left)
        print(temp.data.toString() + " ")
        inorder(temp.right)
    }

    private fun postorder(node: Node?) {
        // L -> R -> N
        if (node == null) return
        postorder(node.left)
        postorder(node.right)
        print(node.data.toString() + " ")
    }

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        println("Enter the number of node: ")
        val n = sc.nextInt()
        for (i in 0 until n) {
            val k = sc.nextInt()
            insert(root, k)
        }
        println("Preorder Traversal (N -> L -> R): ")
        preorder(root)
        println()
        println("Inorder Traversal (L -> N -> R): ")
        inorder(root)
        println()
        println("Postorder Traversal (L -> R -> N): ")
        postorder(root)
        println()
        sc.close()
    }

    class Node(var data: Int) {
        var left: Node? = null
        var right: Node? = null
    }
}
