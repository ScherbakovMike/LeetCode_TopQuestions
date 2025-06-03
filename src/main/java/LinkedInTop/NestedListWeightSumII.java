package LinkedInTop;

import java.util.Arrays;
import java.util.List;

public class NestedListWeightSumII {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    var results = new int[] {1, 1, 0, 0}; // depth, maxDepth, sumN, sumN*Dn
    results = depthSumR(nestedList, results);
    return (results[1] + 1) * results[2] - results[3];
  }

  private int[] depthSumR(List<NestedInteger> nestedList, int[] curResults) {
    var results = Arrays.copyOf(curResults, 4);
    results[0] = curResults[0];
    results[1] = Math.max(results[0], results[1]);
    for (var elem : nestedList) {
      if (elem.isInteger()) {
        results[2] = results[2] + elem.getInteger();
        results[3] = results[3] + elem.getInteger() * results[0];
      } else {
        if (!elem.getList().isEmpty() || elem.isInteger()) {
          var paramResults = Arrays.copyOf(curResults, 4);
          paramResults[0] = paramResults[0] + 1;
          var nestedResults = depthSumR(elem.getList(), paramResults);
          results[0] = curResults[0];
          results[1] = Math.max(results[1], nestedResults[1]);
          results[2] = results[2] + nestedResults[2];
          results[3] = results[3] + nestedResults[3];
        }
      }
    }
    return results;
  }

  public static void main(String[] args) {
    // [[2|1,1],1|2,[2|1,1],[2|[3|[4|[5|]]]]]
    var list = new NestedInteger();
    list.add(NestedInteger.fromIntegers(1, 1));
    list.add(new NestedInteger(2));
    list.add(NestedInteger.fromIntegers(1, 1));
    list.add(new NestedInteger(new NestedInteger(new NestedInteger(new NestedInteger()))));
    System.out.println(new NestedListWeightSumII().depthSumInverse(list.getList()));
  }
}
