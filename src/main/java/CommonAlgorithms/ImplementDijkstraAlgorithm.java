package CommonAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementDijkstraAlgorithm {

  private static final Map<String, Map<String, Integer>> graph = Map.of(
      "start", Map.of("a", 6, "b", 2),
      "a", Map.of("fin", 1),
      "b", Map.of("a", 3, "fin", 5),
      "fin", Map.of()
  );

  private static final Map<String, Integer> costs = new HashMap<>() {
    {
      put("a", 6);
      put("b", 2);
      put("fin", Integer.MAX_VALUE);
    }
  };

  private static final Map<String, String> parents = new HashMap<>() {
    {
      put("a", "start");
      put("b", "start");
      put("fin", null);
    }
  };

  private static final List<String> processed = new ArrayList<>();

  private static String findLowestNodeCost() {
    return costs.entrySet().stream()
        .filter(entry -> !processed.contains(entry.getKey()))
        .sorted(Comparator.comparingInt(Map.Entry::getValue))
        .map(Map.Entry::getKey)
        .findFirst().orElse(null);
  }

  public static void main(String[] args) {
    var node = findLowestNodeCost();
    while (node != null) {
      var neighbors = graph.get(node);
      var cost = costs.get(node);
      for (var entry : neighbors.entrySet()) {
        var newCost = cost + entry.getValue();
        if (newCost < costs.get(entry.getKey())) {
          costs.put(entry.getKey(), newCost);
          parents.put(entry.getKey(), node);
        }
      }
      processed.add(node);
      node = findLowestNodeCost();
    }
    System.out.println(costs.get("fin"));
  }
}
