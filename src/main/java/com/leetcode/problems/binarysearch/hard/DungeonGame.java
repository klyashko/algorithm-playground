package com.leetcode.problems.binarysearch.hard;

/**
 * https://leetcode.com/problems/dungeon-game/
 */
public class DungeonGame {

	class Solution {

		private final int[] dr = new int[]{1, 0};
		private final int[] dc = new int[]{0, 1};

		public int calculateMinimumHP(int[][] dungeon) {
			int l = 0, r = Integer.MAX_VALUE;
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
			return Math.max(l, 1);
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

}
