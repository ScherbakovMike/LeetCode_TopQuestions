package Algorithms.sorting.selectionsort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class SelectionSortClassic {

  private int[] sort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      int minPos = i;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[i]) {
          minPos = j;
        }
      }
      if (i != minPos) {
        swap(nums, i, minPos);
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
        0, Arrays.compare(new int[] {1, 2, 3, 4, 5, 6}, sort(new int[] {6, 5, 4, 3, 2, 1})));
    assertEquals(
        0, Arrays.compare(new int[] {1, 2, 3, 4, 5, 6}, sort(new int[] {1, 2, 3, 4, 6, 5})));
    assertEquals(
        0, Arrays.compare(new int[] {1, 2, 3, 4, 5, 6}, sort(new int[] {2, 1, 3, 4, 5, 6})));
  }
}
