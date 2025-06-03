package TwoPointers;

import java.util.*;

public class NextPalindromePermutation {
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    int j = nums.length - 1;
    if (i >= 0) {
      // place at the ith position the next number
      while (j >= 0 && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    int k = i + 1;
    int l = nums.length - 1;
    while (k < l) {
      swap(nums, k, l);
      k++;
      l--;
    }
  }

  void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    var nums =
        new int[] {
          3, 2, 20, 16, 1, 15, 15, 14, 27, 26, 5, 16, 9, 13, 17, 24, 15, 12, 15, 14, 27, 14, 14, 3,
          20, 7, 18, 6, 8, 8, 24, 3, 11, 14, 19, 12, 0, 26, 18, 19, 22, 16, 6, 24, 29, 15, 10, 14,
          28, 17, 21, 17, 2, 27, 12, 22
        };
    new NextPalindromePermutation().nextPermutation(nums);
    System.out.printf("nums=" + Arrays.toString(nums));
  }
}
