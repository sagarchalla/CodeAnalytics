package chapter1.arrays;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayAlgorithms {

    // Main method to call other methods
    public static void main(String[] args) {

        int[] array = {0, 0 , 2, 1, 1, 2 ,2};
        countNums(array);
        // isStringUnique("aabb");
       /* Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        input = input.replaceAll("\\s", "");*/
        // twoStringsAnagrams2("abc" , "acb");
        // isUnique(input);
        // stringReverse(input);
    }




    // Rotate an image by 90 degrees

    // 1.6
    /**
     * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
     * write a method to rotate the image by 90 degrees. Can you do this in place?
     */
    private static void rotateImgBy90() {

        int[][] image = {{1,   2,  3,  4,  5},
                {6,   7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        // Now the loop part
        // traverse thru outer loop
        int outerLoop = 0;
        for(int i=0 ; i< image.length - 1; i++) {
            for(int j = i; j< image[j].length - 1; j++){
            }
        }
        int topLeft = image[0][0];
        int topRight = image[0][4];

        image[0][4] = topLeft;
        int bottomRight = image[4][4];
        image[4][4] = topRight;
        int bottomLeft = image[4][0];
        image[4][0] = bottomRight;
        image[0][0] = bottomLeft;

        for(int i = 0 ;i < image.length; i ++) {
            for (int j=0; j < image[i].length; j++)   {
                System.out.printf("%5d ", image[i][j]);
            }
            System.out.println();
        }

        for (int x = 0; x < image.length / 2; x++)
        {
            System.out.println("Print Each Number " + image[x]);

            // Consider elements in group of 4 in
            // current square
            for (int y = x; y < image.length-x-1; y++)
            {

                System.out.println("Print Each Number " + image[x][y]);
            }
        }
    }
    // 3 problems to do
    // 1.7 If an element in an m by n matrix is zero its entire row or column is zero

    // 1.5 write a method to replace all spaces in a string with '%20
    // 1.8 check if a a method is a rotation subString of other by using only one method call of

    // sort problem
   static void countNums(int[] nums) {
       int[] countofNums = new int[3];

       for(int i = 0; i< nums.length; i++) {

           if(countofNums[nums[i]] != 0)
               countofNums[nums[i]]++;
           else
               countofNums[nums[i]] = 1;
       }
       int i = 0;
       int j = 0;
       int[] resultArray = new int[nums.length];
       while(i <= 2) {
           if(countofNums[i] != 0) {
               resultArray[j] = i;
               j++;
               countofNums[i]--;
           }
           else {
           i++;
           }


       }
   } }

































