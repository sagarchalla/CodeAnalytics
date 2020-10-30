package algoritms.leetcode.contest;

import java.util.HashSet;

public class DailyCodingProblems {


    /**
     *
     * abcba
     *
     * TODO : Compelete this
     *
     * Given an integer k and a string s,
     * find the length of the longest substring that contains at most k distinct characters.
     *
     */

    int startIndex = 0;
    int maxLength = 0;

    static String findDistinctChars(String s, int k) {

        String subString = "";
        HashSet<Character> chars = new HashSet<>();

        int startIndex = 0;
        int endIndex = 0;

        for(startIndex = 0; startIndex < s.length(); startIndex++) {

            if(chars.size() > k) {



                // distinct case
                // update the substring here


            }

           /* else  {
                chars.add(s.charAt(i));
            }*/




        }
        return "";
    }
}
