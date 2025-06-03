package Array.ValidSudoku;

import java.util.stream.IntStream;

public class Solution {

  public static void main(String[] args) {
    var test1 =
        new char[][] {
          {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
    var test2 =
        new char[][] {
          {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
    System.out.println(new Solution().isValidSudoku(test1));
    System.out.println(new Solution().isValidSudoku(test2));
  }

  public boolean isValidSudoku(char[][] board) {
    var reversedBoard = new char[board.length][board[0].length];
    for (int rowNumber = 0; rowNumber < board.length; rowNumber++) {
      var row = board[rowNumber];
      for (int columnNumber = 0; columnNumber < row.length; columnNumber++) {
        reversedBoard[columnNumber][rowNumber] = board[rowNumber][columnNumber];
      }
      if (isRowBad(row)) {
        return false;
      }
    }
    for (char[] row : reversedBoard) {
      if (isRowBad(row)) {
        return false;
      }
    }

    for (int rowNumber = 0; rowNumber < board.length; rowNumber += 3) {
      var row = board[rowNumber];
      for (int columnNumber = 0; columnNumber < row.length; columnNumber += 3) {
        var items =
            IntStream.of(
                    board[rowNumber][columnNumber],
                    board[rowNumber][columnNumber + 1],
                    board[rowNumber][columnNumber + 2],
                    board[rowNumber + 1][columnNumber],
                    board[rowNumber + 1][columnNumber + 1],
                    board[rowNumber + 1][columnNumber + 2],
                    board[rowNumber + 2][columnNumber],
                    board[rowNumber + 2][columnNumber + 1],
                    board[rowNumber + 2][columnNumber + 2])
                .mapToObj(value -> (char) value)
                .reduce("", (s1, s2) -> s1 + s2, (s1, s2) -> s1 + s2);
        if (isRowBad(items.toCharArray())) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isRowBad(char[] row) {
    if (!String.valueOf(row)
        .chars()
        .allMatch(value -> value == '.' || (value >= '1' && value <= '9'))) {
      return true;
    }
    return String.valueOf(row).chars().filter(value -> value >= '1' && value <= '9').count()
        != String.valueOf(row)
            .chars()
            .filter(value -> value >= '1' && value <= '9')
            .distinct()
            .count();
  }
}
