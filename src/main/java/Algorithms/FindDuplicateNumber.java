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
    public int findDuplicate(int[] nums) {
        // negative marking algorithm
        // applicable only if nums values fit to the array indexes
        // and all elements have the same sign.
        for (int i = 0; i < nums.length; i++) {
            int markPos = Math.abs(nums[i]);
            if (nums[markPos] < 0) return Math.abs(nums[i]);
            nums[markPos] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicateNumber().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
