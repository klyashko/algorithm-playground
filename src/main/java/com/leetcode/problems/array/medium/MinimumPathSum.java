package com.leetcode.problems.array.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 */
public class MinimumPathSum {
    public class Solution {

        public int minPathSum(int[][] grid) {
            int rowLength = grid[0].length;
            int[] row = new int[rowLength];
            Arrays.fill(row, -1);

            int[][] scores = new int[grid.length][];

            for (int i = 0; i < scores.length; i++) {
                scores[i] = Arrays.copyOf(row, row.length);
            }

            scores[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
            for (int y = grid.length - 1; y >= 0; y--) {
                for (int x = grid[0].length - 1; x >= 0; x--) {
                    if (y != 0) {
                        int nextY = y - 1;
                        int nextX = x;
                        int nextScore = scores[y][x] + grid[nextY][nextX];
                        int currentScore = scores[nextY][nextX];
                        if (currentScore == -1) {
                            scores[nextY][nextX] = nextScore;
                        } else {
                            scores[nextY][nextX] = Math.min(nextScore, currentScore);
                        }
                    }
                    if (x != 0) {
                        int nextY = y;
                        int nextX = x - 1;
                        int nextScore = scores[y][x] + grid[nextY][nextX];
                        int currentScore = scores[nextY][nextX];
                        if (currentScore == -1) {
                            scores[nextY][nextX] = nextScore;
                        } else {
                            scores[nextY][nextX] = Math.min(nextScore, currentScore);
                        }
                    }
                }
            }
            return scores[0][0];
        }
    }

}
