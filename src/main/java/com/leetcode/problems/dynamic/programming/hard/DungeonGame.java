package com.leetcode.problems.dynamic.programming.hard;

import java.util.Arrays;

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
				dp[rows - 1][i] = Math.max(dp[rows - 1][i] - dungeon[rows - 1][i], 1);
			}

			for (int i = rows - 2; i >= 0; i--) {
				dp[i][cols - 1] = Math.max(dp[i][cols - 1] - dungeon[i][cols - 1], 1);
			}
			//			for (int i = 1; i < dp.length; i++) {
			//				dp[i] = Math.max(dungeon[0][i] + dp[i - 1], 1);
			//			}

			for (int r = rows - 1; r >= 0; r--) {
				for (int c = cols - 1; c >= 0; c--) {
					int up = Math.max(dp[r + 1][c] - dungeon[r][c - 1], 1);
					int right = Math.max(dp[r][c + 1] - dungeon[r][c], 1);
					dp[r][c] = Math.min(up, right);
				}
			}

			System.out.println(Arrays.toString(dp));

			//			int m = dungeon.length;
			//			int n = dungeon[0].length;
			//
			//			int[][] health = new int[m][n];
			//
			//			health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
			//
			//			for (int i = m - 2; i >= 0; i--) {
			//				health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
			//			}
			//
			//			for (int j = n - 2; j >= 0; j--) {
			//				health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
			//			}
			//
			//			for (int i = m - 2; i >= 0; i--) {
			//				for (int j = n - 2; j >= 0; j--) {
			//					int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
			//					int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
			//					health[i][j] = Math.min(right, down);
			//				}
			//			}
			//
			//			for(int[] t: health){
			//				System.out.println(Arrays.toString(t));
			//			}

			return 7;
		}
	}

}
