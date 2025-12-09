package Algorithms.sorting.bubblesort;

import static CommonAlgorithms.Util.swap;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BubbleSortTrackLastSwapPosition {

  public int[] sort(int[] nums) {
    var iterations = 0;
    int lastSwapPosition = nums.length - 1;
    while (lastSwapPosition > 0) {
      int n = lastSwapPosition;
      for (int j = 0; j < n; j++) {
        iterations++;
        if (nums[j] > nums[j + 1]) {
          swap(nums, j, j + 1);
          lastSwapPosition = j;
        }
      }
      if (lastSwapPosition == n) {
        break;
      }
    }
    System.out.printf("Iterations completed: %d%n", iterations);
    return nums;
  }

  @Test
  void test() {
    assertEquals(
        0, Arrays.compare(new int[] {1, 2, 3, 4, 5, 6}, sort(new int[] {6, 5, 4, 3, 2, 1})));
    assertEquals(
        0, Arrays.compare(new int[] {1, 2, 3, 4, 5, 6}, sort(new int[] {1, 2, 3, 4, 6, 5})));
    assertEquals(
        0, Arrays.compare(new int[] {1, 2, 3, 4, 5, 6}, sort(new int[] {2, 1, 3, 4, 5, 6})));
  }
}
