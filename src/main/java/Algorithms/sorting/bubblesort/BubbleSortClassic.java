package Algorithms.sorting.bubblesort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BubbleSortClassic {

  public int[] sort(int[] nums) {
    var iterations = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; j < nums.length - 1 - i; j++) {
        iterations++;
        if (nums[j] > nums[j + 1]) {
          swap(nums, j, j + 1);
        }
      }
    }
    System.out.printf("Iterations completed: %d%n", iterations);
    return nums;
  }

  private void swap(int[] nums, int i, int j) {
    int buf = nums[i];
    nums[i] = nums[j];
    nums[j] = buf;
  }

  @Test
  void test() {
    assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6}, sort(new int[]{6, 5, 4, 3, 2, 1})));
    assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6}, sort(new int[]{1, 2, 3, 4, 6, 5})));
    assertEquals(0, Arrays.compare(new int[]{1, 2, 3, 4, 5, 6}, sort(new int[]{2, 1, 3, 4, 5, 6})));
  }
}
