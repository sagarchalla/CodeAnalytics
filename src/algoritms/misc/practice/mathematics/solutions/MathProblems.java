package algoritms.misc.practice.mathematics.solutions;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.*;

/**
 * Class to solve math problems programmatically.
 */
public class MathProblems {

    /**
     * Program multiplies all integers except itself in the
     * array - loops through two times can this be modified
     */
    public static void multiplyInts() {
        int[] integerArray = {1, 2, 4, 5, 6, 78};
        int[] productsArray = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            int value = 1;
            for (int j = 0; j < integerArray.length; j++) {
                if (i != j)
                    value = value * integerArray[j];
            }
            productsArray[i] = value;
        }
        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Product Array at " + i + " " + productsArray[i]);
        }
    }


    // Two dimensional array problems
    // count negative integers in a two dimensional array
    public static void findNegativeInTwoDimAry() {

        int[][] twoDimAry = { {1,2,3},{3,-1,-2}, {-3,-3,-4}};
        int count = 0;
        // Loop through it
        for(int i=0; i< twoDimAry.length; i++) {
            for(int j=0; j< twoDimAry.length; j++) {
                if(twoDimAry[i][j] < 0)
                 count += 1;
                //   System.out.println("Printing Array Elements :: " + twoDimAry[i][j]);
            }
        }
        System.out.println("Total Number of Negative Numbers " + count);

      // Optimize this solution by calling the loop just once
      // use while loop traverse from right to left

    }


    public static void main(String[] args) {

        // uniqueString();
       /* findNegativeInTwoDimAry();

        int[][] a = {{1, 2, 3, 4, 5},
                {11,22,33,44,55},
                {5, 4, 3, 2, 1},
                {55,44,33,22,11},
                {6, 7, 8, 9, 0}};

        int[][] c = {{1, 2, 3, 4, 5},
                {11,22,33,44,55},
                {5, 4, 0, 2, 1},
                {55,44,33,22,11},
                {6, 7, 8, 9, 22}};

        int [][] b = {{1,2},
                      {3,4}};

        findZerothElementInTowDim(c);
*/
        // rotateInPlace(b);

    }
     static int[] twoSum(int[] nums, int target) {
        int[] returnArray = new int[2];
        for(int i =0; i <nums.length; i++) {
            for(int j= i+1 ; j <nums.length; j++){
                if(nums[i] + nums[j] == target)  {
                    returnArray[0] = i;
                    returnArray[1] = j;
                    return returnArray;
                } } }
        return returnArray; }

     static void findZerothElementInTowDim(int[][] matrix) {
         // Loop through matrix
         for (int i = 0; i < matrix.length; i++) {
             for (int j = 0; j < matrix[i].length; j++) {
                 if (matrix[i][j] == 0) {
                     int column = 1;
                     int row = 1;
                     int lastElemntIndexRows = matrix.length;
                     int lastElentIndexColums = matrix[i].length;
                     for (int k = row; k < lastElemntIndexRows; k++) {
                         for (int n = column; n < lastElentIndexColums; n++) {
                             matrix[k][n] = 0;
                         } } } } }
         for(int i = 0 ;i < matrix.length; i ++) {
             for (int j=0; j < matrix[i].length; j++)   {
                 System.out.printf("%5d ", matrix[i][j]);
             }
             System.out.println();
         } } }






