package LinkedInTop;

import java.util.Arrays;

public class MergeSortedArray {
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int pos = nums1.length - 1;
    while (pos >= 0) {
      if (i >= 0 && j >= 0 && nums1[i] >= nums2[j]) {
        nums1[pos] = nums1[i];
        i--;
      } else if (j >= 0) {
        nums1[pos] = nums2[j];
        j--;
      }
      pos--;
    }
  }

  public static void main(String[] args) {
    var nums1 = new int[] {1};
    var nums2 = new int[] {};
    merge(nums1, 1, nums2, 0);

    System.out.println(Arrays.toString(nums1));
  }
}
