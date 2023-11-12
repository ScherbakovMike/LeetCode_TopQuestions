package Strings;

import java.util.Arrays;

public class DivideAStringIntoGroupsOfSizeK {

  public String[] divideString(String s, int k, char fill) {
    var charArray = s.toCharArray();
    var size = (charArray.length / k);
    if (s.length() > size * k) {
      size++;
    }
    var length = size * k;
    var result = new String[size];
    for (var i = 0; i < size; i++) {
      result[i] = String.valueOf(Arrays.copyOfRange(charArray, i * k, Math.min(i * k + k, charArray.length)));
      length -= result[i].length();
    }
    result[result.length - 1] = result[result.length - 1] + String.valueOf(fill).repeat(length);
    return result;
  }

  public static void main(String[] args) {
    var s = "abcdefghij";
    var k = 3;
    var fill = 'x';
    System.out.println(Arrays.deepToString(new DivideAStringIntoGroupsOfSizeK().divideString(s, k, fill)));
  }
}
