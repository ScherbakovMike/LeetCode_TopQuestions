package LinkedInTop;

public class SearchInRotatedSortedArray {

  public static int search(int[] nums, int target) {
    return searchR(nums, 0, nums.length - 1, false, target);
  }

  private static int searchR(int[] nums, int start, int end, boolean sortedPart, int target) {
    if (start > end || (start == end && nums[start] != target)) {
      return -1;
    }
    if (sortedPart) {
      // sorted part
      var pivot = (start + end) / 2;
      if (nums[pivot] == target) {
        return pivot;
      } else {
        if (target >= nums[start] && target <= nums[pivot]) {
          return searchR(nums, start, pivot, true, target);
        } else {
          return searchR(nums, pivot + 1, end, true, target);
        }
      }
    } else {
      // unknown part
      var delimiter = (start + end) / 2;
      if (nums[delimiter] == target) {
        return delimiter;
      }

      if (nums[start] <= nums[delimiter]) {
        // left is sorted
        if(target >= nums[start] && target <= nums[delimiter]) {
          return searchR(nums, start, delimiter, true, target);
        } else {
          return searchR(nums, delimiter + 1, end, false, target);
        }
      } else {
        // right is sorted
        if(target >= nums[delimiter+1] && target <= nums[end]) {
          return searchR(nums, delimiter+1, end, true, target);
        } else {
          return searchR(nums, start , delimiter, false, target);
        }
      }
    }
  }

  public static void main(String[] args) {
    var nums = new int[]{5, 1, 3};
    System.out.println(search(nums, 4));
  }
}
