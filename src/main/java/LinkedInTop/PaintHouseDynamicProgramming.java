package LinkedInTop;

public class PaintHouseDynamicProgramming {

  public int minCost(int[][] costs) {
    for (var i = 1; i < costs.length; i++) {
      var curRow = costs[i];
      var predRow = costs[i - 1];
      curRow[0] = curRow[0] + Math.min(predRow[1], predRow[2]);
      curRow[1] = curRow[1] + Math.min(predRow[0], predRow[2]);
      curRow[2] = curRow[2] + Math.min(predRow[0], predRow[1]);
    }
    return Math.min(
        Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]),
        costs[costs.length - 1][2]);
  }

  public static void main(String[] args) {
    var costs = new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
    System.out.println(new PaintHouseDynamicProgramming().minCost(costs));
  }
}
