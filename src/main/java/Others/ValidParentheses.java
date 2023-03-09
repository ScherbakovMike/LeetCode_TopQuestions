package Others;

import java.util.ArrayDeque;
import java.util.Map;

public class ValidParentheses {

  public static void main(String[] args) {
    var test = "(";
    System.out.println(new ValidParentheses().isValid(test));
  }

  public boolean isValid(String s) {
    var openQueue = new ArrayDeque<Character>();
    var closeQueue = new ArrayDeque<Character>();
    var parentheses = Map.of(
        '(', openQueue,
        '[', openQueue,
        '{', openQueue,
        ')', closeQueue,
        ']', closeQueue,
        '}', closeQueue
    );
    for (int i = 0; i < s.length(); i++) {
      char ch1 = s.charAt(i);
      var firstQueue = parentheses.get(ch1);
      if (firstQueue == openQueue) {
        openQueue.push(ch1);
      } else {
        if (openQueue.isEmpty()) {
          return false;
        }
        char ch2 = openQueue.pop();
        var pair = (ch2 == '(' && ch1 == ')')
            || (ch2 == '{' && ch1 == '}')
            || (ch2 == '[' && ch1 == ']');
        if (!pair) {
          return false;
        }
      }
    }
    return openQueue.isEmpty() && closeQueue.isEmpty();
  }

}
