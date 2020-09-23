package algoritms.misc.practice.strings;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class StringProblems {


    public static void main(String[] args) {

      //  System.out.println(isAValidPalindrome("ababa"));

      //  System.out.println(longestUniqueSubString("pwwke"));

      //  System.out.println(twoStringsAnagrams2("anagram" , "nagaram"));




    }

    private static int maxLength;
    private static int startIndex;


    private static void isAValidPalindrome(String input) {

        // Reverse the string
       /* StringBuilder sb = new StringBuilder();

        for(int i = input.length() - 1; i > -1; i--) {
            sb.append(input.charAt(i));
        }
        // Compare if its equal
        if(sb.toString().equals(input)) {
            System.out.println("Its Palindrome");
        }*/

        // Better solution If the left half equal to right then its a valid palindrome

        // Use while loop to compare first half and second half of the loop
        int left = 0;

        int right = input.length() - 1;

        while (left < right) {

            if (input.charAt(left) != input.charAt(right)) {
                return;
            }
            left++;
            right--;
        }
        System.out.println("Its Palindrome");
    }

    /**
     * brute force method
     * - compare every string using two for loops
     * - reverse the string and then see if its equal
     * - capture the length in a variable and replace it if it exceeds max length
     * <p>
     * efficient approach
     * -  a linear approach
     * -  loop through the string
     * -  expand around the middle for each element in the loop
     * -  keep track of maxLength and the start index
     * -  consider even and odd scenarios
     */
    private static String findTheLongestPalindrome(String input) {

        if (input.length() <= 1) {
            return input;
        }

        for (int i = 0; i < input.length() - 1; i++) {
            expandAroundMiddle(i, i, input);
            expandAroundMiddle(i, i + 1, input);
        }
        return input.substring(startIndex, startIndex + maxLength);
    }

    private static void expandAroundMiddle(int left, int right, String input) {

        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        if (maxLength < right - 1 - left) {
            maxLength = right - 1 - left; // -1 here to avoid out of bound exception
            startIndex = left + 1; // +1 here to avoid out of bound exception
        }
    }

    /**
     * brute force - compare characters with the next one ,
     * <p>
     * input abcabcbb - a -> if next one is not same keep going
     *
     * @param s abcabcbb input bbbb pwwkew
     * @return 3
     */
    private static int longestUniqueSubString(String s) {

        // loop through the array

        // add and maintain the indexes of character found in a map

        // keep a pointer that will point to the index after the previous if same character found

        //  keep updating  max length based on value


        Map<Character, Integer> characterIndex = new HashMap();
      int ans = 0;
        for(int i =0, j = 0; j < s.length(); j++) {

            // if found in map update the pointer of i

           if(characterIndex.containsKey(s.charAt(j))) {
               i = Math.max(characterIndex.get(s.charAt(j)) , i);
           }
           ans = Math.max(ans, j - i + 1); // +1 since it need to be length
           characterIndex.put(s.charAt(j) , j + 1); // since we want the index of i to point to the next one after the previous same character
        }

        return ans;
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
        return string1.equals(string2);
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

                // substring the string without that character
                t = t.substring(0, index) + t.substring(index + 1, t.length());

            }
        }
        return t.isEmpty();
    }

    // best algorithm in terms of time and space complexity
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    // Group Anagrams - Leet Code 49
    public List<List<String>> groupAnagrams(String[] strs) {

        // 'ate' --> index 1     --> 'eat' at index 5

        // Brute force - take an individual string --> compare it with all the other strings --> use the logic to find other know anagrams

        // How can this be solved in a linear approach

        // This can be solved in a linear approach using a hash map

        // 'ate' --> key
                 // --> 'ate'
                 // --> sort the anagram
                 // -->  check if this one matches with the anagram
                // if it does add it to the map
                // else add a new key value in the map


        return null;
    }

    // Is Valid Parenthesis - Leet Code 20
    public boolean isValidParenthesis(String s) {

       //  '()' valid

       // '()[]{}' valid

       // '([)]'

       // "{[]}"


        return false;

    }

    // Is Valid Parenthesis - Leet Code 20
    public boolean isString1PermutationOfString2(String s1, String s2) {



        return false;

    }

}
