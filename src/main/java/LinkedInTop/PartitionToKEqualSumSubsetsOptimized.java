package LinkedInTop;

import java.util.Arrays;
import java.util.Comparator;

public class PartitionToKEqualSumSubsetsOptimized {

  public boolean canPartitionKSubsets(int[] nums, int k) {
    var totalSum = Arrays.stream(nums).sum();
    if (totalSum % k != 0) {
      return false;
    }
    var desiredSum = totalSum / k;
    nums =
        Arrays.stream(nums)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(item -> item)
            .toArray();
    if (nums[nums.length - 1] > desiredSum) {
      return false;
    }
    var taken = new boolean[nums.length];
    return backtrack(nums, 0, 0, 0, k, desiredSum, taken);
  }

  private boolean backtrack(
      int[] nums, int index, int count, int curSum, int k, int targetSum, boolean[] taken) {

    var n = nums.length;
    if (count == k - 1) {
      return true;
    }
    if (curSum > targetSum) {
      return false;
    }
    if (curSum == targetSum) {
      return backtrack(nums, 0, count + 1, 0, k, targetSum, taken);
    }

    for (var j = index; j < n; j++) {
      if (!taken[j]) {
        taken[j] = true;
        if (backtrack(nums, j + 1, count, curSum + nums[j], k, targetSum, taken)) {
          return true;
        }
        taken[j] = false;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(
        new PartitionToKEqualSumSubsetsOptimized()
                .canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4)
            == true);
    System.out.println(
        new PartitionToKEqualSumSubsetsOptimized().canPartitionKSubsets(new int[] {1, 2, 3, 4}, 3)
            == false);
  }
}
