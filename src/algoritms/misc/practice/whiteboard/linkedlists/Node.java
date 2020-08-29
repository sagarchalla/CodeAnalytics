package algoritms.misc.practice.whiteboard.linkedlists;


/*  Print elements of a linked list on console
  head pointer input could be NULL as well for empty list
  Node is defined as
*/
class Node {
    int data;
    Node next;


// This is a "method-only" submission.
// You only need to complete this method.

    void Print(Node head) {
        if (head == null) {
            System.out.println("Null");
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = head.next;
        }
    }

}