package Dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ThreeSumDictionary {

  public List<List<Integer>> threeSum(int[] nums) {

    var result = new ArrayList<List<Integer>>();
    Arrays.sort(nums);

    int i = 0;
    while (i < nums.length - 2 && nums[i] <= 0) {
      var seen = new HashSet<Integer>();
      int j = i + 1;
      while (j < nums.length) {
        // current element is too big
        if (j > i + 2 && nums[i] + nums[i + 1] + nums[j] > 0) {
          break;
        }
        // pivot is too low
        if (nums.length - i >= 3 && nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
          break;
        }
        var complement = -nums[i] - nums[j];
        if (seen.contains(complement)) {
          result.add(List.of(nums[i], nums[j], complement));
          // shift right to prevent duplicates
          while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
            j++;
          }
        }
        seen.add(nums[j]);
        j++;
      }
      // shift right to prevent duplicates
      while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        i++;
      }
      i++;
    }
    return result;
  }

  @Test
  void test() {
    assertEquals(List.of(List.of(0, 0, 0)), new ThreeSumDictionary().threeSum(new int[] {0, 0, 0}));
    assertEquals(
        List.of(
            List.of(-10, 5, 5),
            List.of(-5, 5, 0),
            List.of(-4, 2, 2),
            List.of(-3, 2, 1),
            List.of(-3, 5, -2),
            List.of(-2, 2, 0)),
        new ThreeSumDictionary()
            .threeSum(new int[] {2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10}));
    assertEquals(
        List.of(List.of(-1, 1, 0), List.of(-1, 2, -1)),
        new ThreeSumDictionary().threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
  }
}
