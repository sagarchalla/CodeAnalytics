package grokking.java;
import java.util.*;


// Breadth First Search
public class PatternBFS {

    static class TreeNode{
        int val = 0;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    // level order traversal of a tree // TC o(n) SC o(n)
    static List<List<Integer>> traverse(TreeNode root){
       Queue<TreeNode> queue = new LinkedList<>();
       List<List<Integer>> result = new ArrayList<>();
       queue.offer(root);
       while(!queue.isEmpty()){
           int size = queue.size();
           List<Integer> level = new ArrayList<>();
           for(int i = 0; i < size; i++){
               TreeNode node = queue.poll();
               level.add(node.val);
               if(node.left != null)
                   queue.offer(node.left);
               if(node.right != null)
                   queue.offer(node.right);
           }
           result.add(level);
       }
       return result;
    }

    // reverse level order traversal // TC SC
    static List<List<Integer>> reverseTraverse(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            stack.add(level);
        }

        List<List<Integer>> result = new Stack<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = reverseTraverse(root);
        System.out.println("Level order traversal: " + result);
    }


}



