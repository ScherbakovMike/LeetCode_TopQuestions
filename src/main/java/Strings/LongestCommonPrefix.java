package Strings;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

//  public String longestCommonPrefix(String[] strs) {
//    var result = "";
//    var curPos = 0;
//    var finish = false;
//    while (!finish) {
//      char curChar = 0;
//      for (var curStr : strs) {
//        if (curPos == curStr.length()) {
//          finish = true;
//          break;
//        }
//        if (curChar == 0) {
//          curChar = curStr.charAt(curPos);
//        } else {
//          if (curStr.charAt(curPos) != curChar) {
//            finish = true;
//            break;
//          }
//        }
//      }
//      if (!finish) {
//        result += String.valueOf(curChar);
//        curPos++;
//      }
//    }
//    return result;
//  }

  public String longestCommonPrefix(String[] strs) {
    var result = new StringBuilder();
    Arrays.sort(strs, Comparator.comparingInt(String::length));
    result.append(strs[0]);
    for (var i = 1; i < strs.length; i++) {
      var newShortestLength = result.length();
      for (var j = result.length() - 1; j >= 0; j--) {
        if (result.charAt(j) != strs[i].charAt(j)) {
          newShortestLength = j;
        }
      }
      result.setLength(newShortestLength);
    }
    return result.toString();
  }

  public static void main(String[] args) {
    var strs = new String[]{"cir", "car"};
    //var strs = new String[]{"flower", "flow", "flight"};
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
  }
}
