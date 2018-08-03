package com.leetcode.problems.array.medium;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinimumPathSum {
    public class Solution {

        public int minPathSum(int[][] grid) {
            int rowLength = grid[0].length;
            int[][] scores = new int[grid.length][rowLength];
            scores[0][0] = grid[0][0];
            for (int i = 0; i < rowLength - 1; i++) {
                scores[0][i + 1] = scores[0][i] + grid[0][i + 1];
            }
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < rowLength; x++) {
                    if (y != 0 && x + 1 != rowLength) {
                        scores[y][x + 1] = Math.min(scores[y][x] + grid[y][x + 1], scores[y][x + 1]);
                    }
                    if (y + 1 != grid.length) {
                        scores[y + 1][x] = scores[y][x] + grid[y + 1][x];
                    }
                }
            }
            return scores[grid.length - 1][rowLength - 1];
        }
    }

}
