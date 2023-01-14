package Array.RemoveDuplicatesFromSortedArray;

import java.util.Arrays;

// 1 2 4 4 5 6 7 8 9
class Solution {
  public int removeDuplicates(int[] nums) {
    int posCurrent = 0;
    int posNext = posCurrent + 1;
    int result = 1;
    do {
      while ((posNext < nums.length) && (nums[posCurrent] == nums[posNext])) {
        posNext++;
      }
      if (posNext == nums.length) {
        break;
      }
      nums[result] = nums[posNext];
      result++;
      posCurrent = posNext;
      posNext++;
    } while (posNext < nums.length);
    return result;
  }

  public static void main(String[] args) {
    var test1 = new int[]{1, 1, 1, 2, 3, 3, 4, 4};
    System.out.println(new Solution().removeDuplicates(test1));
  }
}