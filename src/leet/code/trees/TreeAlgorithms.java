package leet.code.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeAlgorithms {

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.left.left = new Tree(4);
        root.right = new Tree(3);
        root.left.right = new Tree(5);
        // System.out.println(serialize(root));
        // levelOrderTraversal(root);
        // postorder(root);
        // System.out.println(maxDepth(treeNode));
        // inorder(root);

           /*   String[][] grid = new String[][]{
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0" },
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"} };
        System.out.println(numOfIslands(grid));*/ }

    // In Order Traversal Of A Tree // left , root , right // DFS
    static void inorder(Tree root) {
        // base case
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
   // Pre Order Traversal of A Tree // root / left right // DFS
    static void preorder(Tree node) {
        // base case
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
    }
    // Post Order Traversal // left right root // DFS
    static void postorder(Tree node) {
        // base case
        if(node == null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.val);
    }
    // Level Order Traversal Of A Tree // BFS
    static void levelOrderTraversal(Tree root) {
        // edge case
        if(root == null) {
            return;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree tempNode = queue.poll();
            if(tempNode != null) {
                System.out.println(tempNode.val);
            }
            if(tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if(tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    /**
     * 515. Find Largest Value in Each Tree Row
     * BFS // DFS solutions below
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            // test case failed - TODO figure out why size needed to be in a variable here
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                maxValue = Math.max(maxValue, node.value);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            result.add(maxValue);
        }
       return result;
    }
    public List<Integer> largestValuesDFS(TreeNode root) {
        // recursion // backtracking
        List<Integer> result = new ArrayList<>();
        backtrack(result, 0,  root);
        return result;
    }
    static void backtrack(List<Integer> result, int level,  TreeNode root){
        // base case
        if(root == null){
            return;
        }
        if(result.size() == level){
            result.add(root.value);
        }
        else {
            int value = result.get(level);
            value = Math.max(value, root.value);
            result.set(level, value);
        }
        backtrack(result, level + 1, root.left);
        backtrack(result, level + 1, root.right);
    }
    /**
     * 104. Maximum Depth of Binary Tree
     * DFS solution using recursion
     * BFS solution can be done using queues
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
     * DFS solution below using recursion
     * BFS solution can be done using a queue
     *
     * LeetCode Completed
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
    /** Insertion in a binary search tree
       */
    // implement a binary search tree
    static class Tree {

        int val;
        Tree left;
        Tree right;

         Tree(int val) {
            this.val = val;
            left = right = null;
        }
    }
    // implement the algorithm
    static Tree insert(int key, Tree root) {
        // use a queue to maintain the root node of where the key need to be placed
        // edge cases
        if(root == null) {
            return new Tree(key);
        }
        Queue<Tree> nodes = new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            Tree tempNode = nodes.peek();
            nodes.remove();
            if(tempNode.left == null) {
                tempNode.left = new Tree(key);
                break;
            }
            else {
                nodes.add(tempNode.left);
            }
            if(tempNode.right == null) {
                tempNode.right = new Tree(key);
                break;
            }
            else {
                nodes.add(tempNode.right);
            }
        }
        return root;
    }
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


    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.value == q.value)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
}

    /**
     * TODO :: Deletion in a binary tree
     */
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

    // Binary Tree
    /**
     * 297. Serialize and Deserialize Binary Tree
     */

   static String s = "";
    // Encodes a tree to a single string.
    public static String serialize(Tree root) {
        if(root == null) {
            s.concat(String.valueOf(root.val));
            return s;
        }
        // DFS in order traversal of binary tree
        serialize(root.left);
        s.concat(String.valueOf(root.val));
        serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        // de serialize in a DFS manner
    return null;
    }

         public TreeNode sortedArrayToBST(int[] nums) {
            // use binary search to search to get to add values to the tree
            return createTree(nums, 0, nums.length - 1);
        }
        TreeNode createTree(int[] nums, int start, int end) {
            // base case
            if(start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = createTree(nums, start, mid - 1);
            node.right = createTree(nums, mid + 1, end);
            return node;

        }
    }
