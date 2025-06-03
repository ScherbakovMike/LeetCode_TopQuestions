package LinkedInTop;

import java.util.LinkedList;
import java.util.Set;

public class EvaluateReversePolishNotation {

  public static int evalRPN(String[] tokens) {
    var stack = new LinkedList<Integer>();
    var operations = Set.of("+", "-", "/", "*");
    for (var token : tokens) {
      if (operations.contains(token)) {
        var op2 = stack.pop();
        var op1 = stack.pop();
        var opResult =
            switch (token) {
              case "+" -> op1 + op2;
              case "-" -> op1 - op2;
              case "*" -> op1 * op2;
              case "/" -> op1 / op2;
              default -> throw new IllegalArgumentException();
            };
        stack.push(opResult);
      } else {
        stack.push(Integer.parseInt(token));
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) {
    var tokens = new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    System.out.println(evalRPN(tokens));
  }
}
