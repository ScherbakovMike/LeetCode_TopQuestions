package LinkedInTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class KthLargestElementInAnArrayQuickSelect {
  private static final Random random = new Random();

  public static int findKthLargest(int[] nums, int k) {
    var list = IntStream.of(nums).boxed().toList();
    return quickSelect(list, k);
  }

  private static int quickSelect(List<Integer> nums, int k) {
    var pivot = random.nextInt(nums.size());
    var listLess = new ArrayList<Integer>();
    var listEqual = new ArrayList<Integer>();
    var listGreater = new ArrayList<Integer>();
    for (var n : nums) {
      if (n < nums.get(pivot)) {
        listLess.add(n);
      } else if (n > nums.get(pivot)) {
        listGreater.add(n);
      } else listEqual.add(n);
    }

    if (listGreater.size() >= k) {
      return quickSelect(listGreater, k);
    }
    if ((listGreater.size() + listEqual.size()) < k) {
      return quickSelect(listLess, k - listGreater.size() - listEqual.size());
    }
    return nums.get(pivot);
  }

  public static void main(String[] args) {
    var nums = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
    System.out.println(findKthLargest(nums, 4));
  }
}
