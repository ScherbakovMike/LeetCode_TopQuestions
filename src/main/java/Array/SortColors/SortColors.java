package Array.SortColors;

import java.util.*;

/*
75. Sort Colors
https://leetcode.com/problems/sort-colors/description/

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class SortColors {

    public static int[] sortColors(int[] colors) {
        var pos0 = 0;
        var pos2 = colors.length - 1;
        // Write your code here
        for (var i = 0; i < colors.length; i++) {
            if (colors[i] == 0 && i > pos0) {
                colors[i] = colors[pos0];
                colors[pos0] = 0;
                pos0++;
            }
            if (colors[i] == 2 && i < pos2) {
                colors[i] = colors[pos2];
                colors[pos2] = 2;
                pos2--;
            }
        }
        return colors;
    }

    public static void main(String[] args) {
        var colors = new int[]{2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(sortColors(colors)));
    }
}
