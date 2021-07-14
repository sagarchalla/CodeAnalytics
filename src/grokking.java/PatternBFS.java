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

    // has path with sum
    public boolean hasPath(TreeNode root){
        return false;
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

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean left = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                 if (left) {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }if (node.right != null) {
                        queue.offer(node.right);
                    }
                  } else {
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                 }
            }
            result.add(levelList);

            left = !left;

        }
        return result;
    }

    // level order successor
    public static TreeNode findSuccessor(TreeNode root, int key) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right!= null){
                queue.offer(currentNode.right);
            }
            if(currentNode.val == key){
                break;
            }
        }
    return  queue.peek();

    }


    public static List<TreeNode> rightViewTree(TreeNode root) {
            List<TreeNode> result = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    TreeNode current = queue.poll();

                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                    if (i == size - 1){
                        result.add(current.right);
                    }
                }
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
            root.left.left.left = new TreeNode(3);
            List<TreeNode> result = rightViewTree(root);
             for (TreeNode node : result) {
                System.out.print(node.val + " ");
            }
        }


}



