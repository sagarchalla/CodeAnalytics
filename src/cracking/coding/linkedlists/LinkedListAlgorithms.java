package cracking.coding.linkedlists;

import leet.code.linkedlists.ListNode;
import leet.code.models.LinkedListNode;

import java.util.*;

public class LinkedListAlgorithms {

    public static void main(String[] args) {

        // Created a dummy linked list with dups
        LinkedListNode node = new LinkedListNode(6);
        node.next = new LinkedListNode(21);
        node.next.next = new LinkedListNode(25);
        node.next.next.next = new LinkedListNode(6);

        removeDuplicates(node);
        // kthToLastElement(node, 3);
        // removedLinkedListNode(node.next);

        /**
         * print linked list
         */
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

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

    // Q 2.3 Implement an algorithm to delete a node in the middle of a single linked list
    static void removedLinkedListNode(LinkedListNode nodeToBeRemoved) {
        if(nodeToBeRemoved == null || nodeToBeRemoved.next == null) {
            return;
        }
        LinkedListNode nextNode = nodeToBeRemoved.next;
        nodeToBeRemoved.data = nextNode.data;
        nodeToBeRemoved.next = nextNode.next;
    }

    //Q2.4 TODO

    //Q 2.5 Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
    public boolean hasCycle(ListNode head) {

        //  Instantialte two nodes

        // have them run faster than the next

        // if they meet there is a loop

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }


    public List<String> subStringsKDist(String inputStr, int num) {
        Map<Character, Integer> occurrenceMap = new HashMap<>();
        List<String> inputList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        for (int i = 0; i + num <= inputStr.length(); i++) {
            inputList.add(inputStr.substring(i, i + num));
        }

        for (int j = 0; j < inputList.size(); j++) {
            String str = inputList.get(j);

            boolean isRepeat = false;

            for (char c : str.toCharArray()) {
                if (occurrenceMap.containsKey(c)) {
                    if (!isRepeat)
                        occurrenceMap.put(c, occurrenceMap.get(c) + 1);
                    else
                        break;

                    isRepeat = true;
                } else
                    occurrenceMap.put(c, 1);
            }
            if (isRepeat)
                resultList.add(str);
            occurrenceMap.clear();
        }

        return resultList;


    }


    /**
     * 19. Remove Nth Node From End of List\
     *
     * Debug this - TODO
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // two pointer approach

        // 1st pointer traver till n

        // 2nd point ter just traverse

        // if the 1st pointer reached the end then remove the 1st pointer

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode firstNode = newHead;
        ListNode secondNode = newHead;

        for(int i = 1; i <= n; i++) {
            firstNode = firstNode.next;
        }

        while(firstNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        // secod node is the one that needs to be removed
        secondNode.next = secondNode.next.next;


        return newHead.next;
    }


    /**
     * 21. Merge Two Sorted Lists
     *
     *
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // create a dummy head

        // point the dummy head to the lowest of the 1st element

        // two more pointers to point to traverse the two lists

        // keep moving one pointer at a time based on the lowest

        if(l1 == null && l2 == null) {
            return null;
        }

        // create dummy head
        ListNode head = new ListNode(0);

        ListNode dummyHead = head;


        // create two pointers
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;


        while(pointer1 != null && pointer2 != null) {

            if(pointer1.value <= pointer2.value) {

                dummyHead.next = pointer1;
                dummyHead = dummyHead.next;
                pointer1 = pointer1.next;
            }
            else {
                dummyHead.next = pointer2;
                dummyHead = dummyHead.next;
                pointer2 = pointer2.next;
            }
        }

        // check if any of the pointer nodes are null
        if(pointer2 == null) {
            dummyHead.next = pointer1;
        }

        if(pointer1 == null) {
            dummyHead.next = pointer2;
        }

        return head.next;


    }
}