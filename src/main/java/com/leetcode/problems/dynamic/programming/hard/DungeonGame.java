package com.leetcode.problems.dynamic.programming.hard;

public class DungeonGame {

    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon.length == 0) {
                return 0;
            }

            int rows = dungeon.length;
            int cols = dungeon[0].length;
            int[][] dp = new int[dungeon.length][dungeon[0].length];
            dp[rows - 1][cols - 1] = Math.max(1 - dungeon[rows - 1][cols - 1], 1);

            for (int i = cols - 2; i >= 0; i--) {
                dp[rows - 1][i] = Math.max(dp[rows - 1][i + 1] - dungeon[rows - 1][i], 1);
            }

            for (int i = rows - 2; i >= 0; i--) {
                dp[i][cols - 1] = Math.max(dp[i + 1][cols - 1] - dungeon[i][cols - 1], 1);
            }

            for (int r = rows - 2; r >= 0; r--) {
                for (int c = cols - 2; c >= 0; c--) {
                    int up = Math.max(dp[r + 1][c] - dungeon[r][c], 1);
                    int right = Math.max(dp[r][c + 1] - dungeon[r][c], 1);
                    dp[r][c] = Math.min(up, right);
                }
            }

            return dp[0][0];
        }
    }

}
