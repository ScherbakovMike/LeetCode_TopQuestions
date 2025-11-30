package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumTwoPointers {
  public static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(nums);
    int low;
    int high;
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] > 0) break;
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      low = i + 1;
      high = nums.length - 1;
      while (low < high) {
        int sum = nums[low] + nums[high];
        if ((sum + nums[i]) > 0) {
          high--;
          continue;
        }
        if ((sum + nums[i]) < 0) {
          low++;
          continue;
        }
        if ((sum + nums[i]) == 0) {
          result.add(List.of(nums[i], nums[low], nums[high]));
          do low++;
          while (low < high && nums[low] == nums[low - 1]);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10};
    System.out.println(threeSum(nums));
  }
}
