package com.leetcode.problems.dynamic.programming.hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/cherry-pickup/description/
 */
public class CherryPickup {

    class Solution {
        public int cherryPickup(int[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            int rows = grid.length;
            int cols = grid[0].length;
            int[][] profit = new int[rows][cols];

            profit[0][0] = grid[0][0];

            for (int i = 1; i < cols; i++) {
                if (grid[0][i] == -1) {
                    break;
                }
                profit[0][i] = profit[0][i - 1] + grid[0][i];
                profit[0][i - 1] = 0;
            }

            for (int i = 1; i < rows; i++) {
                if (grid[i][0] == -1) {
                    break;
                }
                profit[i][0] = profit[i - 1][0] + grid[i][0];
                profit[i - 1][0] = 0;
            }

            for (int r = 1; r < rows; r++) {
                for (int c = 1; c < cols; c++) {
                    if (grid[r][c] == -1) {
                        continue;
                    }
                    if (grid[r - 1][c] == -1 && grid[r][c - 1] == -1) {
                        grid[r][c] = -1;
                        continue;
                    }
                    if (profit[r - 1][c] + grid[r][c] > profit[r][c - 1] + grid[r][c]) {
                        profit[r][c] = profit[r - 1][c] + grid[r][c];
                        profit[r - 1][c] = 0;
                    } else {
                        profit[r][c] = profit[r][c - 1] + grid[r][c];
                        profit[r][c - 1] = 0;
                    }
                }
            }

            if (profit[rows - 1][cols - 1] == 0) {
                return 0;
            }

            int[][] profit2 = new int[rows][cols];
//            profit2[rows - 1][cols - 1] = profit[rows - 1][cols - 1];
            profit2[rows - 1][cols - 1] = 0;

//            for (int i = cols - 2; i >= 0; i--) {
//                if (grid[rows - 1][i] == -1) {
//                    continue;
//                }
//                profit2[rows - 1][i] = profit2[rows - 1][i + 1] + profit[rows - 1][i];
//            }
//
//            for (int i = rows - 2; i >= 0; i--) {
//                if (grid[i][cols - 1] == -1) {
//                    continue;
//                }
//                profit2[i][cols - 1] = profit2[i + 1][cols - 1] + profit[i][cols - 1];
//            }

            for (int r = rows - 2; r >= 0; r--) {
                for (int c = cols - 2; c >= 0; c--) {
                    if (grid[r][c] == -1) {
                        continue;
                    }
                    if (profit2[r + 1][c] + profit[r][c] < profit2[r][c + 1] + profit[r][c]) {
                        profit2[r][c] = profit2[r][c + 1] + profit[r][c];
                        profit2[r][c + 1] = 0;
                    } else {
                        profit2[r][c] = profit2[r + 1][c] + profit[r][c];
                        profit2[r + 1][c] = 0;
                    }
                }

                for (int[] t : profit2) {
                    System.out.println(Arrays.toString(t));
                }
                System.out.println();

            }
//
            for (int[] t : profit) {
                System.out.println(Arrays.toString(t));
            }
            System.out.println();
            for (int[] t : profit2) {
                System.out.println(Arrays.toString(t));
            }

            return profit2[0][0];
        }
    }

}
