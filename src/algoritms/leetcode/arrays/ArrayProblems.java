package algoritms.leetcode.arrays;

import java.util.*;

public class ArrayProblems {

    public static void main(String[] args) {

        // System.out.println(containsDuplicate(new int[]{1 , 2, 3}));

        // System.out.println(productOfIntExceptSelf(new int[]{ 1, 2, 3, 4, 5 }));

        // System.out.println(Arrays.toString(twoSum(new int[]{3,3 }, 6)));

        // System.out.println(maxProductSubArray(new int[]{2, 3, -2, 4}));

        // System.out.println(Arrays.toString(productExceptSelf(new int[]{9, 0, -2})));

    }

    /**
     *
     * 238. Product of Array Except Self
     *
     * Leetcode Completed
     */
    public static int[] productExceptSelf(int[] nums) {

        // create a temporary array and loop from the left by multiplying everything

        // create a temporary array and loop from the right by multiplying everything

        // return the temporary array

        if(nums == null || nums.length == 0) {
            return nums;
        }

        int[] resultArray = new int[nums.length];

        resultArray[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            resultArray[i] = resultArray[i - 1] * nums[i - 1];
        }

        int product = 1;
        for(int i = resultArray.length - 1; i >= 0; i--) {
            resultArray[i] = product * resultArray[i];
            product = product * nums[i];
        }
        return resultArray;
    }

    /**
     *
     * 152. Maximum Product Subarray - Similar to 238
     *
     * Leetcode Completed
     * Input: [2,3,-3,-4,-5]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     *
     * TODO : LeetCode
     */
    static int maxProduct(int[] nums) {
     int maxProduct = 0;
     return maxProduct;

    }

    /**
     * 11. Container with most water
     * <p>
     * Efficient Approach :: Solve in linear time
     * <p>
     * Two pointers - One at the begin and one at the end
     * keep moving pointers based on the next highest number - meaning if is less than the other move the lesser number pointer
     * if the pointer values are equal it does not matter
     * <p>
     * calculate the max area at each and keep updating it if more that the previous calculated max area
     *
     * Leetcode Completed
     *
     */
    private static int maxArea(int[] heights) {

        // tow pointers begin and end
        int begin = 0;
        int end = heights.length - 1;

        int maxArea = 0;
        while (begin < end) {
            maxArea = Math.max(Math.min(heights[begin], heights[end]) * (end - begin), maxArea);
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
     * <p>
     * Leetcode Completed
     *
     */
    private static int maxProfit(int[] prices) {


        //  Approach :: keep track of a min value and update it upon every iteration

        // keep track of maximum profit and update it upon every iteration

        int minValue = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;


        for (int i = 0; i < prices.length - 1; i++) {

            minValue = Math.min(minValue, prices[i]);

            if (prices[i + 1] - minValue > 0) {
                int currentMaxProfit = prices[i + 1] - minValue;
                maxProfit = Math.max(maxProfit, currentMaxProfit);
            }
        }

        if (maxProfit < 0) {
            maxProfit = 0;
        }
        return maxProfit;

    }


    /**
     * 1. Two Sum
     * Approach :: subtract every integer from the target and store the subtracted value in a hash map
     * if the map already contains the subtracted value then (capture the existing index and the first added index)
     * {3 , 2 , 3, 6} - 6
     */
    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> resultMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int subtractedValue = target - nums[i];

            if (resultMap.containsKey(nums[i])) {
                return new int[]{resultMap.get(nums[i]), i};
            } else {
                resultMap.put(subtractedValue, i);
            }
        }
        return new int[]{};
    }


    /**
     * 53. Maximum Sub-array
     * <p>
     * Similar to house robber dynamic programming
     * Approach  // keep updating nums array , by adding all the values greater than previous
     * // keep track of the maximum value at the same time
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    /**
     * 53. maximum product subarray
     * <p>
     * Approach :: TODO Practice this in leet-code
     */
    public static int maxProductSubArray(int[] nums) {

        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            //  imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }


    /**
     * 153. Find Minimum in Rotated Sorted Array
     * <p>
     * Approach :: Use binary search to solve this
     * TODO:: Implement this
     */
    public static void minimumInRotatedSortedArray(int[] nums) {
    }


    /**
     * 33. Search in Rotated Sorted Array
     * <p>
     * Approach :: Use binary search to solve this
     * <p>
     * TODO:: Implement this
     */
    public static void searchInRotatedSortedArray(int[] nums) {
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


    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {

        if(d > a.length){
            d = d % a.length;
        }

        int[] resultArray = new int[a.length];

        // have two passes on the array

        // second half of the array starting from
        int start = a.length - d;
        for (int i = 0; i < d; i++) {
            resultArray[start] = a[i];
            start++;
        }
        start = a.length - d;

        // first half of the array
        for(int i = 0; i < start; i++) {
            resultArray[i] = a[d];
            d++;
        }






        return resultArray;
    }
}





































