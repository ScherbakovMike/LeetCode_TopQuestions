package CommonAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ImplementGraphBFS {

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
    var queue = new LinkedList<>(graph.get(startName));
    var searched = new ArrayList<String>();
    while (!queue.isEmpty()) {
      var person = queue.pop();
      if (searched.contains(person)) {
        continue;
      }
      if (person.equals(searchable)) {
        return person;
      } else {
        searched.add(person);
        queue.addAll(graph.get(person));
      }
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(search("you", "jonny"));
  }
}
