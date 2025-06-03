package Array;

public class SearchInRotatedSortedArrayII {

  public boolean search(int[] nums, int target) {
    return searchR(nums, 0, nums.length - 1, target);
  }

  private boolean searchR(int[] nums, int start, int end, int target) {
    if (nums.length == 0) {
      return false;
    }
    if (start == end) {
      return nums[start] == target;
    }
    if (end == start + 1) {
      return nums[start] == target || nums[end] == target;
    }
    var pivot = (end + start) / 2;
    if (nums[pivot] == target) {
      return true;
    }
    if ((end - start + 1) < 2) {
      return false;
    }
    var pivotElement = nums[pivot];
    var searchInLeft = false;
    var searchInRight = false;
    var leftIsSorted = nums[0] < pivotElement;
    var rightIsSorted = pivotElement < nums[nums.length - 1];
    var leftStart = start;
    var leftEnd = pivot - 1;
    var rightStart = pivot;
    var rightEnd = end;
    if (leftIsSorted) {
      if (target >= nums[leftStart] && target <= nums[leftEnd]) {
        searchInLeft = true;
      } else {
        searchInRight = true;
      }
    } else {
      if (rightIsSorted) {
        if (target >= nums[rightStart] && target <= nums[rightEnd]) {
          searchInRight = true;
        } else {
          searchInLeft = true;
        }
      }
    }
    if (searchInLeft) {
      return searchR(nums, leftStart, leftEnd, target);
    } else if (searchInRight) {
      return searchR(nums, rightStart, rightEnd, target);
    } else {
      return searchR(nums, leftStart, leftEnd, target)
          || searchR(nums, rightStart, rightEnd, target);
    }
  }

  public static void main(String[] args) {
    var nums = new int[] {0};
    var target = 0;
    System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));
  }
}
