package Array.IntersectionOfTwoArrays;

import java.util.stream.IntStream;

public class Solution {
  public static void main(String[] args) {
    var test1 = new int[]{3, 1, 2};
    var test2 = new int[]{1, 1};
    var result = new Solution().intersect(test1, test2);
    for (var elem : result) {
      System.out.print(elem + " ");
    }
  }

  public int[] intersect(int[] nums1, int[] nums2) {
    int[] minMas;
    int[] maxMas;
    if (nums1.length <= nums2.length) {
      minMas = nums1;
      maxMas = nums2;
    } else {
      minMas = nums2;
      maxMas = nums1;
    }
    for (int i = 0; i < minMas.length; i++) {
      int pos = 0;
      while (pos < maxMas.length
          && maxMas[pos] != minMas[i]) {
        pos++;
      }
      if (pos == maxMas.length) {
        minMas[i] = Integer.MAX_VALUE;
      } else {
        maxMas[pos] = Integer.MAX_VALUE;
      }
    }
    return IntStream.of(minMas).filter(value -> value != Integer.MAX_VALUE).toArray();
  }
}
