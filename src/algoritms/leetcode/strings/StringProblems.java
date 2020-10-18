package algoritms.leetcode.strings;

import java.util.*;

public class StringProblems {


    public static void main(String[] args) {
        System.out.println(isPalindrome2(",abA,"));
        //System.out.println(findTheLongestPalindrome("abba"));
       // System.out.println(lengthOfLongestSubstring("abcabcbb"));
        //isStringUnique("aaaa");
        //System.out.println(twoStringsAnagrams2("anagram" , "nagaram"));
        //System.out.println(numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        //System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"} ));
        System.out.println(isValidParenthesis("(]"));
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

    // Alternative Solution
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
     * 234. Palindrome Linked List
     * Similar to 125
     *
     * Leetcode : TODO
     */


    /**
     * 5. Longest Palindromic Substring
     *
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
     *
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
        } }



    /**
     * brute force - compare characters with the next one
     * input abcabcbb - a -> if next one is not same keep going
     * abcabcbb input bbbb pwwkew - sliding window approach
     * TODO :: can this be solved using index of method
     */
    private static int longestUniqueSubString(String s) {

        // loop through the array
        // add and maintain the indexes of character found in a map
        // keep a pointer that will point to the index after the previous if same character found
        // keep updating  max length based on value

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

    public static int lengthOfLongestSubstring(String s) {



        int i = 0;
        int maxLength = 0;

        Map<Character, Integer> charMap = new HashMap<>();

        for(int j =0; j < s.length(); j++) {

            if(!charMap.containsKey(s.charAt(j))) {
                charMap.put(s.charAt(j) , j + 1);
            }
            else {
                i = charMap.get(s.charAt(j));
            }

            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;

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

    // two strings are anagrams
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
    // TODO understand this algorithm and implement it in leetcode
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
     *
     *
     *
     */
    // TODO solve this in leet-code
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


    // Is Valid Parenthesis - Leet Code 20
     static boolean isValidParenthesis(String s) {


        //  '()' valid

        // '()[]{}' valid

        // '([)]'

        // "{[]}"

         // keep a variable to know if its an open brac vs cloased brace

         // if its a closed brace pop or keep pushing into the stack

         // if the stack is empty towards the end then its valid

         Stack<Character> stack = new Stack<Character>();
         for (char c : s.toCharArray()) {
             if (c == '(')
                 stack.push(')');
             else if (c == '{')
                 stack.push('}');
             else if (c == '[')
                 stack.push(']');
             else if (stack.isEmpty() || stack.pop() != c)
                 return false;
         }
         return stack.isEmpty();
     }


    public boolean isString1PermutationOfString2(String s1, String s2) {


        // use sliding window technique here
        return false;

    }


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
