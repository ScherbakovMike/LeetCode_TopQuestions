package LinkedInTop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MergeSubArrays {

  public static int[][] merge(int[][] intervals) {
    var result = new LinkedList<int[]>();
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    for (var interval : intervals) {
      if(result.isEmpty()) {
        result.add(interval);
        continue;
      }
      var lastResult = result.getLast();
      if(interval[0]>lastResult[1]) {
        result.add(interval);
        continue;
      }
      if(interval[1]>lastResult[1]) {
        lastResult[1] = interval[1];
      }
    }
    return result.toArray(int[][]::new);
  }

  public static void main(String[] args) {
    var intervals = new int[][]{{1,4},{4,6}};
    System.out.println(
      Arrays.stream(merge(intervals))
        .map(Arrays::toString)
        .collect(Collectors.joining(", "))
    );
  }
}
