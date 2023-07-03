package Strings;

public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    var result = "";
    var curPos = 0;
    var finish = false;
    while (!finish) {
      char curChar = 0;
      for (var curStr : strs) {
        if (curPos == curStr.length()) {
          finish = true;
          break;
        }
        if (curChar == 0) {
          curChar = curStr.charAt(curPos);
        } else {
          if (curStr.charAt(curPos) != curChar) {
            finish = true;
            break;
          }
        }
      }
      if (!finish) {
        result += String.valueOf(curChar);
        curPos++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
  }
}
