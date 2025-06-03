package LinkedInTop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

  private final Map<Integer, Integer> map;
  private final List<Integer> list;
  private final Random random;

  public RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
    random = new Random();
  }

  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    }
    list.add(val);
    map.put(val, list.size() - 1);
    return true;
  }

  public boolean remove(int val) {
    var pos = map.get(val);
    if (pos == null) {
      return false;
    }
    var buf = list.get(list.size() - 1);
    list.set(list.size() - 1, val);
    list.set(pos, buf);
    list.remove(list.size() - 1);
    map.put(buf, pos);
    map.remove(val);
    return true;
  }

  public int getRandom() {
    return list.get(random.nextInt(list.size()));
  }

  public static void main(String[] args) {
    var set = new RandomizedSet();
    System.out.println(set.insert(10));
    System.out.println(set.insert(20));
    System.out.println(set.insert(30));
    System.out.println(set.remove(20));
    System.out.println(set.remove(1000));
    System.out.println(set.getRandom());
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such: RandomizedSet obj = new
 * RandomizedSet(); boolean param_1 = obj.insert(val); boolean param_2 = obj.remove(val); int
 * param_3 = obj.getRandom();
 */
