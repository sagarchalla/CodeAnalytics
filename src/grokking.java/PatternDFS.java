package grokking.java;

import java.util.ArrayList;
import java.util.List;

// depth first search
public class PatternDFS {


     // treenode class
     static class TreeNode {
         TreeNode left;
         TreeNode right;
         int val;
         public TreeNode(int val){
             this.val = val;
         }
     }

     // Binary Tree Path Sum
     public static boolean hasPath(TreeNode root, int sum) {

         if(root == null)
             return false;

         if(sum == 0 && root.left == null && root.right == null)
             return true;

         return (hasPath(root.left , sum - root.val) || hasPath(root.right , sum - root.val));

     }

     // Find all paths
     public static List<List<Integer>> findPaths(TreeNode root, int sum) {
         List<List<Integer>> allPaths = new ArrayList<>();
         List<Integer> path = new ArrayList<>();
         addAllPaths(allPaths , root, sum , path);
         return allPaths;
     }

    public static void addAllPaths(List<List<Integer>> allPaths, TreeNode root, int sum ,List<Integer> path){
        if(root == null)
            return;
        path.add(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            allPaths.add(new ArrayList<>(path));
        }
        addAllPaths(allPaths , root.left, sum - root.val, path);
        addAllPaths(allPaths , root.right, sum - root.val, path);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}



