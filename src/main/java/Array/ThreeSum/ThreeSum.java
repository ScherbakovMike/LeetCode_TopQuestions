package Array.ThreeSum;

import java.util.*;

/*
15. 3Sum
https://leetcode.com/problems/3sum/

Medium
Topics
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class ThreeSum {

  public static void main(String[] args) {
    var nums = new int[] {-1, 0, 1, 2, -1, -4};
    Arrays.sort(nums);
    System.out.println(threeSum(nums));
  }

  private static List<List<Integer>> threeSum(int[] nums) {
    var result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) {
        return result;
      }
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      var left = i + 1;
      var right = nums.length - 1;
      while (left < right && ((nums[i] + nums[left]) <= nums[right])) {
        if (nums[i] + nums[left] + nums[right] == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
        }
        left++;
        right--;
      }
    }
    return result;
  }
}
