package com.algorithm.playground.leetcode.problems.array.medium;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinimumPathSum {
    public class Solution {

        public int minPathSum(int[][] grid) {
            int i = 0, j = 0;
            for (int c = 0; c < grid.length + grid[0].length - 1; c++) {
                fillDiagonal(i, j, grid);
                if (i < grid.length - 1) {
                    i++;
                } else if (j < grid[0].length - 1) {
                    j++;
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }

        private void fillDiagonal(int i, int j, int[][] grid) {
            while (i >= 0 && j < grid[0].length) {
                if (i != 0 && j != 0) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                } else if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (i != 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }
                i--;
                j++;
            }
        }
    }

}
