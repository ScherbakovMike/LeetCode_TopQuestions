package Array.ContainsDuplicate;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
  public boolean containsDuplicate(int[] nums) {
    return Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .anyMatch(entry -> entry.getValue() > 1);
  }

  public static void main(String[] args) {
    var test = new int[] {1, 2, 3, 4};
    System.out.println(new Solution().containsDuplicate(test));
  }
}
