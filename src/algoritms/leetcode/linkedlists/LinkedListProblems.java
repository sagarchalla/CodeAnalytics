package algoritms.leetcode.linkedlists;

public class LinkedListProblems {


    public static void main(String[] args) {

    }


    /** 206. Reverse Linked List
     *
     * Approach - Last node of a linked list pointed to null
     *          - get the link from the previous linked list node and point it to the next
     *
     * TODO :: solve this in leetcode
     */
    static ListNode reverseALinkedList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;

        while(current != null) {
            ListNode temporary = current.next;
            current.next = previous;
            previous = current;
            current = temporary;

        }
        return previous;
    }




}
