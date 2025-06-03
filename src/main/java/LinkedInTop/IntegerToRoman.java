package LinkedInTop;

public class IntegerToRoman {

  public static String intToRoman(int num) {
    var symbols =
        new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    var values = new short[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    var result = new StringBuilder();
    byte j = 0;
    while (num > 0) {
      while (values[j] > num) {
        j++;
      }
      result.append(symbols[j]);
      num -= values[j];
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(intToRoman(2888));
  }
}
