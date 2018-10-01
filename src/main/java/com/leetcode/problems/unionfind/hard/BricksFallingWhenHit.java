package com.leetcode.problems.unionfind.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/bricks-falling-when-hit/description/
 */
@SuppressWarnings("ConstantConditions")
public class BricksFallingWhenHit {

	class Solution {

		private final int[] dr = new int[]{-1, 0, 0, 1};
		private final int[] dc = new int[]{0, -1, 1, 0};

		private Map<Integer, List<Integer>> map = new HashMap<>();

		public int[] hitBricks(int[][] grid, int[][] hits) {
			int[] ans = new int[hits.length];
			if (grid.length == 0) {
				return ans;
			}
			int rows = grid.length;
			int cols = grid[0].length;
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					if (grid[r][c] == 1) {
						int curr = key(r, c, cols);
						List<Integer> parents = new ArrayList<>();
						for (int i = 0; i < 4; i++) {
							int tr = r + dr[i], tc = c + dc[i];
							if (tr >= 0 && tr < rows && tc >= 0 && tc < cols && grid[tr][tc] == 1) {
								int neighbour = key(tr, tc, cols);
								parents.add(neighbour);
							}
						}
						map.put(curr, parents);
					}
				}
			}
			for (int i = 0; i < ans.length; i++) {
				int count = -1;
				int[] hit = hits[i];
				grid[hit[0]][hit[1]] = 0;
				Queue<int[]> queue = new ArrayDeque<>();
				queue.offer(hit);

				while (!queue.isEmpty()) {
					int[] curr = queue.poll();
					boolean[][] visited = new boolean[rows][cols];
					if ((curr == hit || grid[curr[0]][curr[1]] == 1) && find(grid, visited, curr[0], curr[1], cols, -1) >= cols) {
						count++;
						grid[curr[0]][curr[1]] = 0;
						for (int j = 0; j < 4; j++) {
							int tr = curr[0] + dr[j], tc = curr[1] + dc[j];
							if (tr >= 0 && tr < rows && tc >= 0 && tc < cols && grid[tr][tc] == 1) {
								queue.offer(new int[]{tr, tc});
							}
						}
					}
				}
				ans[i] = count;
			}
			return ans;
		}

		private int find(int[][] grid, boolean[][] visited, int r, int c, int cols, int from) {
			if (visited[r][c] || grid[r][c] == 0) {
				return Integer.MAX_VALUE;
			}
			visited[r][c] = true;
			Integer key = key(r, c, cols);
			int min = key;
			Iterator<Integer> iterator = map.get(key).iterator();
			while (iterator.hasNext()) {
				Integer p = iterator.next();
				int[] point = point(p, cols);
				if (grid[point[0]][point[1]] == 0) {
					iterator.remove();
					continue;
				}
				min = Math.min(min, find(grid, visited, point[0], point[1], cols, key));
				if (min < cols) {
					return min;
				}
			}
			return min;
		}

		private int[] point(int key, int cols) {
			return new int[]{key / cols, key % cols};
		}

		private int key(int r, int c, int cols) {
			return r * cols + c;
		}

	}

	class Solution_ {

		private final int[] dr = new int[]{1, -1, 0, 0};
		private final int[] dc = new int[]{0, 0, 1, -1};

		public int[] hitBricks(int[][] grid, int[][] hits) {
			int[] ans = new int[hits.length];
			if (grid.length == 0) {
				return ans;
			}
			int rows = grid.length;
			int cols = grid[0].length;
			for (int i = 0; i < ans.length; i++) {
				int[] hit = hits[i];
				grid[hit[0]][hit[1]] = 0;
				boolean[][] visited = new boolean[rows][cols];
				for (int c = 0; c < cols; c++) {
					dfs(grid, visited, 0, c);
				}
				int count = 0;
				for (int r = 0; r < rows; r++) {
					for (int c = 0; c < cols; c++) {
						if (grid[r][c] == 1 && !visited[r][c]) {
							grid[r][c] = 0;
							count++;
						}
					}
				}
				ans[i] = count;
			}
			return ans;
		}

		private void dfs(int[][] grid, boolean[][] visited, int r, int c) {
			if (visited[r][c] || grid[r][c] == 0) {
				return;
			}
			visited[r][c] = true;
			int rows = grid.length;
			int cols = grid[0].length;
			for (int i = 0; i < 4; i++) {
				int tr = r + dr[i], tc = c + dc[i];
				if (tr >= 0 && tr < rows && tc >= 0 && tc < cols) {
					dfs(grid, visited, tr, tc);
				}
			}
		}
	}

}
