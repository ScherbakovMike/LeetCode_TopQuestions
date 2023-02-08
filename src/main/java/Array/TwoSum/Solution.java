package Array.TwoSum;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    var origNums = Arrays.copyOf(nums, nums.length);
    Arrays.sort(nums);
    int maxSearchLimit = nums.length;
    int left = 0;
    while (left < (maxSearchLimit - 1)) {
      int right = left + 1;
      while (right < maxSearchLimit
          && (target != (nums[left] + nums[right]))
          && (target >= (nums[left] + nums[right]))
      ) {
        right++;
      }
      if ((right < maxSearchLimit) && (target == (nums[left] + nums[right]))) {
        int finalLeft = left;
        int origLeft = IntStream.range(0, origNums.length).filter(pos -> origNums[pos] == nums[finalLeft]).findFirst().getAsInt();
        int finalRight = right;
        int origRight = IntStream.range(0, origNums.length).filter(pos -> (origNums[pos] == nums[finalRight]) && (pos != origLeft)).findFirst().getAsInt();

        return new int[]{origLeft, origRight};
      }
      left++;
    }
    throw new IllegalArgumentException();
  }

  public static void main(String[] args) {
    var nums = new int[]{-3, 4, 3, 90};
    var target = 0;
    System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
  }
}
