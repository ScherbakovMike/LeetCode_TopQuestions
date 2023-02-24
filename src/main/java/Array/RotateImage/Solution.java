package Array.RotateImage;

import java.util.Arrays;

class Solution {

  public void rotate(int[][] matrix) {
    //transpose
    for (int row = 0; row < matrix.length; row++) {
      for (int col = row; col < matrix[row].length; col++) {
        var buf = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = buf;
      }
    }
    //change the column order
    for (int col = 0; col < matrix.length / 2; col++) {
      for (int row = 0; row < matrix.length; row++) {
        var buf = matrix[row][col];
        matrix[row][col] = matrix[row][matrix.length - col - 1];
        matrix[row][matrix.length - col - 1] = buf;
      }
    }
  }

  public static void main(String[] args) {
    var test1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    new Solution().rotate(test1);
    System.out.println(Arrays.deepToString(test1));
  }
}

/*
номер столбца = 2-старый номер строки
номер строки = старый номер столбца

0,0 -> 0,2
0,1 -> 1,2
0,2 -> 2,2


2,0 -> 0,0
2,1 -> 1,0
2,2 -> 2,0
*/