package Array.LargestLocalValuesInAMatrix;

import java.util.*;

public class LargestLocalValuesInAMatrix_2373 {

    public int[][] largestLocal(int[][] grid) {
        var newSize = grid.length - 2;
        var result = new int[newSize][newSize];
        var resultRow = 0;

        for (var i = 1; i < (grid.length - 1); i++) {
            var resultCol = 0;
            for (var j = 1; j < (grid.length - 1); j++) {
                var max = Integer.MIN_VALUE;
                for (var k = i - 1; k < (i + 2); k++) {
                    for (var l = j - 1; l < (j + 2); l++) {
                        if (grid[k][l] >= max) {
                            max = grid[k][l];
                        }
                    }
                }
                result[resultRow][resultCol] = max;
                resultCol++;
            }
            resultRow++;
        }
        return result;
    }

    public int[][] largestLocalOptimized(int[][] grid) {
        var newSize = grid.length - 2;
        var result = new int[newSize][newSize];

        // precalculate max in rows
        var maxInRows = new int[grid.length][newSize];
        for (var row = 0; row < grid.length; row++) {
            for (var col = 1; col < (grid.length - 1); col++) {
                var max = Integer.MIN_VALUE;
                for (var i = col - 1; i <= col + 1; i++) {
                    if (grid[row][i] > max) {
                        max = grid[row][i];
                    }
                }
                maxInRows[row][col - 1] = max;
            }
        }

        for (var row = 1; row < (grid.length - 1); row++) {
            for (var col = 1; col < (grid.length - 1); col++) {
                var max = Math.max(
                        Math.max(
                                maxInRows[row - 1][col - 1],
                                maxInRows[row][col - 1]
                        ), maxInRows[row + 1][col - 1]
                );
                result[row - 1][col - 1] = max;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var grid = new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        System.out.println(Arrays.deepEquals(
                new LargestLocalValuesInAMatrix_2373().largestLocalOptimized(grid),
                new int[][]{{9, 9}, {8, 6}}
        ));

        grid = new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println(Arrays.deepEquals(
                new LargestLocalValuesInAMatrix_2373().largestLocalOptimized(grid),
                new int[][]{{2, 2, 2}, {2, 2, 2}, {2, 2, 2}}
        ));
    }
}
