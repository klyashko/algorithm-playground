package com.algorithm.playground.leetcode.problems.lc100.lc174;

/**
 * https://leetcode.com/problems/dungeon-game/description/
 */
public class DungeonGame {

	class Solution {

		private final int[] dr = new int[]{1, 0};
		private final int[] dc = new int[]{0, 1};

		public int calculateMinimumHP(int[][] dungeon) {
			int l = 1, r = Integer.MAX_VALUE;
			int n = dungeon.length;
			int m = dungeon[0].length;
			while (l < r) {
				int mid = l + (r - l) / 2;
				if (!dfs(0, 0, mid + dungeon[0][0], dungeon, new int[n][m])) {
					l = mid + 1;
				} else {
					r = mid;
				}
			}
			return l;
		}

		private boolean dfs(int r, int c, int health, int[][] grid, int[][] cache) {
			if (health <= 0) {
				return false;
			}
			int n = grid.length;
			int m = grid[0].length;
			if (r == n - 1 && c == m - 1) {
				return true;
			} else if (cache[r][c] >= health) {
				return false;
			}
			cache[r][c] = health;
			for (int i = 0; i < 2; i++) {
				int tr = r + dr[i], tc = c + dc[i];
				if (tr < n && tc < m) {
					if (dfs(tr, tc, health + grid[tr][tc], grid, cache)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	class SolutionDP {
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
