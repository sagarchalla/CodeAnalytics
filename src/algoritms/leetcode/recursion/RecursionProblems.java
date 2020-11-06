package algoritms.leetcode.recursion;


// Recursion is basically of two types

import java.util.*;

// 1 - Recursion Itself 2 - Back Tracking
public class RecursionProblems {

    public static void main(String[] args) {
        generateParenthesis(4);
    }

    /**
     * FB Question LeetCode Problem :
     * 22. Generate Parentheses
     *
     * TODO :: Understand how recursive call stack works during the back track method
     *
     */
    static List<String> generateParenthesis(int n) {

        // create a result list
        // add to the result list if the string is of length 6 and meets the contraints
        List<String> resultSet = new ArrayList<>();
        computeParenthesis( n , resultSet, "", 0 , 0);
        return resultSet;
    }

    static void computeParenthesis(int n ,List<String> resultSet, String current, int open , int close) {
        System.out.println(current);
        if(current.length() == n * 2) {
            resultSet.add(current);
            return;
        }
        if(open < n) {
            computeParenthesis(n, resultSet, current + "(" , open + 1, close);
        }
        if(close < open)
            computeParenthesis(n, resultSet, current + ")", open , close + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int current = 0;
        List<List<Integer>> result = new ArrayList<>();
        // back tracking method
        backTrack(target  , 0,  new ArrayList<Integer>(), result, candidates);
        return result;


    }

    /**
     * FB Question LeetCode Problem :
     * 39. Combination Sum
     *
     * TODO :: Understand how recursive call stack works during the back track method
     *
     */
    void backTrack(int target, int start, List<Integer> combination, List<List<Integer>> result, int[] candidates) {
        // base case
        if(target == 0) {
            result.add(new ArrayList(combination));
            return;
        }
        // base case 2
        if(target < 0) {
            return;
        }
        // logic
        for(int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backTrack(target - candidates[i], i,  combination, result, candidates);
            combination.remove(combination.size() - 1);
        }
    }

    /**
     * FB Question LeetCode Problem :
     * 93. Restore IP Addresses
     *
     *
     *
     */

    /**
     * 494. Target Sum
     */
    public int findTargetSumWays(int[] nums, int S) {
        return backtrack(nums, 0, 0, S, new HashMap<>());
    }

    public int backtrack(int[] nums, int count , int index, int target, Map<String , Integer> map) {
        // memoization
        String key = index + "." + count;
        if(map.containsKey(key)){
            return map.get(key);
        }

        // base case
        if(index == nums.length) {
            if(count == target) {
                return 1;
            }
            else {
                return 0;
            }
        }
        // recursive calls
        int minus = backtrack(nums, count - nums[index], index + 1, target, map);
        int plus = backtrack(nums,  count + nums[index], index + 1, target, map);
        map.put(key , minus + plus);
        return minus + plus;
    }

}
