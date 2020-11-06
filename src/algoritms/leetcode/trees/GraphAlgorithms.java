package algoritms.leetcode.trees;

import java.util.*;

public class GraphAlgorithms {



      class DirectedGraphNode {
         int label;
         ArrayList<DirectedGraphNode> neighbors;
         DirectedGraphNode(int x) {
             label = x;
             neighbors = new ArrayList<DirectedGraphNode>();
         }
      };

    public static void main(String[] args) {

    }


    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {

        // Use BFS // Add the node to the queue // check its neighbours // if found return true // keep searching

        // edge case
        if(s == t) {
            return true;
        }

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Set<DirectedGraphNode> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        while(!queue.isEmpty()){
            DirectedGraphNode queueNode = queue.poll();
            for (DirectedGraphNode node : queueNode.neighbors) {
                if(node == t) {
                    return true;
                }
                if(!visited.contains(node)) {
                    visited.add(node);
                    queue.offer(node);
                }
            }
        }
        return false;
    }

    // Using DFS Approach
 /*   Set<DirectedGraphNode> visited = new HashSet<>();


    // base case
    if(s == t) {
        return true;
    }

    visited.add(s);

    for(DirectedGraphNode k : s.neighbors) {

        if(!visited.contains(k)) {

            dfs(k , t, visited);
            return true;
        }

    }


    return false;
*/
}

