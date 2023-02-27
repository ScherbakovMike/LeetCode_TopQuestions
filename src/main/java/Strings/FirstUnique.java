package Strings;

import java.util.Arrays;

public class FirstUnique {

  public static void main(String[] args) {
    var test = "aabb";
    System.out.println(new FirstUnique().firstUniqChar(test));
  }

  public int firstUniqChar(String s) {
    var positions = new int[255];
    Arrays.fill(positions, Integer.MAX_VALUE);
    for (int i = 0; i < s.length(); i++) {
      var ch = s.charAt(i);
      if (positions[ch] == Integer.MAX_VALUE) {
        positions[ch] = i;
      } else if (positions[ch] >= 0) {
        positions[ch] = -1;
      }
    }

    int min = Integer.MAX_VALUE;
    for (int ch = 0; ch < 255; ch++) {
      var index = positions[ch];
      if (index >= 0 && index < min) {
        min = index;
      }
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
