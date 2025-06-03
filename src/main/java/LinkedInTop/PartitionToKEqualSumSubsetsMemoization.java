package LinkedInTop;

import java.util.*;

public class PartitionToKEqualSumSubsetsMemoization {

  public boolean canPartitionKSubsets(int[] nums, int k) {
    var totalSum = Arrays.stream(nums).sum();
    if (totalSum % k != 0) {
      return false;
    }
    var desiredSum = totalSum / k;
    sortReversed(nums);
    if (nums[nums.length - 1] > desiredSum) {
      return false;
    }
    var mask = new BitSet(nums.length);
    return backtrack(nums, 0, 0, 0, k, desiredSum, mask, new HashMap<>());
  }

  private void sortReversed(int[] nums) {
    Arrays.sort(nums);
    for (var i = 0; i < nums.length / 2; i++) {
      var buf = nums[i];
      nums[i] = nums[nums.length - 1 - i];
      nums[nums.length - 1 - i] = buf;
    }
  }

  private boolean backtrack(
      int[] nums,
      int index,
      int count,
      int curSum,
      int k,
      int targetSum,
      BitSet mask,
      Map<BitSet, Boolean> cache) {

    var n = nums.length;
    if (count == k - 1) {
      return true;
    }
    if (curSum > targetSum) {
      return false;
    }
    if (cache.containsKey(mask)) {
      return cache.get(mask);
    }
    if (curSum == targetSum) {
      var result = backtrack(nums, 0, count + 1, 0, k, targetSum, mask, cache);
      cache.put(mask, result);
      return result;
    }

    for (var j = index; j < n; j++) {
      if (!mask.get(j)) {
        mask.set(j);
        if (backtrack(nums, j + 1, count, curSum + nums[j], k, targetSum, mask, cache)) {
          return true;
        }
        mask.clear(j);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(
        new PartitionToKEqualSumSubsetsMemoization()
                .canPartitionKSubsets(new int[] {4, 3, 2, 3, 5, 2, 1}, 4)
            == true);
    System.out.println(
        new PartitionToKEqualSumSubsetsMemoization().canPartitionKSubsets(new int[] {1, 2, 3, 4}, 3)
            == false);
  }
}
