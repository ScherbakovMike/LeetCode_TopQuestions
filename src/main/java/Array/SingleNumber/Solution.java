package Array.SingleNumber;

class Solution {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result = result ^ num;
    }
    return result;
  }

  public static void main(String[] args) {
    var test1 = new int[]{1, 2, 1, 2, 3};
    var test2 = new int[]{2, 2, 1};
    var test3 = new int[]{4, 4, 6};

    System.out.println(new Solution().singleNumber(test1));
    System.out.println(new Solution().singleNumber(test2));
    System.out.println(new Solution().singleNumber(test3));
  }
}
