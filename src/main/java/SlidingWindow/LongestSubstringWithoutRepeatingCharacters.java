package SlidingWindow;

import java.util.*;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

3. Longest Substring Without Repeating Characters
Medium
Topics
Companies

Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int curLength = 0;
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        while (right != s.length()) {
            Character curChar = s.charAt(right);
            if (charMap.get(curChar) == null || charMap.get(curChar) < left) {
                curLength++;
                if (curLength > maxLength) maxLength = curLength;
                charMap.put(curChar, right);
            } else {
                left = charMap.get(curChar) + 1;
                curLength = right - left + 1;
                charMap.put(curChar, right);
            }
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbtablud"));
    }
}
