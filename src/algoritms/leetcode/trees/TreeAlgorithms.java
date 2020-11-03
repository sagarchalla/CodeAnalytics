package algoritms.leetcode.trees;

import org.w3c.dom.Node;

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


        System.out.println(serialize(root));

     /*   String[][] grid = new String[][]{
                {"1", "1", "1", "1", "0"},
                {"1", "1", "0", "1", "0" },
                {"1", "1", "0", "0", "0"},
                {"0", "0", "0", "0", "0"} };

        System.out.println(numOfIslands(grid));
*/

        levelOrderTraversal(root);

       /* postorder(root);
        // System.out.println(maxDepth(treeNode));

        System.out.print(
                "Inorder traversal before insertion:");
        inorder(root);

        int key = 12;
        insert(key , root);

        System.out.print(
                "\nInorder traversal after insertion:");
        inorder(root);
*/
    }
    // In Order Traversal Of A Tree // left , root , right // DFS
    static void inorder(Tree root) {
        if(root == null) {
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

    //Inorder Tree Traversal without recursion and without stack
    static void inOrderTraversal(Tree root)  {



    }

    /**
     * 515. Find Largest Value in Each Tree Row
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

        /**
         * Insertion in a binary search tree
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
     * TODO :: Deletion in a binary tree
     */

    /**
     * 104. Maximum Depth of Binary Tree
     * TODO :: Explore other ways to solve this using stacks and queues
     *
     * LeetCode :: Completed
     */
    public static int maxDepth(TreeNode root) {
         // base casegit
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
}
