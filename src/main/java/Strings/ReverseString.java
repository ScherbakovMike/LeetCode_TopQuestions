package Strings;

public class ReverseString {

  public void reverseString(char[] s) {
    int i = 0;
    do {
      var buf = s[i];
      s[i] = s[s.length - i - 1];
      s[s.length - i - 1] = buf;
      i++;
    } while (i < s.length / 2);
  }

  public static void main(String[] args) {
    var test = "Example of string";
    var testChar = test.toCharArray();
    new ReverseString().reverseString(testChar);
    System.out.println(testChar);
  }
}
