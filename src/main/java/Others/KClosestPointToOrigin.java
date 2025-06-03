package Others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class KClosestPointToOrigin {
  public static void main(String[] args) {
    var points = new int[][] {{3, 3}, {5, -1}, {-2, 4}};
    var k = 2;
    System.out.println(Arrays.deepToString(new KClosestPointToOrigin().kClosest(points, k)));
  }

  public int[][] kClosest(int[][] points, int k) {
    return IntStream.range(0, points.length)
        .boxed()
        .sorted(
            Comparator.comparingInt(
                xIndex ->
                    points[xIndex][0] * points[xIndex][0] + points[xIndex][1] * points[xIndex][1]))
        .limit(k)
        .map(xIndex -> points[xIndex])
        .toList()
        .toArray(new int[0][0]);
  }
}
