package cracking.coding.trees;


public class MyTreeNode {
    public int value;
    public MyTreeNode left;

    public MyTreeNode getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getRight() {
        return right;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }

    public MyTreeNode right;



    public MyTreeNode(int value) {
        this.value = value;
    }
}
