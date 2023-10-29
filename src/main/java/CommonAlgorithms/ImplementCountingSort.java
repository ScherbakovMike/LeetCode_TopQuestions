package CommonAlgorithms;

import java.util.Arrays;

public class ImplementCountingSort {

  private static void sort(int[] input) {
    var min = Integer.MAX_VALUE;
    var max = Integer.MIN_VALUE;
    for (int j : input) {
      if (j < min) {
        min = j;
      }
      if (j > max) {
        max = j;
      }
    }
    var arrayLength = max - min + 1;
    var counts = new int[arrayLength];
    for (var i = 0; i < input.length; i++) {
      counts[input[i] - min]++;
    }
    var i = 0;
    for (var j = 0; j < counts.length; j++) {
      while (counts[j] > 0) {
        input[i] = min + j;
        i++;
        counts[j]--;
      }
    }
  }

  public static void main(String[] args) {
    int[] array = {-6, -6, -6, 3, 2, 1};
    System.out.println(Arrays.toString(array));
    sort(array);
    System.out.println(Arrays.toString(array));
  }
}
