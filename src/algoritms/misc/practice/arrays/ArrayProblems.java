package algoritms.misc.practice.arrays;

import java.util.HashSet;
import java.util.Set;

public class ArrayProblems {

    public static void main(String[] args) {
       // System.out.println(containsDuplicate(new int[]{1 , 2, 3}));
       // System.out.println(productOfIntExceptSelf(new int[]{ 1, 2, 3, 4, 5 }));

     }



    /**
     * Brute Force :: At every integer we check the product of all the left and all the right
     *
     * Efficient Approach :: At each integer multiply all the values left of it , second iteration multiply all the right values of it
     *
     */
    // TODO -- Solve this in leetcode

    private static int[] productOfIntExceptSelf(int[] nums) {

        // edge case if any number in the result is zero then return zero

         int resultArray[] = new int[nums.length];

         resultArray[0] = nums[0];

         // Left to Right
         for(int i = 1; i < nums.length; i++) {
             resultArray[i] = resultArray[i - 1] * nums[i - 1];
         }

         // Right to Left
        int R = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            resultArray[i] = resultArray[i] * R;
            R *= nums[i];

        }
        return resultArray;

    }

    /**
     * Efficient Approach :: Use a set to determine if the value already exists
     */
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) {
            if (!uniqueNumbers.contains(num)) {
                uniqueNumbers.add(num);
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     *
     * 11. Container with most water
     *
     * Efficient Approach :: Solve in linear time
     *
     *  Two pointers - One at the begin and one at the end
     *  keep moving pointers based on the next highest number - meaning if is less than the other move the lesser number pointer
     *  if the pointer values are equal it does not matter
     *
     *  calculate the max area at each and keep updating it if more that the previous calculated max area
     *
     */

    // TODO -- Solve this in leetcode
    private static int maxArea(int[] heights) {

        // tow pointers begin and end
        int begin = 0;
        int end = heights.length - 1;

        int maxArea = 0;
        while (begin < end) {
            maxArea = Math.max(Math.min(heights[begin] , heights[end]) *  (end - begin), maxArea);
            if (heights[begin] > heights[end]) {
                end--;
            } else {
                begin++;
            }
        }
     return maxArea;
    }


    /**
     * 121. Best Time to Buy and Sell Stock
     *
     * Approach ::
     */
    private static int  maxProfit(int[] prices){


        //  Approach :: keep track of a min value and update it upon every iteration

        // keep track of maximum profit and update it upon every iteration

        int minValue = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;


        for(int i = 0; i < prices.length - 1; i++) {

            minValue = Math.min(minValue , prices[i]);

            if(prices[i + 1] - minValue > 0) {
                int currentMaxProfit = prices[i + 1] - minValue;
                maxProfit = Math.max(maxProfit, currentMaxProfit);
            }
        }

        if(maxProfit < 0) {
            maxProfit = 0;
        }
        return maxProfit;

    }


    /**
     * 1. Two Sum
     *
     * Approach ::
     */
    private static int  twoSum(int[] nums){


  return 0;


    }
}






































