package CommonAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementGraphDFS {

  private static final Map<String, List<String>> graph = new HashMap<>();

  static {
    graph.put("you", List.of("alice", "bob", "claire"));
    graph.put("bob", List.of("anuj", "peggy"));
    graph.put("alice", List.of("peggy"));
    graph.put("claire", List.of("thom", "jonny"));
    graph.put("anuj", List.of());
    graph.put("peggy", List.of());
    graph.put("thom", List.of());
    graph.put("jonny", List.of());
  }

  public static String search(String startName, String searchable) {
    var searched = new ArrayList<String>();
    return searchDFS(startName, searchable, searched);
  }

  private static String searchDFS(String currentName, String searchable,
      ArrayList<String> searched) {
    if (searched.contains(currentName)) {
      return null;
    }
    searched.add(currentName);
    var nodes = graph.get(currentName);
    if (nodes.contains(searchable)) {
      return searchable;
    }
    for (var node : nodes) {
      var result = searchDFS(node, searchable, searched);
      if (result != null) {
        return result;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(search("you", "jonny"));
  }
}
