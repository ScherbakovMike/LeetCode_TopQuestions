package LinkedInTop;

import java.util.Comparator;
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
    this.statistic = new TreeSet<>(Comparator.comparingInt(node -> node.count));
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
      if(node.count==0) {
        keys.remove(key);
      } else {
        statistic.add(node);
      }
    } else {
      throw new UnsupportedOperationException("Key is not found");
    }
  }

  public String getMaxKey() {
    return statistic.last().key;
  }

  public String getMinKey() {
    return statistic.first().key;
  }

  public static void main(String[] args) {
    var stack = new AllOne();
    stack.inc("hello");
    stack.inc("hello");
    System.out.println(stack.getMaxKey());
    System.out.println(stack.getMinKey());
    stack.inc("leet");
    System.out.println(stack.getMaxKey());
    System.out.println(stack.getMinKey());
  }
}

/**
 * Your AllOne object will be instantiated and called as such: AllOne obj = new AllOne();
 * obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey(); String param_4 = obj.getMinKey();
 */
