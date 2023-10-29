package CommonAlgorithms;

import java.util.Arrays;

public class ImplementQuickSort {

  public static void quickSort(int[] array, int left, int right) {
    if (right <= left) {
      return;
    }
    int pivot = array[right];
    int i = left;
    for (int j = left; j < right; j++) {
      if (array[j] < pivot) {
        int buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
        i++;
      }
    }
    int temp = array[right];
    array[right] = array[i];
    array[i] = temp;

    quickSort(array, left, i - 1);
    quickSort(array, i + 1, right);
  }

  public static void main(String[] args) {
    int[] array = {6, 5, 4, 3, 2, 1};
    System.out.println(Arrays.toString(array));
    quickSort(array, 0, array.length - 1);
    System.out.println(Arrays.toString(array));
  }
}
