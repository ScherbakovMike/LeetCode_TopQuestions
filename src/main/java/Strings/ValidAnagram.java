package Strings;

import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidAnagram {
  public static void main(String[] args) {
    System.out.println(new ValidAnagram().isAnagram("\"anagram\"","\"nagaram\""));
  }

  public boolean isAnagram(String s, String t) {
    var mapS = s.chars().mapToObj(value -> (char) value)
      .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
    var mapT = t.chars().mapToObj(value -> (char) value)
      .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
    return mapS.equals(mapT);
  }
}
