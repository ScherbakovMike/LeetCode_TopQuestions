package LinkedInTop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {

  private final Map<String, List<Integer>> words = new HashMap<>();

  public ShortestWordDistanceII(String[] wordsDict) {
    for (var i = 0; i < wordsDict.length; i++) {
      final int finalI = i;
      words.compute(wordsDict[i], (key, value) -> {
        var list = value;
        if (list == null) {
          list = new ArrayList<>();
        }
        list.add(finalI);
        return list;
      });
    }
  }

  public int shortest(String word1, String word2) {
    return shortestDistance(word1, word2);
  }

  public int shortestDistance(String word1, String word2) {
    // a = [0, 3, 5, 6]
    // b = [1, 4, 7, 9]
    var indices1 = words.get(word1);
    var indices2 = words.get(word2);
    var i1 = 0;
    var i2 = 0;
    var result = Integer.MAX_VALUE;
    while (i1 < indices1.size() && i2 < indices2.size()) {
      var index1 = indices1.get(i1);
      var index2 = indices2.get(i2);
      result = Math.min(result, Math.abs(index1 - index2));
      if (index1 < index2) {
        i1++;
      } else {
        i2++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ShortestWordDistanceII wordDistance = new ShortestWordDistanceII(
      new String[]{"practice", "makes", "perfect", "coding", "makes"});
    System.out.println(wordDistance.shortest("coding", "practice")); // return 3
    System.out.println(wordDistance.shortest("coding", "practice")); // return 3
    System.out.println(wordDistance.shortest("makes", "coding"));    // return 1
  }
}
