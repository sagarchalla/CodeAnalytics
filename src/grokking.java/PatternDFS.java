package grokking.java;

import cracking.coding.trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// depth first search
public class PatternDFS {

    // problem - has path
    static boolean hasPath(TreeNode root, int number){
        if (root == null) return false;

        // recursive approach condition
        if(root.data == number && root.left == null && root.right == null){
            return true;
        }
        return hasPath(root.left , number - root.data) || hasPath(root.right , number - root.data);
    }
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        dfs(root, sum, res, new ArrayList());
        return res;
    }
    private static void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> list) {
        if (root == null) return;
        list.add(root.data);
        if (root.left == null && root.right == null && target == root.data)
            res.add(new ArrayList(list));
        dfs(root.left, target - root.data, res, list);
        dfs(root.right, target - root.data, res, list);
        list.remove(list.size() - 1);
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




