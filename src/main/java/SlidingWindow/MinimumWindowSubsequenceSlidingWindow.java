package SlidingWindow;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.stream.Stream;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/*
https://leetcode.com/problems/minimum-window-subsequence/

727. Minimum Window Subsequence
Hard
Topics
Companies

Given strings s1 and s2, return the minimum contiguous substring part of s1, so that s2 is a subsequence of the part.

If there is no such window in s1 that covers all characters in s2, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:
Input: s1 = "abcdebdde", s2 = "bde"
Output: "bcde"
Explanation:
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of s2 in the window must occur in order.

Example 2:
Input: s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl", s2 = "u"
Output: ""

Constraints:
1 <= s1.length <= 2 * 104
1 <= s2.length <= 100
s1 and s2 consist of lowercase English letters.
*/
public class MinimumWindowSubsequenceSlidingWindow {

  public String minWindow(String s1, String s2) {
    if (s2.isEmpty()) {
      return "";
    }
    String minimumSubsequence = "";
    var minimumSubsequenceLength = Integer.MAX_VALUE;

    int pos1 = 0;
    int pos2 = 0;
    int wordStart;
    int wordEnd;

    while (pos1 < s1.length()) {
      if (s1.charAt(pos1) == s2.charAt(pos2)) {
        if (pos2 == 0) {
          wordStart = pos1;
        }
        if (pos2 == s2.length() - 1) {
          wordEnd = pos1;
          // backtrack to find the correct wordStart
          while (pos2 >= 0) {
            if (s1.charAt(pos1) == s2.charAt(pos2)) {
              if (pos2 == 0) {
                wordStart = pos1;
                if (wordEnd - wordStart + 1 < minimumSubsequenceLength) {
                  minimumSubsequenceLength = wordEnd - wordStart + 1;
                  minimumSubsequence = s1.substring(wordStart, wordEnd + 1);
                }
                pos1++;
                break;
              }
              pos2--;
            }
            pos1--;
          }
        } else {
          pos1++;
          pos2++;
        }
      } else {
        pos1++;
      }
    }
    return minimumSubsequence;
  }

  @ParameterizedTest
  @MethodSource("testData")
  public void test(String s1, String s2, String expected) {
    assertThat(
        new MinimumWindowSubsequenceSlidingWindow().minWindow(s1, s2), Matchers.is(expected));
  }

  public static Stream<Arguments> testData() {
    return Stream.of(
        Arguments.of("abcdebdde", "bde", "bcde"),
        Arguments.of("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u", ""),
        Arguments.of("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "k", "k"),
        Arguments.of("akakakacd", "kcd", "kacd"),
        Arguments.of("abcdbebe", "bbe", "bebe"));
  }
}
