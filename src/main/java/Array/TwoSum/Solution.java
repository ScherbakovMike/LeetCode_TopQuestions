package Array.TwoSum;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        var nums = new int[]{-3, 4, 3, 90};
        var target = 0;
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));
    }
}
