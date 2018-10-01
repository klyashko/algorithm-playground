package com.leetcode.problems.unionfind.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberOfIslands {

	class Solution {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int numIslands(char[][] grid) {
			if (grid.length == 0) {
				return 0;
			}
			int rows = grid.length;
			int cols = grid[0].length;
			int[] parents = new int[rows * cols];
			Arrays.fill(parents, -1);
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (grid[r][c] == '1') {
						int curr = key(r, c, cols);
						int p1 = find(parents, curr);
						for (int i = 0; i < 4; i++) {
							int tr = r + dr[i], tc = c + dc[i];
							if (tr >= 0 && tr < rows && tc >= 0 && tc < cols && grid[tr][tc] == '1') {
								int neighbor = key(tr, tc, cols);
								int p2 = find(parents, neighbor);
								if (p1 != p2) {
									parents[p2] = p1;
								}
							}
						}
					}
				}
			}
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < parents.length; i++) {
				if (parents[i] != -1) {
					set.add(find(parents, i));
				}
			}
			return set.size();
		}

		private int key(int row, int col, int cols) {
			return row * cols + col;
		}

		private int find(int[] parents, int key) {
			if (parents[key] == -1) {
				parents[key] = key;
				return key;
			} else if (parents[key] == key) {
				return key;
			}
			int p = find(parents, parents[key]);
			parents[key] = p;
			return p;
		}

	}

}
