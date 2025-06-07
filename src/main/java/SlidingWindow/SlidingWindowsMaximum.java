package SlidingWindow;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.LinkedList;
import java.util.stream.Stream;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/*
https://leetcode.com/problems/sliding-window-maximum/description/

239. Sliding Window Maximum
Hard
Topics
Companies

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
*/
public class SlidingWindowsMaximum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    LinkedList<Integer> dq = new LinkedList<>();
    int[] result = new int[nums.length - k + 1];
    int pos = 0;
    for (int i = 0; i < nums.length; i++) {
      while (!dq.isEmpty() && (nums[dq.peekLast()] < nums[i] || dq.peekLast() <= (i - k))) {
        dq.removeLast();
      }
      dq.offerLast(i);
      if (i >= (k - 1)) {
        while (!dq.isEmpty() && (dq.peekFirst() <= (i - k))) {
          dq.removeFirst();
        }
        result[pos] = nums[dq.peekFirst()];
        pos++;
      }
    }
    return result;
  }

  @ParameterizedTest
  @MethodSource("testData")
  public void test(int[] nums, int k, int[] expected) {
    assertThat(new SlidingWindowsMaximum().maxSlidingWindow(nums, k), Matchers.is(expected));
  }

  public static Stream<Arguments> testData() {
    return Stream.of(
        Arguments.of(
            new int[] {1},
            1,
            new int[] {1},
            new int[] {1, -1},
            1,
            new int[] {1, -1},
            new int[] {1, 3, -1, -3, 5, 3, 6, 7},
            3,
            new int[] {3, 3, 5, 5, 6, 7}));
  }
}
