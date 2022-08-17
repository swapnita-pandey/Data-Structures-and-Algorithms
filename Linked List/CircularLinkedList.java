
// Java code to perform circular linked list operations
import java.util.*;

class CircularLinkedList {

  static class Node {
    int data;
    Node next;
  };

  static Node addToEmpty(Node last, int data) {
    if (last != null)
      return last;

    // allocate memory to the new node
    Node newNode = new Node();

    // assign data to the new node
    newNode.data = data;

    // assign last to newNode
    last = newNode;

    // create link to iteself
    newNode.next = last;

    return last;
  }

  // add node to the front
  static Node addFront(Node last, int data) {
    if (last == null)
      return addToEmpty(last, data);

    // allocate memory to the new node
    Node newNode = new Node();

    // add data to the node
    newNode.data = data;

    // store the address of the current first node in the newNode
    newNode.next = last.next;

    // make newNode as head
    last.next = newNode;

    return last;
  }

  // add node to the end
  static Node addEnd(Node last, int data) {
    if (last == null)
      return addToEmpty(last, data);

    // allocate memory to the new node
    Node newNode = new Node();

    // add data to the node
    newNode.data = data;

    // store the address of the head node to next of newNode
    newNode.next = last.next;

    // point the current last node to the newNode
    last.next = newNode;

    // make newNode as the last node
    last = newNode;

    return last;
  }

  static Node addAfter(Node last, int data, int item) {
    if (last == null)
      return null;

    Node newNode, p;
    p = last.next;
    do {
      // if the item is found, place newNode after it
      if (p.data == item) {
        // allocate memory to the new node
        newNode = new Node();

        // add data to the node
        newNode.data = data;

        // make the next of the current node as the next of newNode
        newNode.next = p.next;

        // put newNode to the next of p
        p.next = newNode;

        // if p is the last node, make newNode as the last node
        if (p == last)
          last = newNode;
        return last;
      }
      p = p.next;
    } while (p != last.next);

    System.out.println(item + "The given node is not present in the list");
    return last;

  }

  // delete a node
  static Node deleteNode(Node last, int key) {
    // if linked list is empty
    if (last == null)
      return null;

    // if the list contains only a single node
    if (last.data == key && last.next == last) {
      last = null;
      return last;
    }

    Node temp = last, d = new Node();

    // if last is to be deleted
    if (last.data == key) {
      // find the node before the last node
      while (temp.next != last) {
        temp = temp.next;
      }

      // point temp node to the next of last i.e. first node
      temp.next = last.next;
      last = temp.next;
    }

    // travel to the node to be deleted
    while (temp.next != last && temp.next.data != key) {
      temp = temp.next;
    }

    // if node to be deleted was found
    if (temp.next.data == key) {
      d = temp.next;
      temp.next = d.next;
    }
    return last;
  }

  static void traverse(Node last) {
    Node p;

    if (last == null) {
      System.out.println("List is empty.");
      return;
    }

    p = last.next;

    do {
      System.out.print(p.data + " ");
      p = p.next;

    } while (p != last.next);

  }

  static Node reverse(Node head_ref) {
    // if list is empty
    if (head_ref == null)
      return null;

    // reverse procedure same as reversing a
    // singly linked list
    Node prev = null;
    Node current = head_ref;
    Node next;
    do {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    } while (current != (head_ref));

    // adjusting the links so as to make the
    // last node point to the first node
    (head_ref).next = prev;
    head_ref = prev;
    return head_ref;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Node last = null;

    System.out.println("Enter number of nodes: ");
    int n = sc.nextInt();
    System.out.println("Enter the value of nodes: ");
    for (int i = 0; i < n; i++) {
      int s = sc.nextInt();
      last = addEnd(last, s);
    }

    // last = addToEmpty(last, 6);
    // last = addEnd(last, 8);
    // last = addFront(last, 2);

    // last = addAfter(last, 10, 2);

    System.out.println("Linked List: ");
    traverse(last);

    last = reverse(last);
    System.out.println("\nReversed Linked List: ");
    traverse(last);

    // deleteNode(last, 8);
    // traverse(last);
  }
}