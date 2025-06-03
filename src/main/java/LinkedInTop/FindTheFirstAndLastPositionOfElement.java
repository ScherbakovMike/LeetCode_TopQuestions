package LinkedInTop;

import java.util.Arrays;

public class FindTheFirstAndLastPositionOfElement {
  public static int[] searchRange(int[] nums, int target) {
    if (nums.length < 1) {
      return new int[] {-1, -1};
    }
    if (nums[0] == target && nums[nums.length - 1] == target) {
      return new int[] {0, nums.length - 1};
    }
    return searchRangeR(nums, target, 0, nums.length - 1, -1, -1);
  }

  private static int[] searchRangeR(
      int[] nums, int target, int begin, int end, int leftPosition, int rightPosition) {
    if ((end - begin) < 2) {
      if (nums[begin] == target) {
        leftPosition = begin;
      }
      if (nums[end] == target) {
        rightPosition = end;
      }

      if (leftPosition == -1 && rightPosition != -1) {
        leftPosition = rightPosition;
      }
      if (rightPosition == -1 && leftPosition != -1) {
        rightPosition = leftPosition;
      }
      return new int[] {leftPosition, rightPosition};
    }
    int pivot = (end + begin) / 2;
    if (nums[pivot] < target) { // left part is pointless
      return searchRangeR(nums, target, pivot, nums.length - 1, leftPosition, rightPosition);
    }
    if (target < nums[pivot]) { // right part is pointless
      return searchRangeR(nums, target, begin, pivot, leftPosition, rightPosition);
    }
    if (nums[pivot] == target) {
      if (pivot == begin) {
        leftPosition = pivot;
      }
      if ((pivot - 1) >= begin && nums[pivot - 1] != target) {
        leftPosition = pivot;
      }
      if ((pivot - 1) == begin && nums[pivot - 1] == target) {
        leftPosition = pivot - 1;
      }
      if (leftPosition == -1) {
        leftPosition = searchRangeR(nums, target, begin, pivot, leftPosition, pivot)[0];
      }

      if (pivot == end) {
        rightPosition = pivot;
      }
      if ((pivot + 1) <= end && nums[pivot + 1] != target) {
        rightPosition = pivot;
      }
      if ((pivot + 1) == end && nums[pivot + 1] == target) {
        rightPosition = pivot + 1;
      }
      if (rightPosition == -1) {
        rightPosition = searchRangeR(nums, target, pivot, end, pivot, rightPosition)[1];
      }
    }
    if (leftPosition == -1 && rightPosition != -1) {
      leftPosition = rightPosition;
    }
    if (rightPosition == -1 && leftPosition != -1) {
      rightPosition = leftPosition;
    }
    return new int[] {leftPosition, rightPosition};
  }

  public static void main(String[] args) {
    // var nums = new int[]{1,3};
    var nums = new int[] {0, 1, 2, 3, 4, 4, 4};
    // var nums = new int[]{};
    System.out.println(Arrays.toString(searchRange(nums, 2)));
  }
}
