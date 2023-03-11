package Strings;

public class StringToInteger {

  public static void main(String[] args) {
    System.out.println(new StringToInteger().myAtoi("-6147483648"));
  }

  public int myAtoi(String s) {
    var result = 0;
    var buffer = "";
    Integer sign = null;
    var pos = 0;
    while (pos < s.length()) {
      var ch = s.charAt(pos);
      if (buffer.length()==0 && ch == ' ') {
        pos++;
        continue;
      }
      if (sign == null && ch == '-') {
        sign = -1;
        pos++;
        continue;
      }
      if (sign == null && ch == '+') {
        sign = 1;
        pos++;
        continue;
      }
      if (sign == null) {
        sign = 1;
      }
      if (ch >= 48 && ch <= 57) {
        buffer += ch;
        pos++;
      } else {
        break;
      }
    }

    pos = buffer.length() - 1;
    while (pos >= 0) {
      try {
        int ch = buffer.charAt(pos) - 48;
        int degree = (buffer.length() - 1) - pos;
        int addition = 1;
        if (ch != 0) {
          for (int j = 0; j < degree; j++) {
            addition = Math.multiplyExact(addition, 10);
          }
        }
        addition = Math.multiplyExact(addition, ch);
        result = Math.addExact(result, addition);
        pos--;
        if(pos<0 ) {
          result = Math.negateExact(result);
        }
      } catch (ArithmeticException e) {
        if (sign > 0) {
          return Integer.MAX_VALUE;
        } else {
          return Integer.MIN_VALUE;
        }
      }
    }
    return result;
  }
}
