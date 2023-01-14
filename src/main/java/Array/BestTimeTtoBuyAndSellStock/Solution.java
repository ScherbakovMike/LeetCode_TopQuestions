package Array.BestTimeTtoBuyAndSellStock;

class Solution {
  public int maxProfit(int[] prices) {
    int profit = 0;
    int left = 0;
    int right = left + 1;
    do {
      while ((left+1) < prices.length && prices[left] >= prices[left + 1]) {
        left++;
        right++;
      }
      if (left == prices.length) {
        break;
      }

      while (right < prices.length && prices[right - 1] <= prices[right]) {
        right++;
      }

      profit += (prices[right - 1] - prices[left]);

      left = right - 1;
      right = left + 1;
    } while (right < prices.length);

    return profit;
  }

  public static void main(String[] args) {
    var test = new int[]{10, 3, 3, 4, 5, 6};
    System.out.println(new Solution().maxProfit(test));
  }
}