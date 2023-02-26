package Math;

import java.util.Map;
import java.util.stream.Collectors;

public class RomanToInteger {

  public static void main(String[] args) {
    System.out.println(new RomanToInteger().romanToInt("D"));
//    System.out.println(new RomanToInteger().romanToInt("XX"));
//    System.out.println(new RomanToInteger().romanToInt("III"));
//    System.out.println(new RomanToInteger().romanToInt("LVIII"));
  }

  public int romanToInt(String s) {
    var numbers = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
    var ints = s.chars().mapToObj(value -> numbers.get((char) value)).collect(Collectors.toList());
    var pos = 0;
    while (pos < (ints.size() - 1)) {
      var left = ints.get(pos);
      var right = ints.get(pos + 1);
      if (left < right) {
        ints.set(pos + 1, right - left);
        ints.set(pos, 0);
        pos += 2;
      } else {
        pos++;
      }
    }
    return ints.stream().reduce(Integer::sum).get();
  }
}
