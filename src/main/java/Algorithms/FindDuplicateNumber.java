package Algorithms;

/*
https://leetcode.com/problems/find-the-duplicate-number

287. Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3

Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n

All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
public class FindDuplicateNumber {

  // Negative Marking
  // Time complexity: O(n)
  // Space complexity: O(1)
  //    public int findDuplicate(int[] nums) {
  //        // negative marking algorithm
  //        // applicable only if nums values fit to the array indexes
  //        // and all elements have the same sign.
  //        for (int i = 0; i < nums.length; i++) {
  //            int markPos = Math.abs(nums[i]);
  //            if (nums[markPos] < 0) return Math.abs(nums[i]);
  //            nums[markPos] *= -1;
  //        }
  //        return -1;
  //    }

  // Array as HashMap (recursive)
  // Time complexity: O(n)
  // Space complexity: O(n)
  //    public int findDuplicate(int[] nums) {
  //        return store(nums, 0);
  //    }
  //
  //    private int store(int[] nums, int pos) {
  //        int correspondingIndex = nums[pos];
  //        int numAtCorrespondingIndex = nums[correspondingIndex];
  //        if(correspondingIndex==numAtCorrespondingIndex) return correspondingIndex;
  //        nums[correspondingIndex] = correspondingIndex;
  //        return store(nums, numAtCorrespondingIndex);
  //    }

  // Array as Hashmap (iterative)
  // Time complexity: O(n)
  // Space complexity: O(1)
  //    public int findDuplicate(int[] nums) {
  //        int pos = 1;
  //        do {
  //            if (nums[pos] == nums[0]) return nums[0];
  //            int buf = nums[nums[pos]];
  //            nums[nums[pos]] = nums[pos];
  //            nums[0] = buf;
  //            pos++;
  //        } while (pos < nums.length);
  //        return -1;
  //    }

  // Array as HashMap
  // binary search
  // Time complexity: O(n log n)
  // Space complexity: O(1)
  //    public int findDuplicate(int[] nums) {
  //        int low = 1;
  //        int high = nums.length - 1;
  //        int count = 0;
  //        int pivot = (high + low) / 2;
  //        while (low != high) {
  //            for (int num : nums) {
  //                if (num <= pivot) count++;
  //            }
  //            if (count <= pivot) {
  //                // look in the right part: pivot+1...high
  //                low = pivot + 1;
  //            } else {
  //                // look in the left part: low...pivot
  //                high = pivot;
  //            }
  //            pivot = (high + low) / 2;
  //            count = 0;
  //        }
  //        return pivot;
  //    }

  // Floyd algorithm
  // TC: O(n)
  // SC: O(1)
  public static int findDuplicate(int[] nums) {
    // Floyd algorithm
    int slow = nums[0];
    int fast = nums[0];
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);
    fast = nums[0];
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }

  public static void main(String[] args) {
    System.out.println(new FindDuplicateNumber().findDuplicate(new int[] {3, 4, 4, 4, 2}));
  }
}
