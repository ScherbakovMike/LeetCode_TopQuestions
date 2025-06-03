package LinkedInTop;

import java.util.Arrays;

public class SortColors {

  public static void sortColors(int[] nums) {
    var pos2 = nums.length - 1;
    var pos0 = 0;
    var i = 0;
    while (i <= pos2) {
      if (nums[i] == 0) {
        swap(nums, pos0, i);
        pos0++;
        i++;
      } else if (nums[i] == 2) {
        swap(nums, pos2, i);
        pos2--;
      } else i++;
    }
  }

  private static void swap(int[] nums, int i1, int i2) {
    var buf = nums[i1];
    nums[i1] = nums[i2];
    nums[i2] = buf;
  }

  public static void main(String[] args) {
    var nums = new int[] {2, 0, 2, 1, 1, 0};
    sortColors(nums);
    System.out.println(Arrays.toString(nums));
  }
}
