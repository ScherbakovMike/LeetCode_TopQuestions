package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class IntervalListIntersection {

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    var result = new ArrayList<int[]>();
    var i = 0;
    var j = 0;
    while (i < firstList.length && j < secondList.length) {
      if ((secondList[j][0] >= firstList[i][0] && secondList[j][0] <= firstList[i][1])
          || (firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1])) {
        var left = Math.max(firstList[i][0], secondList[j][0]);
        var right = Math.min(firstList[i][1], secondList[j][1]);
        result.add(new int[] {left, right});
      }
      if (firstList[i][1] <= secondList[j][1]) {
        i++;
      } else {
        j++;
      }
    }
    return result.toArray(int[][]::new);
  }

  public static void main(String[] args) {
    //    var firstList = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
    //    var secondList = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}};

    var firstList = new int[][] {{1, 3}, {5, 9}};
    var secondList = new int[][] {};
    System.out.println(
        Arrays.deepToString(
            new IntervalListIntersection().intervalIntersection(firstList, secondList)));
  }
}
