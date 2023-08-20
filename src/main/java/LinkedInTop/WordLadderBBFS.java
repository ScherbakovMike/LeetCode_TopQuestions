package LinkedInTop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordLadderBBFS {

  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
    var words = new HashSet<>(wordList);
    if(!words.contains(endWord)) return 0;
    var beginSet = new HashSet<>(List.of(beginWord));
    var endSet = new HashSet<>(List.of(endWord));
    var length = 1;
    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      if (beginSet.size() > endSet.size()) {
        var temp = beginSet;
        beginSet = endSet;
        endSet = temp;
      }
      var newSet = new HashSet<String>();
      for (var word : beginSet) {
        var neighbors = neighbors(word);
        for(var neighbor: neighbors) {
          if(endSet.contains(neighbor)) return length+1;
          if(words.contains(neighbor)) {
            newSet.add(neighbor);
            words.remove(neighbor);
          }
        }
      }
      beginSet = newSet;
      length++;
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
//    var beginWord = "hit";
//    var endWord = "cog";
//    var wordList = List.of("hot", "dot", "dog", "lot", "log");
//    var beginWord = "hit";
//    var endWord = "hot";
//    var wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
    var beginWord = "hot";
    var endWord = "dog";
    var wordList = List.of("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot");
//    var beginWord = "qa";
//    var endWord = "sq";
//    var wordList = List.of("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
    System.out.println(ladderLength(beginWord, endWord, wordList));
  }
}
