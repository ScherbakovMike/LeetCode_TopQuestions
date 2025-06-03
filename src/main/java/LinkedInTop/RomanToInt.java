package LinkedInTop;

import java.util.Map;

public class RomanToInt {

  private static final Map<Character, Short> numbers =
      Map.of(
          'I', (short) 1,
          'V', (short) 5,
          'X', (short) 10,
          'L', (short) 50,
          'C', (short) 100,
          'D', (short) 500,
          'M', (short) 1000);

  public static int romanToInt(String s) {
    short result = 0;
    byte i = 0;
    char[] str = s.toCharArray();
    while (i < s.length()) {
      short symbolValue = numbers.get(str[i]);
      if (i < (s.length() - 1)) {
        short nextSymbolValue = numbers.get(str[i + 1]);
        if (nextSymbolValue > symbolValue) {
          result += (nextSymbolValue - symbolValue);
          i += 2;
          continue;
        }
      }
      result += symbolValue;
      i++;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(romanToInt("LXIX"));
  }
}
