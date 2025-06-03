package Strings;

/*
151. Reverse Words in a String

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.


Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */
public class ReverseWordsInAString {

  public String reverseWords(String s) {
    char[] chars = s.toCharArray();
    char[] result = new char[chars.length];
    int pos = 0;
    int wordStart = -1;
    int wordEnd = -1;
    int wordNumber = 0;
    for (int i = chars.length - 1; i >= 0; i--) {
      if (wordStart == -1 && chars[i] != ' ') {
        wordStart = i;
      }
      if (wordStart != -1 && chars[i] != ' ') {
        wordStart = i;
      }
      if (wordEnd == -1 && chars[i] != ' ') {
        wordEnd = i;
      }
      if (wordStart != -1 && (chars[i] == ' ' || i == 0)) {
        if (wordNumber != 0) {
          result[pos] = ' ';
          pos++;
        }
        copyWord(result, pos, chars, wordStart, wordEnd);
        pos += (wordEnd - wordStart + 1);
        wordNumber++;
        wordStart = -1;
        wordEnd = -1;
      }
    }
    return new String(result, 0, pos);
  }

  private void copyWord(char[] result, int pos, char[] chars, int wordStart, int wordEnd) {
    for (int i = wordStart; i <= wordEnd; i++) {
      result[pos++] = chars[i];
    }
  }

  public static void main(String[] args) {
    ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
    String s = "  hello world  ";
    System.out.println(reverseWordsInAString.reverseWords(s)); // Output: "blue is sky the"
  }
}
