package CommonAlgorithms;

public class ImplementBinarySearch {

  public static void main(String[] args) {
    var sortedArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 19};
    var searchItem = 4;
    System.out.println(binarySearch(sortedArray, searchItem));
  }

  private static Integer binarySearch(int[] sortedArray, int searchItem) {
    var low = 0;
    var high = sortedArray.length;
    var mid = (high + low) / 2;
    while (low <= high && sortedArray[mid] != searchItem) {
      if (searchItem > sortedArray[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
      mid = (high + low) / 2;
    }
    if (sortedArray[mid] == searchItem) {
      return mid;
    } else {
      return null;
    }
  }
}
