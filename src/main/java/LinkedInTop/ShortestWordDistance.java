package LinkedInTop;

public class ShortestWordDistance {

  public static int shortestDistance(String[] wordsDict, String word1, String word2) {
    var result = wordsDict.length;
    var pos1 = -1;
    var pos2 = -1;
    var i = 0;
    while (i < wordsDict.length) {
      if (wordsDict[i].equals(word1)) {
        pos1 = i;
      }
      if (wordsDict[i].equals(word2)) {
        pos2 = i;
      }
      if (pos1 != -1 && pos2 != -1) {
        result = Math.min(result, Math.abs(pos2 - pos1));
      }
      i++;
    }
    return result;
  }

  public static void main(String[] args) {
    var wordsDict = new String[] {"practice", "makes", "perfect", "coding", "makes"};
    var word1 = "makes";
    var word2 = "coding";
    //    var wordsDict = new String[]{"a", "b", "c", "d", "d"};
    //    var word1 = "a";
    //    var word2 = "d";
    System.out.println(shortestDistance(wordsDict, word1, word2));
  }
}
