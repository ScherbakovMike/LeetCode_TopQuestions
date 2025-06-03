package TwoPointers;

/*
2193. Minimum Number of Moves to Make Palindrome
You are given a string s consisting only of lowercase English letters.
In one move, you can select any two adjacent characters of s and swap them.
Return the minimum number of moves needed to make s a palindrome.
Note that the input will be generated such that s can always be converted to a palindrome.

Example 1:

Input: s = "aabb"
Output: 2
Explanation:
We can obtain two palindromes from s, "abba" and "baab".
- We can obtain "abba" from s in 2 moves: "aabb" -> "abab" -> "abba".
- We can obtain "baab" from s in 2 moves: "aabb" -> "abab" -> "baab".
Thus, the minimum number of moves needed to make s a palindrome is 2.
Example 2:

Input: s = "letelt"
Output: 2
Explanation:
One of the palindromes we can obtain from s in 2 moves is "lettel".
One of the ways we can obtain it is "letelt" -> "letetl" -> "lettel".
Other palindromes such as "tleelt" can also be obtained in 2 moves.
It can be shown that it is not possible to obtain a palindrome in less than 2 moves.
 */
public class MinimumNumberOfMovesToMakePandrome {

  public static int minMovesToMakePalindrome(String s) {
    char[] chars = s.toCharArray();
    int moves = 0;
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (chars[i] == chars[j]) {
        i++;
        j--;
        continue;
      }
      // looking the symbol in backward
      int matchingIndex = j;
      while ((matchingIndex > i) && chars[i] != chars[matchingIndex]) {
        matchingIndex--;
      }
      if (matchingIndex == i) {
        // chars[i] is the center of the odd-length string.
        // this char should be moved to the center, push it for 1 index forward
        moves++;
        swap(chars, i, i + 1);
      } else {
        for (int l = matchingIndex; l < j; l++) {
          swap(chars, l, l + 1);
          moves++;
        }
        i++;
        j--;
      }
    }
    return moves;
  }

  private static void swap(char[] chars, int i, int j) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
  }

  public static void main(String[] args) {
    //        String s = "skwhhaaunskegmdtutlgtteunmuuludii";
    String s = "caabb";
    System.out.println(minMovesToMakePalindrome(s));
  }
}
