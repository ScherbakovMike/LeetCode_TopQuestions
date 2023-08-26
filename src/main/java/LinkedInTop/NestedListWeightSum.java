package LinkedInTop;

import java.util.ArrayList;
import java.util.List;

class NestedInteger {
  private Integer val;
  private List<NestedInteger> list;

  public NestedInteger() {
    this.list = new ArrayList<>();
    this.val = 0;
  }

  public NestedInteger(int v) {
    this.val = v;
    this.list = new ArrayList<>();
  }

  public NestedInteger(NestedInteger ni) {
    this.list = new ArrayList<>();
    this.list.add(ni);
    this.val = 0;
  }

  public boolean isInteger() {
    return list.isEmpty();
  }

  public Integer getInteger() {
    return this.val;
  }

  public void setInteger(int v) {
    this.val = v;
  }

  public void add(NestedInteger ni) {
    list.add(ni);
  }

  public List<NestedInteger> getList() {
    return list;
  }

  public static NestedInteger fromIntegers(int... ints) {
    var result = new NestedInteger();
    for (var n : ints) {
      result.add(new NestedInteger(n));
    }
    return result;
  }
}

public class NestedListWeightSum {
  public int depthSum(List<NestedInteger> nestedList) {
    var sum = 0;
    for (var elem : nestedList) {
      sum += depthSumR(elem, 1);
    }
    return sum;
  }

  private int depthSumR(NestedInteger nestedInteger, int depth) {
    if (nestedInteger.isInteger()) {
      return nestedInteger.getInteger() * depth;
    } else {
      var sum = 0;
      for (var elem : nestedInteger.getList()) {
        sum += depthSumR(elem, depth + 1);
      }
      return sum;
    }
  }
}
