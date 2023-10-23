package LinkedInTop;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;

public class PartitionToKEqualSumSubsets {

  public boolean canPartitionKSubsets(int[] nums, int k) {
    var totalSum = Arrays.stream(nums).sum();
    if (totalSum % k != 0) {
      return false;
    }
    var desiredSum = totalSum / k;
    Arrays.sort(nums);
    if (nums[nums.length - 1] > desiredSum) {
      return false;
    }
    var taken = new BitSet(nums.length);
    var failedMasks = new HashSet<BitSet>();
    return backtrack(nums, 0, desiredSum, 0, k, taken, failedMasks, nums.length - 1);
  }

  private boolean backtrack(int[] nums, int groups, int desiredSum, int curSum, int k, BitSet taken, HashSet<BitSet> failedMasks, int curIndex) {
    if (groups == (k - 1)) {
      return true;
    }

    for (var i = curIndex; i >= 0; i--) {
      if (taken.get(i)) {
        continue;
      }
      var newSum = curSum + nums[i];
      if (newSum <= desiredSum) {
        taken.set(i);
        curSum = newSum;
        break;
      }
    }
    var recursiveResult = false;
    if (curSum == desiredSum) {
      recursiveResult = backtrack(nums, groups + 1, desiredSum, 0, k, taken, failedMasks, curIndex - 1);
    } else {
      recursiveResult = backtrack(nums, groups, desiredSum, curSum, k, taken, failedMasks, curIndex - 1);
    }
    return recursiveResult;
  }

  public static void main(String[] args) {
    System.out.println(
      new PartitionToKEqualSumSubsets().canPartitionKSubsets(
        new int[]{4, 3, 2, 3, 5, 2, 1},
        4)
    );
//    System.out.println(
//      new PartitionToKEqualSumSubsets().canPartitionKSubsets(
//        new int[]{1, 2, 3, 4},
//        3)
//    );
  }
}
