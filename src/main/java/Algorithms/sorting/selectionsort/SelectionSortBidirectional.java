package Algorithms.sorting.selectionsort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class SelectionSortBidirectional {

  private int[] sort(int[] nums) {
    for (int i = 0; i <= (nums.length - 1) / 2; i++) {
      int minPos = i;
      int maxPos = nums.length - 1 - i;
      for (int j = i + 1; j < nums.length - i; j++) {
        if (nums[j] < nums[minPos]) {
          minPos = j;
        }
        if (nums[j] > nums[maxPos]) {
          maxPos = j;
        }
      }
      if (i != minPos) {
        swap(nums, i, minPos);
      }
      if (nums[minPos] > nums[maxPos]) maxPos = minPos;
      if (nums.length - 1 - i != maxPos) {
        swap(nums, nums.length - 1 - i, maxPos);
      }
    }
    return nums;
  }

  private void swap(int[] nums, int i, int j) {
    int buf = nums[i];
    nums[i] = nums[j];
    nums[j] = buf;
  }

  @Test
  void test() {
    assertEquals(
        0, Arrays.compare(new int[] {1, 2, 3, 4, 5, 6, 7}, sort(new int[] {7, 6, 5, 4, 3, 2, 1})));
    assertEquals(
        0, Arrays.compare(new int[] {1, 2, 3, 4, 5, 6}, sort(new int[] {1, 2, 3, 4, 6, 5})));
    assertEquals(
        0, Arrays.compare(new int[] {1, 2, 3, 4, 5, 6}, sort(new int[] {2, 1, 3, 4, 5, 6})));
  }
}
