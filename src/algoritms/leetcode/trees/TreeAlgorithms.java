package algoritms.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeAlgorithms {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
       // System.out.println(maxDepth(treeNode));

        String[][] grid = new String[][]{
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0" },
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"} };

        System.out.println(numOfIslands(grid));


    }

    /**
     * 104. Maximum Depth of Binary Tree
     * TODO :: Explore other ways to solve this using stacks and queues
     *
     * LeetCode :: Completed
     */
    public static int maxDepth(TreeNode root) {
         // base case
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }

    /**
     * 226. Invert Binary Tree
     * TODO :: Explore other ways to solve this using stacks and queues
     *
     * LeetCode Completed
     *
     */
    public static TreeNode invertTree(TreeNode root) {
        // base case
        if(root == null) {
            return root;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static int i = 0;

    /**
     * 200. Number of Islands
     *
     * TODO :: Leetcode
     */
    // Depth first Search
    static int numOfIslands(String[][] grid) {

        // traverse though the whole grid
        // if i come across land - 1 add to count
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col].equals("1")) {
                    count += dfs(grid, row, col);
                } } }
        return count; }

    // recursive method
    static int dfs(String[][] grid, int row, int col) {
        // base case
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col].equals("0")) {
            return 0;
        }
        // visited already make it zero
        grid[row][col] = "0";
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
        return 1; }


    public List<List<Integer>> levelOrder(TreeNode root) {

        // populate the result list
        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {

            List<Integer> currentLevel = new ArrayList<>();

            int size = nodes.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = nodes.remove();

                currentLevel.add(node.value);

                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            resultList.add(currentLevel);
        }

        return resultList;


    }


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.value == q.value)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
}




    // TODO - debug this and understand recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Value of current node or parent node.
        int parentVal = root.value;

        // Value of p
        int pVal = p.value;

        // Value of q;
        int qVal = q.value;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }

}
