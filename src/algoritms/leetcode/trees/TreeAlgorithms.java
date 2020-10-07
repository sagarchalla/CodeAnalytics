package algoritms.leetcode.trees;

public class TreeAlgorithms {

    public static void main(String[] args) {

    }

    // Depth first Search
    public int numIslands(char[][] grid) {

        // traverse though the whole grid

        // if i come across land - 1 add to count

        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {

                if (grid[row][col] == '1') {
                    count += dfs(grid, row, col);
                }

            }

        }
        return count;
    }

        // recursive method
        int dfs(char[][] grid, int row, int col) {


            // base case
            if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') {
                return 0;
            }

            // visited already make it zero
            grid[row][col] = '0';


            dfs(grid, row + 1, col);
            dfs(grid, row - 1, col);
            dfs(grid, row, col + 1);
            dfs(grid, row, col - 1);
            return 1;

        }


        // TODO Alternative approach using queue
    public TreeNode invertTree(TreeNode root) {


        //Use Depth first Search

        // base case
        if(root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);


        root.left = right;
        root.right = left;

        return root;

    }

    // TODO try alternative approach
    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);


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
