package Strings;

public class ReverseInteger {

  public int reverse(int x) {
    try {
      return Integer.parseInt(
          (x < 0 ? "-" : "") + new StringBuilder(String.valueOf(Math.abs(x))).reverse());
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public static void main(String[] args) {
    System.out.println(new ReverseInteger().reverse(1534236469));
  }
}
