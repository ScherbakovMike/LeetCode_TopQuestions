package Strings;

import java.util.*;

/*
246. Strobogrammatic Number
Given a string num representing an integer, determine whether it is a strobogrammatic number. Return TRUE if the number is strobogrammatic or FALSE if it is not.

Note: A strobogrammatic number appears the same when rotated 180 degrees (viewed upside down). For example, “69” is strobogrammatic because it looks the same when flipped upside down, while “962” is not.
 */
public class StrobogrammaticNumber {

  public static boolean isStrobogrammatic(String num) {
    int start = 0;
    var end = num.length() - 1;
    while (start < end) {
      if (num.charAt(start) != num.charAt(end)) {
        var exclusion =
            (num.charAt(start) == '6' && num.charAt(end) == '9')
                || (num.charAt(start) == '9' && num.charAt(end) == '6');
        if (!exclusion) return false;
      }
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isStrobogrammatic("6"));
    System.out.println(isStrobogrammatic("69"));
    System.out.println(isStrobogrammatic("606"));
    System.out.println(isStrobogrammatic("609"));
    System.out.println(isStrobogrammatic("109"));
  }
}
