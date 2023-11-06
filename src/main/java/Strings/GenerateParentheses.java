package Strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    var answer = new ArrayList<String>();
    backtrack(answer, new StringBuilder(), (byte) 0, (byte) 0, (byte) n);
    return answer;
  }

  private void backtrack(ArrayList<String> answer, StringBuilder currentString, byte leftCount,
      byte rightCount, byte n) {
    if (currentString.length() == 2 * n) {
      answer.add(currentString.toString());
      return;
    }
    if (leftCount < n) {
      currentString.append("(");
      backtrack(answer, currentString, (byte) (leftCount + 1), rightCount, n);
      currentString.deleteCharAt(currentString.length() - 1);
    }
    if (leftCount > rightCount) {
      currentString.append(")");
      backtrack(answer, currentString, leftCount, (byte) (rightCount + 1), n);
      currentString.deleteCharAt(currentString.length() - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(new GenerateParentheses().generateParenthesis(8));
  }
}
