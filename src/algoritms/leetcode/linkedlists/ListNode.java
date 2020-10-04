package algoritms.leetcode.linkedlists;


/**
 * By definition linked list is list which has a reference to its next node
 */
public class ListNode {

    int value;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.value = val;
    }

    public ListNode(int value, ListNode node) {
        this.value = value;
        this.next = node;
    }


}
