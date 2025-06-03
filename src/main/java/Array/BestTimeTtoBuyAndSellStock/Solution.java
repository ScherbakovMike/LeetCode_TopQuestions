package Array.BestTimeTtoBuyAndSellStock;

class Solution {

  public int maxProfit(int[] prices) {
    var minPrice = Integer.MAX_VALUE;
    var maxProfit = 0;
    for (var price : prices) {
      if (price < minPrice) {
        minPrice = price;
      }
      if (price - minPrice > maxProfit) {
        maxProfit = price - minPrice;
      }
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    var test = new int[] {10, 3, 5, 10, 0, 200, 1};
    System.out.println(new Solution().maxProfit(test));
  }
}
