package Strings;

public class RearrangeSpacesBetweenWords {

  public String reorderSpaces(String text) {
    var spaces = 0;
    var words = 0;
    var wordStart = false;
    for (var i = 0; i < text.length(); i++) {
      if (text.charAt(i) == ' ') {
        spaces++;
        if (wordStart) {
          words++;
          wordStart = false;
        }
      } else {
        wordStart = true;
      }
    }
    if (wordStart) {
      words++;
    }
    var delimiter = "";
    if (words > 1) {
      var ordinalSpaces = spaces / (words - 1);
      delimiter = " ".repeat(ordinalSpaces);
    }

    var result = new StringBuilder();
    var currentWord = 0;
    wordStart = false;
    for (var i = 0; i < text.length(); i++) {
      if (text.charAt(i) == ' ') {
        if (wordStart) {
          if (currentWord != (words - 1)) {
            result.append(delimiter);
            spaces -= delimiter.length();
          }
          currentWord++;
          wordStart = false;
        }
      } else {
        result.append(text.charAt(i));
        wordStart = true;
      }
    }
    if (spaces > 0) {
      result.append(" ".repeat(spaces));
    }
    return result.toString();
  }

  public static void main(String[] args) {
    var text = "  this   is  a sentence ";
    System.out.println(new RearrangeSpacesBetweenWords().reorderSpaces(text));

    text = " practice   makes   perfect";
    System.out.println(new RearrangeSpacesBetweenWords().reorderSpaces(text));
  }
}
