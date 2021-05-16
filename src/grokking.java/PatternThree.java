package grokking.java;

// Fast and Slow Pointers
public class PatternThree {

     static class ListNode {
         int value  = 0;
         ListNode next;

         public ListNode(int value) {
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
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));
     }

     // Problem - does the linked list have a cycle
     static boolean hasCycle(ListNode head){
         ListNode slow = head;
         ListNode fast = head;

         // logic
         while(fast.next != null && fast.next.next != null){
             slow = slow.next;
             fast = fast.next.next;
             if(slow == fast)
                 return true;
         }
         return false;
     }




}
