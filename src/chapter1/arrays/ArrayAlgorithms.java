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



    // Method One - CCI 1.1
    static void isStringUnique(String str) {
        // creat a boolean array to hold all the stings
        boolean[] isCharPresentArray = new boolean[256];
        // loop through the string
        for(int i = 0 ; i < str.length(); i++) {
            if(isCharPresentArray[str.charAt(i)]){
                System.out.println("string not unique");
                break;
            }
            // tip the char gets converted into index value - int
            // since essentially char gets stored as int in java as ASCII format
            isCharPresentArray[str.charAt(i)] = true;

        }
    }

    // Method Two - CCI 1.1
    static void isStringUnique2(String str) {
        // Create a hash set
        Map<Character, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (stringMap.containsKey(str.indexOf(i))) {
                System.out.println("String Is Not Unique");
                break;
            }
            stringMap.put(str.charAt(i), str.indexOf(i));
        }
    }

    // reverse a c style string
    static void stringReverse(String str) {
        StringBuilder str2 = new StringBuilder();
        for(int i= str.length() - 1 ; i >= 0 ; i-- ) {
            str2.append(str.charAt(i));
        }
        System.out.println(str2.toString());
    }

    static void stringReverse2(String input) {
        char[] inputCharArray = input.toCharArray();
        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.println(inputCharArray[i]);
        }
    }

    // Problem 3 Method1 - brute force
    // Time Complexity - O(n2)
    private static void removeDuplicatesInStrng(String str) {
        String noDups = "";
        for(int i = 0; i< str.length(); i++ ){
            for( int j = 1; i < str.length(); j++) {
                if(str.charAt(i) != str.charAt(j)){
                    noDups += str.charAt(i);
                } } } }

    // Method 2
    // Time Complexity - O(n)
        private static void removeDuplicatesInStrng2(String a) {
        String str = "";
           for(int i = 0; i < a.length(); i++) {
               char c = a.charAt(i);
               if(str.indexOf(c) < 0) {
                   str += c;
               } } }

    // Problem 4
    // Method 1 TimeComplexity O(nlogn)
    private static boolean twoStringsAnagrams(String s, String t) {
        char[] string1 = s.toCharArray();
        char[] string2 = t.toCharArray();
        Arrays.sort(string1);
        Arrays.sort(string2);
        return string1 == string2;
    }

    // Problem 4
    // Method 2 TimeComplexity O(n)
    // substring the string until it becomes empty if all the
    // strings match
    static boolean twoStringsAnagrams2(String s, String t) {
        // 2nd method to use indexOf
        char[] c = s.toCharArray();
        for(char a : c) {
            int index = t.indexOf(a);
            if(index != -1) {
                t = t.substring(0, index) + t.substring(index + 1, t.length());
            }
        }
      return t.isEmpty();
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

































