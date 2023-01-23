package Array.MovingZeroes;

class Solution {
  public void moveZeroes(int[] nums) {
    int nonZeroLength = 0;
    int zeroLength = 0;
    int posZero;
    int posNonZero;
    while ((nonZeroLength + zeroLength) != nums.length) {
      posZero = nonZeroLength;
      do {
        if (nums[posZero] != 0) {
          nonZeroLength++;
          posZero++;
        }
      } while (posZero < (nums.length - zeroLength) && nums[posZero] != 0);

      posNonZero = posZero;

      while (posNonZero < (nums.length - zeroLength) && nums[posNonZero] == 0) {
        posNonZero++;
      }

      if (posNonZero == (nums.length - zeroLength)) {
        break;
      }

      nums[posZero] = nums[posNonZero];
      nums[posNonZero] = 0;
      nonZeroLength = posZero + 1;
    }
  }

  public static void main(String[] args) {
    var test = new int[]{1, 1, 1, 1, 1};
    new Solution().moveZeroes(test);
    for (var i : test) {
      System.out.print(i + " ");
    }
  }
}