package LinkedInTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class WordLadderBFS {

  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    var level = 0;
    var words = wordList.stream()
      .filter(word -> !word.equals(beginWord))
      .collect(Collectors.toSet());

    var queue = new LinkedList<String>();
    queue.add(beginWord);
    while (!queue.isEmpty()) {
      level++;
      var queueSize = queue.size();
      for (var i = 0; i < queueSize; i++) {
        var word = queue.poll();
        if (word.equals(endWord)) {
          return level;
        }
        var allNeighbors = neighbors(word);
        for (var neighbor : allNeighbors) {
          if (words.contains(neighbor)) {
            words.remove(neighbor);
            queue.add(neighbor);
          }
        }
      }
    }
    return 0;
  }

  public static List<String> neighbors(String string) {
    var result = new ArrayList<String>();
    var chars = string.toCharArray();
    for (var i = 0; i < chars.length; i++) {
      for (var symbol = 'a'; symbol <= 'z'; symbol++) {
        var temp = chars[i];
        chars[i] = symbol;
        result.add(new String(chars));
        chars[i] = temp;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    var beginWord = "hit";
    var endWord = "cog";
    var wordList = List.of("hot", "dot", "dog", "lot", "log");
//    var beginWord = "hit";
//    var endWord = "hot";
//    var wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
//    var beginWord = "hot";
//    var endWord = "dog";
//    var wordList = List.of("hot","cog","dog","tot","hog","hop","pot","dot");
//    var beginWord = "qa";
//    var endWord = "sq";
//    var wordList = List.of("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
    System.out.println(ladderLength(beginWord, endWord, wordList));
  }
}
