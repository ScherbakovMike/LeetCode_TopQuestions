package LinkedInTop;

import java.util.Collections;
import java.util.HashMap;

public class MaxPointsOnALine {

  public static int maxPoints(int[][] points) {
    if (points.length == 1) {
      return 1;
    }
    var result = 2;
    for (var i = 0; i < points.length; i++) {
      var atan2Map = new HashMap<Double, Integer>();
      for (var j = 0; j < points.length; j++) {
        if (i == j) {
          continue;
        }
        var xd = points[j][0] - points[i][0];
        var yd = points[j][1] - points[i][1];
        var atan2 = Math.atan2(yd, xd);
        atan2Map.merge(atan2, 1, Integer::sum);
      }
      result = Math.max(result, Collections.max(atan2Map.values()) + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    var points = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
    System.out.println(maxPoints(points));
  }
}
