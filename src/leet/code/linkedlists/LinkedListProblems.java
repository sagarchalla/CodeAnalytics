package leet.code.linkedlists;

import leet.code.models.LinkedListNode;

import java.util.HashSet;

public class LinkedListProblems {


    public static void main(String[] args) {

    }


    /**
     * 234. Palindrome Linked List
     * Similar to 125
     *
     * Leetcode : TODO
     */


    /** 206. Reverse Linked List
     *
     * Approach - Last node of a linked list pointed to null
     *          - get the link from the previous linked list node and point it to the next
     *
     * TODO :: Debug this to understand better
     */
     public static ListNode reverseList(ListNode head) {

         ListNode current = head;
         ListNode previous = null;
         ListNode next;

         while(current != null) {
             next = current.next;
             current.next = previous;
             previous = current;
             current = next;
         }
          return previous;
        }


    /**
     *
     *
     *
      */
    // Q 2.1 Remove Dups form a linked list method 1
    static void removeDuplicates(LinkedListNode node) {
        HashSet<Integer> intSet = new HashSet<>();
        // Intantiate a node
        LinkedListNode linkedListNode = null;
        LinkedListNode current = node;

        while (current != null) {
            if (intSet.contains(current.data)) {
                linkedListNode.next = current.next;
            } else {
                intSet.add(current.data);
                linkedListNode = current;
            }
            current = current.next;
        }
    }

    // Q 2.1 Remove Dups form a linked list method 2
    // Sort them and compare with the next one

    // Q 2.1 Remove Dups form a linked list method 3
    // Two Pointers


    // Q 2.2 Implement an algorithm to find the nth to last element of a singly linked list.
    static void kthToLastElement(LinkedListNode node, int n) {

        // edge case
        if (node == null || n < 1)
            return;

        // two pointers
        LinkedListNode current = node;
        LinkedListNode follower = node;

        for (int i = 0; i < n; i++) {
            current = current.next;
        }

        while (current.next != null) {
            current = current.next;
            follower = follower.next;
        }
        System.out.println(follower.data);
    }


    //Q 2.5 Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
    static void beginningOfLinkedListLoop(LinkedListNode node) {

        if(node == null) {
            return;
        }

        // Identify if there is a loop
        LinkedListNode node1 = node;
        LinkedListNode node2 = node;

        while(node2 != null) {
            node1 = node1.next;
            node2 = node2.next.next;

            if(node1 == node2) {
                System.out.println("Loop Exists");
                break;
            }
        }

        if(node2.next == null) {
            System.out.println("No Meeting Point");
            return;
        }
        node1 = node;
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        System.out.println(node2.data);
    }


}