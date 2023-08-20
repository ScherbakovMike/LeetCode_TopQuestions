package LinkedInTop;

public class MaximumSubArray {

  public static int maxSubArray(int[] nums) {
    var result = Integer.MIN_VALUE;
    var curSum = 0;
    for(var n: nums) {
      curSum += n;
      if(curSum>result) {
        result = curSum;
      }
      if(curSum<0) {
        curSum = 0;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    var nums = new int[] {-2,1,-3,4,-1,2,1,-5,};
    System.out.println(maxSubArray(nums));
  }
}
