package CommonAlgorithms;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {

  public static void swap(int[] nums, int i, int j) {
    var temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static int[] merge(int[] left, int[] right) {
    int[] result = new int[left.length + right.length];
    int i = 0;
    int j = 0;
    int k = 0;
    while (j < left.length || k < right.length) {
      if (j == left.length || (k < right.length && left[j] > right[k])) {
        result[i] = right[k];
        k++;
      } else {
        result[i] = left[j];
        j++;
      }
      i++;
    }
    return result;
  }
}
