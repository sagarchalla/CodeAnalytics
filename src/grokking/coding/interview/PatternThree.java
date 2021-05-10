package grokking.coding.interview;


import algoritms.leetcode.linkedlists.ListNode;

// Fast and Slow Pointer - Linked List
public class PatternThree {

    static class ListNode{
        int value = 0;
        ListNode next;
        ListNode(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle length: " + findCycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle length: " + findCycleLength(head));
    }

    // Problem - Given the head of a LinkedList with a cycle, find the length of the cycle.
    static int findCycleLength(ListNode listNode){
                  // see if there is a cycle
                  ListNode fast = listNode;
                  ListNode slow = listNode;
                  while(fast.next != null && fast.next.next != null){
                      fast = fast.next.next;
                      slow = slow.next;
                      if(slow == fast){
                          // points meet // calculate length
                          return calculateLength(slow);
                      }
                  }
     return 0;
    }
    static int calculateLength(ListNode node){
        int counter = 1;
        int value = node.value;
        ListNode head = node.next;
        while(value != head.value){
            head = head.next;
            counter++;
        }
        return counter;
    }

}
