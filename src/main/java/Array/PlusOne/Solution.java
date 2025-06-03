package Array.PlusOne;

public class Solution {
  public int[] plusOne(int[] digits) {
    var result = new StringBuilder();
    int i = digits.length - 1;
    int addition = 0;
    do {
      var cur = addition == 0 ? digits[i] + 1 : digits[i] + addition;
      if (cur == 10) {
        addition = 1;
        result.insert(0, "0");
      } else {
        result.insert(0, cur);
        addition = 0;
      }
      i--;
    } while (addition > 0 && i >= 0);
    if (addition > 0) {
      result.insert(0, addition);
    }
    while (i >= 0) {
      result.insert(0, digits[i]);
      i--;
    }
    return result.chars().map(operand -> operand - 48).toArray();
  }

  public static void main(String[] args) {
    var result = new Solution().plusOne(new int[] {9, 9, 9});
    for (var elem : result) {
      System.out.print(elem + " ");
    }
  }
}
