package LinkedInTop;

import java.util.Arrays;
import java.util.LinkedList;

public class InsertInterval {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    var result = new LinkedList<int[]>();
    var inserted = false;
    if (intervals.length == 0 || newInterval[0] < intervals[0][0]) {
      result.add(newInterval);
      inserted = true;
    }
    for (var i = 0; i < intervals.length; i++) {
      var interval = intervals[i];

      if (inserted) {
        var lastInterval = result.getLast();
        if (interval[0] <= lastInterval[1]) {
          lastInterval[1] = Math.max(lastInterval[1], Math.max(interval[1], newInterval[1]));
        } else {
          result.add(interval);
        }
        continue;
      }
      if (interval[0] <= newInterval[0] && interval[1] >= newInterval[0]) {
        interval[1] = Math.max(interval[1], newInterval[1]);
        result.add(interval);
        inserted = true;
        continue;
      }
      if (!inserted
          && !result.isEmpty()
          && newInterval[0] <= interval[0]
          && newInterval[1] >= interval[0]) {
        interval[0] = Math.min(newInterval[0], interval[0]);
        interval[1] = Math.max(interval[1], newInterval[1]);
        result.add(interval);
        inserted = true;
        continue;
      }
      if (!inserted && newInterval[0] < interval[0] && newInterval[1] < interval[0]) {
        result.add(newInterval);
        result.add(interval);
        inserted = true;
        continue;
      }
      result.add(interval);
    }
    if (!inserted) {
      result.add(newInterval);
    }
    return result.toArray(int[][]::new);
  }

  public static void main(String[] args) {
    var intervals = new int[][] {{3, 5}, {12, 15}};
    var newInterval = new int[] {5, 17};
    System.out.println(Arrays.deepToString(new InsertInterval().insert(intervals, newInterval)));
    //
    //    intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    //    newInterval = new int[]{4, 8};
    //    System.out.println(Arrays.deepToString(new InsertInterval().insert(intervals,
    // newInterval)));
    //    var intervals = new int[][]{};
    //    var newInterval = new int[]{2, 5};
    //    System.out.println(Arrays.deepToString(new InsertInterval().insert(intervals,
    // newInterval)));
  }
}
