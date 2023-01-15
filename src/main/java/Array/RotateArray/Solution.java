package Array.RotateArray;

class Solution {
  public void rotate(int[] nums, int k) {
    int cycles = k % nums.length;
    int[] newLeftPart = new int[cycles];
    int j = 0;
    for (int i = nums.length - 1; i > (nums.length - 1 - cycles); i--) {
      newLeftPart[newLeftPart.length - 1 - j] = nums[i];
      j++;
    }
    for (int i = 0; i < (nums.length - cycles); i++) {
      nums[nums.length - 1 - i] = nums[nums.length - cycles - 1 - i];
    }
    for (int i = 0; i < cycles; i++) {
      nums[i] = newLeftPart[i];
    }
  }

  public static void main(String[] args) {
    //var test = new int[]{-1, -100, 3, 99};
    var test = new int[]{1, 2, 3, 4, 5, 6, 7};
    new Solution().rotate(test, 3);
    for (int i : test) {
      System.out.println(String.valueOf(i) + ", ");
    }
  }
}