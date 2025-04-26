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
public class ReverseWordsInString {

    public static String reverseWords(String sentence) {
        var result = new StringBuilder();
        var word = new StringBuilder();
        for (var i = sentence.length() - 1; i >= 0; i--) {
            if (sentence.charAt(i) == ' ' && !word.isEmpty()) {
                result.append(word);
                result.append(' ');
                word.setLength(0);
            } else if (sentence.charAt(i) != ' ') {
                word.insert(0, sentence.charAt(i));
            }
        }
        result.append(word);
        if (!result.isEmpty() && result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" lazy dog a over fox jumped brown quick The"));
    }
}
