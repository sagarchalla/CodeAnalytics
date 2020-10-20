package algoritms.leetcode.strings;

import java.util.*;

public class StringProblems {


    public static void main(String[] args) {

        // System.out.println(isPalindrome2(",abA,"));

        // System.out.println(findTheLongestPalindrome("abba"));

        // System.out.println(lengthOfLongestSubstring("abcabcbb"));

        //System.out.println(twoStringsAnagrams2("anagram" , "nagaram"));

        //System.out.println(numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));

        //System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"} ));

        // System.out.println(isValidParenthesis("(]"));
    }

    private static int maxLength;
    private static int startIndex;

    /**
     * 125. Valid Palindrome
     *
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     *
     * Leetcode : Completed
     *
     */
    public static boolean isPalindrome(String s) {

        // parse the string
        // traverse through the string
        // instantiate and traverse the whole array matching the first and last pointers
        if(s.length() == 1) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int begin = 0;
        int end = s.length() - 1;
        while(begin < end) {
            if(s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    // Alternative Solution  Leetcode :Not Completed
    public static boolean isPalindrome2(String s) {
        s = s.toLowerCase();
        boolean result = true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                i ++;
                continue;
            }
            if (!((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
                j --;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                result = false;
                break;
            }
            i ++;
            j --;
        }
        return result;
    }

    /**
     * 680. Valid Palindrome II
     *  Similar to 125
     *
     *  Leetcode : Completed
     */
    public boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while(i < j) {

            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(i , j - 1, s) || isPalindrome(i + 1, j, s);
            }
            i++;
            j--;
        }
        return true;
    }
    // helper method
    boolean isPalindrome(int i , int j , String s) {

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 5. Longest Palindromic Substring
     *
     *  LeetCode : Completed
     */
    public String longestPalindrome(String s) {

        if(s.length() == 1){
            return s;
        }
        for(int i = 0; i < s.length(); i++) {

            // odd scenario
            isValidPalindrome(i , i , s);

            // even scenario
            isValidPalindrome(i, i + 1, s);

        }
        return s.substring(startIndex , startIndex + maxLength);
    }


    void isValidPalindrome(int left ,int right,String s) {

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        int currentMaxLength = right - 1 - left;
        if(currentMaxLength > maxLength) {
            maxLength = currentMaxLength;
            startIndex = left + 1;
        }
    }

    /**
     * 3. Longest Substring Without Repeating Characters
     *
     */
    private static int longestUniqueSubString(String s) {

        Map<Character, Integer> characterIndex = new HashMap();
        int ans = 0;int i =0;
        for(int j = 0; j < s.length(); j++) {

            // if found in map update the pointer of i
           if(characterIndex.containsKey(s.charAt(j))) {
               i = Math.max(characterIndex.get(s.charAt(j)) , i);
           }
           ans = Math.max(ans, j - i + 1); // +1 since it need to be length
           characterIndex.put(s.charAt(j) , j + 1); // since we want the index of i to point to the next one after the previous same character
        }
        return ans;
       }

    /**
     * 242. Valid Anagram
     *
     */
    private static boolean twoStringsAnagrams(String s, String t) {
        char[] string1 = s.toCharArray();
        char[] string2 = t.toCharArray();
        Arrays.sort(string1);
        Arrays.sort(string2);
        return string1.equals(string2);
    }
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
    public boolean twoStringsAnagrams3(String s, String t) {
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


    /**
     * 49. Group Anagrams
     * LeetCode : Completed
     */
    static List<List<String>> groupAnagrams(String[] strs) {

        // sort each string and compare
        // hashMap to with key as the sorted string and values as the string itself
        Map<String , List<String>> anagramMap = new HashMap();

        for(String s: strs) {

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            List<String> anagrams = new ArrayList();

            if(anagramMap.containsKey(sortedString)) {
                anagrams = anagramMap.get(sortedString);
            }
            anagrams.add(s);
            anagramMap.put(sortedString, anagrams);
        }
        return new ArrayList(anagramMap.values());
    }

    /**
     * 20. Valid Parentheses
     * LeetCode : Completed
     *
     */
    static boolean isValidParenthesis(String s) {


        // two data structures needed

        // hashmap - to keys and values as '(' , ')'

        // use stack to keep track of the last value

        // check against the top element and if fails return

        return false;
    }

    /**
     * 929. Unique Email Addresses
     * LeetCode Completed
     */
    public static int numUniqueEmails(String[] emails) {

        // split the string into two string - localName and domanin name
        // parse these string with the rules defined
        // set to add all those emailaddresses parsed
        // return the size of the set

        Set<String> emailSet = new HashSet();

        for(String email: emails) {

            String[] mail = email.split("@" , 2);
            String localName = mail[0].replace(".", "");
            int index = localName.indexOf("+");

            if(index != -1){
                localName = localName.substring(0, index);
            }
            String finalEmail = localName.concat("@").concat(mail[1]);
            emailSet.add(finalEmail);

        }
        return emailSet.size();

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

   static void removeDuplicatesInString2(String a) {
        String str = "";
        for(int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(str.indexOf(c) < 0) {
                str += c;
            } } }

    public boolean isString1PermutationOfString2(String s1, String s2) {
        // use sliding window technique here
        return false;

    }
    public String restoreString(String s, int[] indices) {

        // if the length of the string and the indices are not euqal return
        // loop though the input string
        // find the inex of the the character in the indice array
        // pupulate the array with with the values

        char[] resultArray = new char[s.length()];

        for(int i = 0; i < s.length() ; i ++) {

            char c = s.charAt(i);

            int index = indices[i];

            resultArray[index] = c;

        }

        String resultString = new String(resultArray);

        return resultString;



    }

}
