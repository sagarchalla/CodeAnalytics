package cracking.coding.interview.trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreesAndGraphs {


    class Node {
        int value;
        Node left, right;

        Node() {
        }

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    // Problem -8
    static void findSumOfPaths(Node root, int target) {
        int counter = 0;
        List<Integer> integerList = new ArrayList<>();
        recursiceNodeMethodCalls(root, target, integerList, counter);
    }

    static void recursiceNodeMethodCalls(Node root, int target, List<Integer> integerList, int counter) {

        LinkedList list = new LinkedList();
        if (root == null)
            return;
        counter += root.value;
        integerList.add(root.value);
        if (counter == target) {
            System.out.println("Hooray : " + " Found matched value : " + " and combination ");
            // print traverse route
            for (Integer i : integerList) {
                System.out.println(" I " + i);
            }
        }
        recursiceNodeMethodCalls(root.left, target, integerList, counter);
        recursiceNodeMethodCalls(root.right, target, integerList, counter);
    }


    // Problem -7

    static boolean checkIfOneTreeIsSubTree(Node N1, Node N2) {

        if (N1 == null) {
            return false;
        }

        // start somewhere lets say root
        if (N1.value == N2.value) {
            recursiveCheckIfOneTreeIsSubTree(N1, N2);
        }
        return (checkIfOneTreeIsSubTree(N1.left, N2) || checkIfOneTreeIsSubTree(N1.right, N2));
    }

    static boolean recursiveCheckIfOneTreeIsSubTree(Node N1, Node N2) {


        // check if the left and right nodes are equal
        if (N2 == null && N1 == null) {
            System.out.println("Yay " + "Its a match!");
            return true;
        }
        if (N2 == null || N1 == null) {
            System.out.println("Boo " + "Its Not a match!");
            return false;

        }

            if (N2.value != N1.value) {
                System.out.println("Boo " + "Its Not a match!");
                return false;
            }

            return  (recursiveCheckIfOneTreeIsSubTree(N1.left, N2.left) && recursiveCheckIfOneTreeIsSubTree(N1.right, N2.right)) ;
        }
}































