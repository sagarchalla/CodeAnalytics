package algoritms.leetcode.linkedlists;


import org.w3c.dom.Node;

/**
 * By definition linked list is list which has a reference to its next node
 */
public class ListNode {

    public int value;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.value = val;
        next = null;
    }

    // Instantiate a new node to have the next node
     public ListNode(int value, ListNode node) {
        this.value = value;
        this.next = node;
    }

    //  Append to Tail
    public void appendToTail(int d) {

        // Instantiate a new node to append

        // Traverse to the last node

        // Point the next node to the new one created
         ListNode endNode = new ListNode(d);

         ListNode n = this;

         // N will be the last node if null
         while(n.next != null) {
             n = n.next;
         }
         n.next = endNode;
    }




}
