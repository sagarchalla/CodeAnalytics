package algoritms.leetcode.dynamicprogramming;


import java.util.Arrays;

/**
 * 2 ways to solve a dynamic programming problem - memoization / recursion
 */
public class DynamicProgramming {

    public static void main(String[] args) {
     //   System.out.println(climbingStairCase(5));

        System.out.println(uniquePaths(7, 3));
    }

    /**
     * LeetCode Problem Number - 70
     *
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Approach
     * :: Identify this as a dynamic programming problem
     * :: Consider a base case and them keep going
     * :: For 1 through 3 numbers number of step is n
     * :: For 4 and so on its a fibonacci sequence obvious since the the current steps to reach is sum of previous two steps (n -1) + (n - 2)
     *
     * LeetCode: Completed
     */

    private static int climbingStairCase(int n) {

        if (n <= 3) {
            return n;
        }
        int[] resultArray = new int[n];

        resultArray[0] = 1;
        resultArray[1] = 2;
        resultArray[2] = 3;

        for (int i = 3; i < resultArray.length; i++) {
            resultArray[i] = resultArray[i - 1] + resultArray[i - 2];
        }
        return resultArray[n - 1];
    }
    /**
     * 198. House Robber
      Approach
      At every step calculate if its higher than the one before
      Sum up the alternative number and return the result set back
      Leetcode:: Completed
     */
    public int rob(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0] , nums[1]);
        }
        nums[1] = Math.max(nums[0] , nums[1]);
        for(int i = 2; i < nums.length; i++)
        {
            nums[i] = Math.max(nums[i - 1] , nums[i] + nums [i - 2]);
        }
        return nums[nums.length - 1];
    }


/**
 *  55. Jump Game
 *
 * Approach :: Bottom up approach
 *
 * [2] -> is length = the 1st number at index - false
 *
 * [1] -> is length = 1st number in index - false
 *
 * [2 , 1] -> lastIndex - firstNumber == 0
 *
 * [2 , 3, 1 , 1 , 4]
 *    At every step (if i take 1 step )
 *
 * [3, 2, 1, 0 ,4]
 *
 *https://leetcode.com/problems/jump-game/solution/ TODO - Go through this approach in detail
 * /
 *
 *


 /** 300. Longest Increasing Subsequence
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * [10] [10, 9] [10, 9, 2]
 *
 * Approach :: instantiate an array and fill it with all 1
 *          :: at each index integer - calculate all the possible scenarios for the longest increasing subsequence and update the temp array
 *          :: keep track of the max length at that variable
 *
 */ // TODO solve this in leetcode 

 static  int longestSubsequence(int nums[]) {

      if (nums.length == 0) {
          return 0;
      }

      int[] resultArray = new int[nums.length];

      int maxValue = 1;

      Arrays.fill(resultArray, 1);

      for (int j = 1; j < nums.length; j++) {
          for (int i = 0; i < j; i++) {
              if (nums[j] < nums[i]) {
                  resultArray[j] = Math.max(resultArray[j] + 1, resultArray[j]);
              }
          }
          maxValue = Math.max(resultArray[j], maxValue);
      }
      return maxValue;

  }
  // TODO solve this in leetcode
  static int coinChange(int[] nums, int target) {


   return 0;
  }

  // TODO Unique Paths

    /** 62. Unique Paths
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * How many possible unique paths are there?
     *
     * Approach :: 1st though is recursion but that calculates all the likely possible scenarios
     * A better approach would be to use memoization that is a look up table
     * If we can store the values that are already visited in a look up table then we can use those to calculate the rest
     */

  static int uniquePaths(int m , int n) {

      int[][] matrix = new int[m][n];

      for(int i = 0; i < matrix.length; i++) {

          for(int j =0; j  < matrix[i].length; j++) {

              // populate all the first row values  to be 1
              if(i == 0 || j == 0) {
                  matrix[i][j] = 1;
              }
              else {
                  matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
              }
          }
      }
return matrix[m -1][n - 1];



  }
}




