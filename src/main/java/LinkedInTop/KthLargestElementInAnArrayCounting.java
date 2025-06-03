package LinkedInTop;

public class KthLargestElementInAnArrayCounting {

  public static int findKthLargest(int[] nums, int k) {
    var min = Integer.MAX_VALUE;
    var max = Integer.MIN_VALUE;
    for (var n : nums) {
      min = Math.min(min, n);
      max = Math.max(max, n);
    }
    var frequencies = new int[max - min + 1];
    for (var n : nums) {
      frequencies[n - min]++;
    }
    var pos = 0;
    var i = frequencies.length - 1;
    while (pos < k) {
      pos += frequencies[i];
      i--;
    }
    return i + 1 + min;
  }

  public static void main(String[] args) {
    // var nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
    // System.out.println(findKthLargest(nums, 4));
    var nums = new int[] {3, 2, 1, 5, 6, 4};
    System.out.println(findKthLargest(nums, 2));
  }
}
