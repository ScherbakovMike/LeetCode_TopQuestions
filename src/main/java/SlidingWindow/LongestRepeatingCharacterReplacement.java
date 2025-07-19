package SlidingWindow;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/*
https://leetcode.com/problems/longest-repeating-character-replacement/description/

424. Longest Repeating Character Replacement
Medium
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
 */
public class LongestRepeatingCharacterReplacement {

  public int characterReplacement(String s, int k) {
    int start = 0;
    int end = 0;
    int maxLength = 1;
    int mostFreq = 0;
    Map<Character, Integer> charMap = new HashMap<>();
    do {
      // add to the frequency map the character at the "end" position
      charMap.compute(s.charAt(end), (key, value) -> value == null ? 1 : value + 1);
      // calculate the max frequency
      mostFreq = Math.max(mostFreq, charMap.get(s.charAt(end)));
      int windowLen = end - start + 1;
      if (mostFreq + k >= windowLen) {
        maxLength = windowLen;
      } else {
        charMap.compute(s.charAt(start), (key, startFreq) -> startFreq - 1);
        start++;
      }
      end++;
    } while (start < s.length() && end < s.length());

    return maxLength;
  }

  @ParameterizedTest
  @MethodSource("testData")
  public void test(String s, int k, int expected) {
    assertThat(
        new LongestRepeatingCharacterReplacement().characterReplacement(s, k),
        Matchers.is(expected));
  }

  public static Stream<Arguments> testData() {
    return Stream.of(
        Arguments.of("ABAB", 2, 4), Arguments.of("AABABBA", 1, 4), Arguments.of("aaabcda", 2, 5));
  }
}
