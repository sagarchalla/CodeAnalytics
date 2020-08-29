package chapter2.linkedlists;

import models.LinkedListNode;
import java.util.HashSet;

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