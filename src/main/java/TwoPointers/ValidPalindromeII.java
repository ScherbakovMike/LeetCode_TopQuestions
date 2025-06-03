package TwoPointers;

/*
https://leetcode.com/problems/valid-palindrome-ii/submissions/1620879806/

680. Valid Palindrome II
Easy
Topics
Companies
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */
public class ValidPalindromeII {
  public boolean validPalindrome(String string) {
    int low = 0;
    int high = string.length() - 1;
    while (low < high && string.charAt(low) == string.charAt(high)) {
      low++;
      high--;
    }
    return low == high
        || isAStrictPalindrome(string, low + 1, high)
        || isAStrictPalindrome(string, low, high - 1);
  }

  private boolean isAStrictPalindrome(String string, int low, int high) {
    while (low < high) {
      if (string.charAt(low) != string.charAt(high)) {
        return false;
      }
      low++;
      high--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new ValidPalindromeII().validPalindrome("abca"));
  }
}
