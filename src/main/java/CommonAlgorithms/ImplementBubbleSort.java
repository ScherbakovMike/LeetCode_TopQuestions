package CommonAlgorithms;

import java.util.Arrays;

public class ImplementBubbleSort {

  // An optimized version of Bubble Sort
  private static void bubbleSort(int[] arr, int n) {
    int buffer;
    boolean swapped;
    for (var i = 0; i < n - 1; i++) {
      swapped = false;
      for (var j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          buffer = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = buffer;
          swapped = true;
        }
      }
      if (!swapped) break;
    }
  }

  public static void main(String[] args) {
    var array = new int[] {64, 34, 25, 12, 22, 11, 90};
    var n = array.length;
    bubbleSort(array, n);
    System.out.println("Sorted array: ");
    System.out.println(Arrays.toString(array));
  }
}
