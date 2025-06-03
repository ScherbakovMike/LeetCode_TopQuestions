package CommonAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class ImplementHashTable {

  static class HashTable<T> {

    private static final int BUCKETS = 10;
    private final Object[] data;

    public HashTable() {
      this.data = new Object[BUCKETS];
    }

    public void set(String key, T value) {
      var bucket = bucket(key);
      if (this.data[bucket] == null) {
        this.data[bucket(key)] = new Object[] {key, value, null};
      } else {
        var currentNode = ((Object[]) this.data[bucket(key)]);
        var currentKey = (String) ((Object[]) this.data[bucket(key)])[0];
        Object[] prevNode = null;
        while (currentNode != null && !currentKey.equals(key)) {
          prevNode = currentNode;
          currentNode = (Object[]) (currentNode)[2];
          if (currentNode != null) {
            currentKey = (String) (currentNode)[0];
          }
        }
        if (currentNode != null) {
          currentNode[1] = value;
        } else {
          prevNode[2] = new Object[] {key, value, null};
        }
      }
    }

    public T get(String key) {
      var currentNode = ((Object[]) this.data[bucket(key)]);
      var currentKey = (String) ((Object[]) this.data[bucket(key)])[0];
      while (currentNode != null && !currentKey.equals(key)) {
        currentNode = (Object[]) (currentNode)[2];
        if (currentNode != null) {
          currentKey = (String) (currentNode)[0];
        }
      }
      if (currentNode == null) {
        return null;
      } else {
        return (T) currentNode[1];
      }
    }

    public List<String> keys() {
      var result = new ArrayList<String>();
      for (Object datum : this.data) {
        var currentNode = ((Object[]) datum);
        while (currentNode != null) {
          result.add((String) currentNode[0]);
          currentNode = (Object[]) (currentNode)[2];
        }
      }
      return result;
    }

    private int bucket(String key) {
      return key.hashCode() % data.length;
    }
  }

  public static void main(String[] args) {
    var map = new HashTable<Integer>();
    map.set("one", 1);
    map.set("two", 2);
    map.set("three", 3);
    map.set("four", 4);
    map.set("five", 5);
    map.set("six", 6);

    System.out.println(map.get("one"));
    System.out.println(map.get("two"));
    System.out.println(map.get("three"));
    System.out.println(map.get("four"));
    System.out.println(map.get("five"));
    System.out.println(map.get("six"));

    System.out.println(map.keys());
  }
}
