package LinkedInTop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKPairsWithSmallestSums {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int m = nums1.length;
    int n = nums2.length;

    List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> visited = new HashSet<>();

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
    minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
    visited.add(List.of(0, 0));

    while (k-- > 0 && !minHeap.isEmpty()) {
      int[] top = minHeap.poll();
      int i = top[1];
      int j = top[2];

      ans.add(List.of(nums1[i], nums2[j]));

      if (i + 1 < m && !visited.contains(List.of(i + 1, j))) {
        minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
        visited.add(List.of(i + 1, j));
      }

      if (j + 1 < n && !visited.contains(List.of(i, j + 1))) {
        minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
        visited.add(List.of(i, j + 1));
      }
    }
    return ans;
  }

  public static void main(String[] args) {
//    var num1 = new int[]{1, 7, 11};
//    var num2 = new int[]{2, 4, 6};
//    System.out.println(new FindKPairsWithSmallestSumsPriorityQueue().kSmallestPairs(num1, num2, 3));
//    var num1 = new int[]{1, 1, 2};
//    var num2 = new int[]{1, 2, 3};
//    System.out.println(new FindKPairsWithSmallestSumsPriorityQueue().kSmallestPairs(num1, num2, 2));
//    var num1 = new int[]{1, 2};
//    var num2 = new int[]{3};
//    System.out.println(new FindKPairsWithSmallestSumsPriorityQueue().kSmallestPairs(num1, num2, 3));
//    var num1 = new int[]{1, 1, 2};
//    var num2 = new int[]{1, 2, 3};
//    System.out.println(new FindKPairsWithSmallestSumsPriorityQueue().kSmallestPairs(num1, num2, 10));
    var num1 = new int[]{1, 1, 2};
    var num2 = new int[]{10, 20, 30};
    System.out.println(new FindKPairsWithSmallestSums().kSmallestPairs(num1, num2, 10));
  }
}
