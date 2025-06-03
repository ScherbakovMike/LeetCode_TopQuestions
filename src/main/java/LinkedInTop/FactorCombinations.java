package LinkedInTop;

import java.util.LinkedList;
import java.util.List;

public class FactorCombinations {

  public static void main(String[] args) {
    System.out.println(getFactors(24));
  }

  public static List<List<Integer>> getFactors(int n) {
    var result = new LinkedList<List<Integer>>();
    var stack = new LinkedList<LinkedList<Integer>>();
    stack.add(new LinkedList<>(List.of(n)));
    while (!stack.isEmpty()) {
      var factors = stack.pop();
      var lastFactor = factors.pollLast();
      var beginning = factors.isEmpty() ? 2 : factors.peekLast();
      for (var i = beginning; i <= lastFactor / i; i++) {
        if (lastFactor % i == 0) {
          var newCombination = new LinkedList<>(factors);
          newCombination.addAll(List.of(i, lastFactor / i));
          stack.add(newCombination);
          result.add(new LinkedList<>(newCombination));
        }
      }
    }
    return result;
  }
}
