package LinkedInTop;

import java.util.HashMap;
import java.util.Map;

public class PaintHouseMemoization {
  private int[][] costs;
  private final Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();

  public int minCost(int[][] costs) {
    this.costs = costs;
    return Math.min(Math.min(costN(0, 0), costN(1, 0)), costN(2, 0));
  }

  private int costN(int color, int house) {
    if (cache.containsKey(house) && cache.get(house).containsKey(color)) {
      return cache.get(house).get(color);
    }
    var houses = costs.length;
    var curCost = costs[house][color];
    if (house == (houses - 1)) {
      return curCost;
    } else {
      var nextCost =
          switch (color) {
            case 0 -> Math.min(costN(1, house + 1), costN(2, house + 1));
            case 1 -> Math.min(costN(0, house + 1), costN(2, house + 1));
            case 2 -> Math.min(costN(0, house + 1), costN(1, house + 1));
            default -> throw new IllegalStateException("Unexpected value: " + color);
          };
      var totalCost = curCost + nextCost;
      cache.compute(
          house,
          (houseN, colorMap) -> {
            if (colorMap == null) {
              colorMap = new HashMap<>();
              colorMap.put(color, totalCost);
            } else {
              colorMap.putIfAbsent(color, totalCost);
            }
            return colorMap;
          });
      return totalCost;
    }
  }

  public static void main(String[] args) {
    var costs = new int[][] {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
    System.out.println(new PaintHouseMemoization().minCost(costs));
  }
}
