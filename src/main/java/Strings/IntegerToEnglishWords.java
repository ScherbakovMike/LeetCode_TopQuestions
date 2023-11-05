package Strings;

public class IntegerToEnglishWords {

  private final String[] symbols = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven",
      "Eight",
      "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
      "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
      "Seventy",
      "Eighty", "Ninety"};
  private final short[] numbers = new short[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
      18, 19,
      20, 30, 40, 50, 60, 70, 80, 90};
  private final String[] bigSymbols = new String[]{"Hundred", "Thousand", "Million", "Billion"};
  private final int[] bigNumbers = new int[]{100, 1000, 1000000, 1000000000};

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    return numberToWordsRecursive(num);
  }

  private String numberToWordsRecursive(int num) {
    if (num == 0) {
      return "";
    }
    var resultLeft = new StringBuilder();
    if (num >= bigNumbers[0]) {
      var j = bigNumbers.length - 1;
      while (num / bigNumbers[j] == 0) {
        j--;
      }
      resultLeft.append(numberToWordsRecursive(num / bigNumbers[j]));
      resultLeft.append(" ");
      resultLeft.append(bigSymbols[j]);
      resultLeft.append(" ");

      num -= bigNumbers[j] * (num / bigNumbers[j]);
    } else {
      var j = numbers.length - 1;
      while (num / numbers[j] == 0) {
        j--;
      }
      resultLeft.append(symbols[j]);
      num -= numbers[j] * (num / numbers[j]);
      resultLeft.append(numberToWordsRecursive(num / numbers[j]));
      resultLeft.append(" ");

    }
    resultLeft.append(numberToWordsRecursive(num));
    return resultLeft.toString().trim();
  }

  public static void main(String[] args) {
    System.out.println(new IntegerToEnglishWords().numberToWords(1));
  }
}
