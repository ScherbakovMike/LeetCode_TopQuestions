package LinkedInTop;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

  public static int findKthLargest(int[] nums, int k) {
    var queue = new PriorityQueue<Integer>();
    for (var n : nums) {
      queue.add(n);
      if (queue.size() > k) {
        queue.poll();
      }
    }
    return queue.poll();
  }

  public static void main(String[] args) {
    var nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
    System.out.println(findKthLargest(nums, 4));
  }
}
