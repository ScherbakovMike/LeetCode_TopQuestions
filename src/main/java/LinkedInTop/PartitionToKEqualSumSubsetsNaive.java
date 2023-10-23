package LinkedInTop;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

public class PartitionToKEqualSumSubsetsNaive {

  public boolean canPartitionKSubsets(int[] nums, int k) {
    var totalSum = Arrays.stream(nums).sum();
    if (totalSum % k != 0) {
      return false;
    }
    var desiredSum = totalSum / k;
    if (nums[nums.length - 1] > desiredSum) {
      return false;
    }
    var taken = new boolean[nums.length];
    return backtrack(nums, 0, 0, k, desiredSum, taken);
  }

  private boolean backtrack(int[] nums, int count, int curSum, int k, int targetSum,
      boolean[] taken) {

    var n = nums.length;
    if (count == k - 1) {
      return true;
    }
    if (curSum > targetSum) {
      return false;
    }
    if (curSum == targetSum) {
      return backtrack(nums, count + 1, 0, k, targetSum, taken);
    }

    for (var j = 0; j < n; j++) {
      if (!taken[j]) {
        taken[j] = true;
        if (backtrack(nums, count, curSum + nums[j], k, targetSum, taken)) {
          return true;
        }
        taken[j] = false;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(new PartitionToKEqualSumSubsetsNaive().canPartitionKSubsets(
        new int[]{4, 3, 2, 3, 5, 2, 1},
        4) == true);
    System.out.println(new PartitionToKEqualSumSubsetsNaive().canPartitionKSubsets(
        new int[]{1, 2, 3, 4},
        3) == false);
  }
}
