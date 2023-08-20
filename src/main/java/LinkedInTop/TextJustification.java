package LinkedInTop;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

  public static List<String> fullJustify(String[] words, int maxWidth) {
    var wordsConsumed = 0;
    var result = new ArrayList<String>();
    while (wordsConsumed < words.length) {
      var wordList = getWords(words, maxWidth, wordsConsumed);
      wordsConsumed += wordList.size();
      result.add(getLine(wordList, maxWidth, wordsConsumed == words.length));
    }
    return result;
  }

  private static List<String> getWords(String[] words, int maxWidth, int skipWords) {
    var result = new ArrayList<String>();
    var spaceLeft = maxWidth;
    var i = skipWords;
    while (spaceLeft > 0 && i < words.length) {
      var curWord = words[i];
      if (curWord.length() <= spaceLeft) {
        result.add(curWord);
      }
      spaceLeft = spaceLeft - curWord.length();
      if (spaceLeft > 0) {
        spaceLeft -= 1;
      }
      i++;
    }
    return result;
  }

  private static String getLine(List<String> words, int maxWidth, boolean isLast) {
    int baseLength = words.stream().map(String::length).reduce(Integer::sum).get();
    if (isLast || words.size() == 1) {
      var leftSide = String.join(" ", words);
      return leftSide + " ".repeat(maxWidth - leftSide.length());
    } else {
      var lengthOfMandatorySpaces = words.size() - 1;
      var leftSpace = maxWidth - baseLength - lengthOfMandatorySpaces;
      var additionalSpaces = leftSpace / (words.size() - 1);
      var extraSpaces = leftSpace % (words.size() - 1);
      var result = new StringBuilder();
      for (var word : words) {
        result.append(word);
        if (result.length() < maxWidth) {
          result.append(" ".repeat(1 + additionalSpaces));
        }
        if (result.length() < maxWidth && extraSpaces > 0) {
          result.append(" ");
          extraSpaces--;
        }
      }
      return result.toString();
    }
  }

  public static void main(String[] args) {
    var words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
    var maxWidth = 20;
    System.out.println(fullJustify(words, maxWidth));
  }
}
