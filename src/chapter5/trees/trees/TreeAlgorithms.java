package chapter5.trees.trees;

public class TreeAlgorithms {

    class Tree {
        Tree leftNode = null;
        Tree rightNode = null;
        int value;

        Tree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }
    static int getTreeheight(Tree tree) {
        int treeHeight = 0;

        if(tree == null) {
            return treeHeight;
        }

        int leftTreeHeight = 0;
        while(tree.leftNode != null) {
            leftTreeHeight = treeHeight + 1;
            tree = tree.leftNode.leftNode;
        }

        int rightTreeHeight = 0;
        while(tree.rightNode != null) {
            rightTreeHeight = treeHeight + 1;
            tree = tree.rightNode.rightNode;
        }

        return Math.max(leftTreeHeight , rightTreeHeight);
    }

}
