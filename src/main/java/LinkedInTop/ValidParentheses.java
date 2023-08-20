package LinkedInTop;

import java.util.ArrayDeque;
import java.util.Map;

public class ValidParentheses {

  public static boolean isValid(String s) {
    var stack = new ArrayDeque<Character>();
    var str = s.toCharArray();
    var parenthesis = Map.of('(', ')',
      '{', '}',
      '[', ']');
    var i = 0;
    while (i < str.length) {
      var symbol = str[i];
      if (parenthesis.containsKey(symbol)) {
        stack.push(parenthesis.get(symbol));
      } else {
        if(stack.isEmpty() || !stack.pop().equals(symbol)) {
          return false;
        }
      }
      i++;
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    System.out.println(isValid("{([{}]){}()}"));
  }
}
