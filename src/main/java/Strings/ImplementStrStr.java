package Strings;

public class ImplementStrStr {

  public int strStr(String haystack, String needle) {
    int curPos = 0;
    int shift = 0;
    int result = -1;
    char firstSymbol = needle.charAt(0);
    while (curPos < haystack.length() && result == -1) {
      char curChar = haystack.charAt(curPos);
      if (curChar == firstSymbol) {
        shift = 0;
        while (shift < needle.length()
          && (curPos + shift) < haystack.length()) {
          if (haystack.charAt(curPos + shift) != needle.charAt(shift)) {
            break;
          }
          shift++;
        }
        if(shift==needle.length()) {
          result = curPos;
        }
      }
      curPos++;
    }
    return result;
  }

  public static void main(String[] args) {
    var needle = "e";
    var haystack = "leetcode";
    System.out.println(new ImplementStrStr().strStr(haystack, needle));
  }
}
