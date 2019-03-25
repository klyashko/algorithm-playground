package com.algorithm.playground.leetcode.problems.lc800.lc860.lc864;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/description/
 */
public class ShortestPathToGetAllKeys {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int shortestPathAllKeys(String[] grid) {
			int[] start = null;
			int keys = 0;
			int rows = grid.length;
			int cols = grid[0].length();

			for (int i = 0; i < rows; i++) {
				String s = grid[i];
				for (int j = 0; j < cols; j++) {
					char ch = s.charAt(j);
					if (ch == '@') {
						start = new int[]{i, j, 0};
					} else if (Character.isLowerCase(ch)) {
						keys++;
					}
				}
			}

			int steps = -1;
			Queue<int[]> queue = new ArrayDeque<>();
			boolean[][][] seen = new boolean[rows][cols][1 << keys];
			queue.add(start);
			//noinspection ConstantConditions
			seen[start[0]][start[1]][start[2]] = true;

			while (!queue.isEmpty()) {
				int size = queue.size();
				steps++;
				while (size > 0) {
					int[] curr = queue.poll();
					size--;
					//noinspection ConstantConditions
					char ch = grid[curr[0]].charAt(curr[1]);
					// If it's a wall or we don't have keys yet skip it
					if (ch == '#' || (Character.isUpperCase(ch) && 1 << (ch - 'A') != (curr[2] & 1 << (ch - 'A')))) {
						continue;
					} else if (Character.isLowerCase(ch)) {
						curr[2] = curr[2] | 1 << (ch - 'a');
						if (curr[2] == (1 << keys) - 1) {
							return steps;
						}
					}
					for (int i = 0; i < 4; i++) {
						int tr = curr[0] + dr[i];
						int tc = curr[1] + dc[i];
						if (tr >= 0 && tr < rows && tc >= 0 && tc < cols) {
							int[] next = new int[]{tr, tc, curr[2]};
							if (!seen[tr][tc][next[2]]) {
								seen[tr][tc][next[2]] = true;
								queue.offer(next);
							}
						}
					}

				}
			}

			return -1;
		}
	}

}
