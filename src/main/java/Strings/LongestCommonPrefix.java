package Strings;

public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    var minStringIndex = 0;
    var minStringLength = strs[minStringIndex].length();
    for (var i = 1; i < strs.length; i++) {
      if (strs[i].length() < minStringLength) {
        minStringLength = strs[i].length();
        minStringIndex = i;
      }
    }
    var result = strs[minStringIndex];
    var newShortestLength = result.length();
    for (var i = 0; i < strs.length; i++) {
      if (i == minStringIndex) {
        continue;
      }
      for (var j = newShortestLength - 1; j >= 0; j--) {
        if (result.charAt(j) != strs[i].charAt(j)) {
          newShortestLength = j;
        }
      }
    }
    return result.substring(0, newShortestLength);
  }

  public static void main(String[] args) {
    //var strs = new String[]{"cir", "car"};
    var strs = new String[]{"flower", "flow", "flight"};
    //var strs = new String[]{"aba", "c", "b", "a", "ab"};
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
  }
}
