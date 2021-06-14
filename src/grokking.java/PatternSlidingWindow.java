package grokking.java;

import java.util.HashMap;
import java.util.Map;

public class PatternSlidingWindow {

    // contiguous sub-array of size k
    public static double[] findAverages(int k, int[] array){
        double[] result = new double[array.length - k + 1];
        double sum = Double.MAX_VALUE;
        int indexToRemove = 0;
        for(int i =0; i < array.length; i++){
            // reached k elements
            sum += array[i];
            if(i >= k - 1){
              // calculate average
                result[indexToRemove] = sum/5;
                sum = sum - array[indexToRemove];
                indexToRemove++;
            }
        }
        return result;
    }

    // Fruits into Baskets TODO - LEETCODE
    public static int findLength(char[] arr) {

        Map<Character, Integer> charMap = new HashMap<>();
        int count = 0;
        int windowStart = 0;
        for(int i = 0; i < arr.length; i++){
           charMap.put(arr[i] , charMap.getOrDefault(arr[i], 0) + 1);
           while(charMap.size() > 2){
               charMap.put(arr[windowStart] , charMap.getOrDefault(arr[windowStart], 0) - 1);
               if(charMap.get(arr[windowStart]) == 0){
                   charMap.remove(arr[windowStart]);
               }
               windowStart++;
           }
           count = Math.max(count, i - windowStart + 1);
        }
        return count;
    }

    // Longest Substring with Same Letters after Replacement TC 0(n) , 0(1)
    public static int findLength(String str, int k) {
      int start = 0; int maxRepeatedLetter = 0; int result = 0;
      Map<Character, Integer> freqMap = new HashMap<>();

      for(int i =0; i < str.length(); i++){

          freqMap.put(str.charAt(i) , freqMap.getOrDefault(str.charAt(i) , 0) + 1);
          maxRepeatedLetter = Math.max(maxRepeatedLetter, freqMap.get(str.charAt(i)));

          if(i - start + 1 - maxRepeatedLetter > k){
              freqMap.put(str.charAt(i) , freqMap.get(str.charAt(i)) - 1);
              start++;
          }
          result = Math.max(result , i - start + 1);
      }
       return result;
     }

     // longest substring with letters after replacement // abcde
     public static int findLengthSubstring(String str, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int maxRepeatLetterCount = 0;
        int windowStart = 0;
        int result = 0;
        for(int i = 0 ; i < str.length(); i++){
            Character letter = str.charAt(i);
            map.put(letter, map.getOrDefault(letter, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(letter));

            // move the window if the size is greater than k
            if(i - windowStart + 1 - maxRepeatLetterCount > k){
                // move the window
                Character letter1 = str.charAt(i);
                map.put(letter, map.getOrDefault(letter, 0) - 1);
                windowStart++;
            }

            // calculate the maxLength
            result = Math.max(result, i - windowStart + 1);
        }
        return result;
     }

     // longest sub array with ones after replacement
     public static int findOnesAfterReplacingK(int[] arr, int k) {
             int onesCount = 0; int startIndex = 0;
             for(int i = 0; i < arr.length; i++){
                 if(arr[i] == 1){
                     onesCount++;
                 }
                 if(i - startIndex + 1 - onesCount > k){
                     if(arr[startIndex] == 1){
                         onesCount--;
                     }
                     startIndex++;
                 }

                 onesCount = Math.max(onesCount, i - startIndex + 1);

             }
             return onesCount;
      }

      // permutation in a string String="oidbcaf", Pattern="abc"
      public static boolean findPermutation2(String str, String pattern) {
          // TODO: Write your code here
          return false;
      }


     // permutation in a string
     // example  String="oidbcaf", Pattern="abc"
     // example String="oidbcaf", Pattern="abc" -
     public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> freqMap = new HashMap<>();
         int windowStart = 0;

         // put pattern strings into a hashmap
         for(int i = 0; i < pattern.length(); i++){
             freqMap.put(pattern.charAt(i) , freqMap.getOrDefault(pattern.charAt(i) , 0) + 1);
         }
         int matched = 0;
         // compare the map with the string
         for(int i = 0; i < str.length(); i++){
             Character key = str.charAt(i);
             if(freqMap.containsKey(key)){
                 freqMap.put(key, freqMap.get(key)  - 1);
                 if(freqMap.get(key) == 0){
                     matched++;
                 }
             }
          if(matched == freqMap.size()){
              return true;
          }

          // not matched yet - move the window
             if (i >= pattern.length() - 1) { // shrink the window by one character
                 char leftChar = str.charAt(windowStart++);
                 if (freqMap.containsKey(leftChar)) {
                     if (freqMap.get(leftChar) == 0)
                         matched--; // before putting the character back, decrement the matched count
                     // put the character back for matching
                     freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                 }
             }
         }
     return false;
     }

    public static void main(String[] args) {
      //  System.out.println("Permutation exist: " + findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + findPermutation("odicf", "dc"));
      //  System.out.println("Permutation exist: " + findPermutation("bcdxabcdy", "bcdyabcdx"));
      //  System.out.println("Permutation exist: " + findPermutation("aaacb", "abc"));
    }
}
