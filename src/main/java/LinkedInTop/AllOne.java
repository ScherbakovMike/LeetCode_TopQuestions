package LinkedInTop;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

class AllOne {

  private static class Node {

    String key;
    int count;

    public Node(String key, int count) {
      this.key = key;
      this.count = count;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return count == node.count && Objects.equals(key, node.key);
    }

    @Override
    public int hashCode() {
      return Objects.hash(key, count);
    }
  }

  private final Map<String, Node> keys;
  private final TreeSet<Node> statistic;

  public AllOne() {
    this.keys = new HashMap<>();
    this.statistic =
        new TreeSet<>(
            (o1, o2) -> {
              if (o1.count == o2.count) {
                return o1.key.compareTo(o2.key);
              } else {
                return o1.count - o2.count;
              }
            });
  }

  public void inc(String key) {
    Node node = null;
    if (keys.containsKey(key)) {
      node = keys.get(key);
      statistic.remove(node);
      node.count++;
    } else {
      node = new Node(key, 1);
      keys.put(key, node);
    }
    statistic.add(node);
  }

  public void dec(String key) {
    Node node = null;
    if (keys.containsKey(key)) {
      node = keys.get(key);
      statistic.remove(node);
      node.count--;
      if (node.count == 0) {
        keys.remove(key);
      } else {
        statistic.add(node);
      }
    } else {
      throw new UnsupportedOperationException("Key is not found");
    }
  }

  public String getMaxKey() {
    if (statistic.isEmpty()) {
      return "";
    }
    return statistic.last().key;
  }

  public String getMinKey() {
    if (statistic.isEmpty()) {
      return "";
    }
    return statistic.first().key;
  }

  public static void main(String[] args) {
    var stack = new AllOne();

    // ["AllOne","inc","inc","inc","inc","inc","dec","dec","getMaxKey","getMinKey"]
    // [[],["a"],["b"],["b"],["b"],["b"],["b"],["b"],[],[]]

    stack.inc("a");
    stack.inc("b");
    stack.inc("b");
    stack.inc("b");
    stack.inc("b");
    stack.dec("b");
    stack.dec("b");
    System.out.println(stack.getMaxKey());
    System.out.println(stack.getMinKey());
  }
}

/**
 * Your AllOne object will be instantiated and called as such: AllOne obj = new AllOne();
 * obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey(); String param_4 = obj.getMinKey();
 */
