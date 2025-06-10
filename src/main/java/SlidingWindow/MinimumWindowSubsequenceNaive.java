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
public class MinimumWindowSubsequenceNaive {

  public String minWindow(String s1, String s2) {
    if (s2.isEmpty()) {
      return "";
    }
    var pos1 = s1.indexOf(s2.charAt(0));
    if (s2.length() == 1) {
      if (pos1 == -1) {
        return "";
      }
      return s1.substring(pos1, pos1 + 1);
    }
    var minimumSubsequence = "";
    var minimumSubsequenceLength = Integer.MAX_VALUE;
    while (pos1 != -1) {
      var posChars2 = 1;
      var pos2 = s1.indexOf(s2.charAt(posChars2), pos1 + 1);
      posChars2++;
      while (pos2 != -1 && posChars2 < s2.length()) {
        pos2 = s1.indexOf(s2.charAt(posChars2), pos2 + 1);
        posChars2++;
      }
      if (pos2 != -1) {
        var subsequenceLength = pos2 - pos1 + 1;
        if (subsequenceLength < minimumSubsequenceLength) {
          minimumSubsequence = s1.substring(pos1, pos2 + 1);
          minimumSubsequenceLength = subsequenceLength;
        }
      }
      pos1 = s1.indexOf(s2.charAt(0), pos1 + 1);
    }
    return minimumSubsequence;
  }

  @ParameterizedTest
  @MethodSource("testData")
  public void test(String s1, String s2, String expected) {
    assertThat(new MinimumWindowSubsequenceNaive().minWindow(s1, s2), Matchers.is(expected));
  }

  public static Stream<Arguments> testData() {
    return Stream.of(
        //        Arguments.of("abcdebdde", "bde", "bcde"),
        //        Arguments.of("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u", ""),
        Arguments.of("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "k", "k"));
  }
}
