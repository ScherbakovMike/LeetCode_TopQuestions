package Others;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {

  public boolean uniqueOccurrences(int[] arr) {
    var occurrences =
        Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return occurrences.values().stream().distinct().toList().size() == occurrences.size();
  }

  public static void main(String[] args) {
    var test = new int[] {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
    System.out.println(new UniqueNumberOfOccurrences().uniqueOccurrences(test));
  }
}
