import java.util.Scanner

class CircularLinkedList {
    private fun addToEmpty(last: Node?, data: Int): Node? {
        var last = last
        if (last != null) return last

        // allocate memory to the new node
        val newNode = Node()

        // assign data to the new node
        newNode.data = data

        // assign last to newNode
        last = newNode

        // create link to iteself
        newNode.next = last
        return last
    }

    // add node to the front
    private fun addFront(last: Node?, data: Int): Node? {
        if (last == null) return addToEmpty(last, data)

        // allocate memory to the new node
        val newNode = Node()

        // add data to the node
        newNode.data = data

        // store the address of the current first node in the newNode
        newNode.next = last.next

        // make newNode as head
        last.next = newNode
        return last
    }

    // add node to the end
    private fun addEnd(last: Node?, data: Int): Node? {
        var last = last
        if (last == null) return addToEmpty(last, data)

        // allocate memory to the new node
        val newNode = Node()

        // add data to the node
        newNode.data = data

        // store the address of the head node to next of newNode
        newNode.next = last.next

        // point the current last node to the newNode
        last.next = newNode

        // make newNode as the last node
        last = newNode
        return last
    }

    private fun addAfter(last: Node?, data: Int, item: Int): Node? {
        var last = last ?: return null
        val newNode: Node
        var p: Node?
        p = last.next
        do {
            // if the item is found, place newNode after it
            if (p!!.data == item) {
                // allocate memory to the new node
                newNode = Node()

                // add data to the node
                newNode.data = data

                // make the next of the current node as the next of newNode
                newNode.next = p.next

                // put newNode to the next of p
                p.next = newNode

                // if p is the last node, make newNode as the last node
                if (p == last) last = newNode
                return last
            }
            p = p.next
        } while (p != last.next)
        println(item.toString() + "The given node is not present in the list")
        return last
    }

    // delete a node
    private fun deleteNode(last: Node?, key: Int): Node? {
        // if linked list is empty
        var last: Node? = last ?: return null

        // if the list contains only a single node
        if (last!!.data == key && last.next == last) {
            last = null
            return last
        }
        var temp = last
        var d: Node? = Node()

        // if last is to be deleted
        if (last.data == key) {
            // find the node before the last node
            while (temp!!.next != last) {
                temp = temp.next
            }

            // point temp node to the next of last i.e. first node
            temp!!.next = last.next
            last = temp.next
        }

        // travel to the node to be deleted
        while (temp!!.next != last && temp.next!!.data != key) {
            temp = temp.next
        }

        // if node to be deleted was found
        if (temp.next!!.data == key) {
            d = temp.next
            temp.next = d!!.next
        }
        return last
    }

    private fun traverse(last: Node?) {
        var p: Node?
        if (last == null) {
            println("List is empty.")
            return
        }
        p = last.next
        do {
            print(p!!.data.toString() + " ")
            p = p.next
        } while (p != last.next)
    }

    private fun reverse(head_ref: Node?): Node? {
        // if list is empty
        var head_ref: Node? = head_ref ?: return null

        // reverse procedure same as reversing a
        // singly linked list
        var prev: Node? = null
        var current = head_ref
        var next: Node?
        do {
            next = current!!.next
            current.next = prev
            prev = current
            current = next
        } while (current != head_ref)

        // adjusting the links so as to make the
        // last node point to the first node
        head_ref!!.next = prev
        head_ref = prev
        return head_ref
    }

    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        var last: Node? = null
        println("Enter number of nodes: ")
        val n = sc.nextInt()
        println("Enter the value of nodes: ")
        for (i in 0 until n) {
            val s = sc.nextInt()
            last = addEnd(last, s)
        }

        // last = addToEmpty(last, 6);
        // last = addEnd(last, 8);
        // last = addFront(last, 2);

        // last = addAfter(last, 10, 2);
        println("Linked List: ")
        traverse(last)
        last = reverse(last)
        println("\nReversed Linked List: ")
        traverse(last)

        // deleteNode(last, 8);
        // traverse(last);
    }

    class Node {
        var data = 0
        var next: Node? = null
    }
}
