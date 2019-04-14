package com.algorithm.playground.leetcode.problems.lc800.lc800.lc803;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * https://leetcode.com/problems/bricks-falling-when-hit/description/
 */
public class BricksFallingWhenHit {

	class Solution {
		public int[] hitBricks(int[][] grid, int[][] hits) {
			int R = grid.length, C = grid[0].length;
			int[] dr = {1, 0, -1, 0};
			int[] dc = {0, 1, 0, -1};

			int[][] A = new int[R][C];
			for (int r = 0; r < R; ++r) {
				A[r] = grid[r].clone();
			}
			for (int[] hit : hits) {
				A[hit[0]][hit[1]] = 0;
			}

			DSU dsu = new DSU(R * C + 1);

			for (int r = 0; r < R; ++r) {
				for (int c = 0; c < C; ++c) {
					if (A[r][c] == 1) {
						int i = r * C + c;
						if (r == 0) {
							dsu.union(i, R * C);
						}
						if (r > 0 && A[r - 1][c] == 1) {
							dsu.union(i, (r - 1) * C + c);
						}
						if (c > 0 && A[r][c - 1] == 1) {
							dsu.union(i, r * C + c - 1);
						}
					}
				}
			}
			int t = hits.length;
			int[] ans = new int[t--];

			while (t >= 0) {
				int r = hits[t][0];
				int c = hits[t][1];
				int preRoof = dsu.top();
				if (grid[r][c] == 0) {
					t--;
				} else {
					int i = r * C + c;
					for (int k = 0; k < 4; ++k) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if (0 <= nr && nr < R && 0 <= nc && nc < C && A[nr][nc] == 1) {
							dsu.union(i, nr * C + nc);
						}
					}
					if (r == 0) {
						dsu.union(i, R * C);
					}
					A[r][c] = 1;
					ans[t--] = Math.max(0, dsu.top() - preRoof - 1);
				}
			}

			return ans;
		}
	}

	class DSU {
		int[] parent;
		int[] rank;
		int[] sz;

		public DSU(int N) {
			parent = new int[N];
			for (int i = 0; i < N; ++i)
				parent[i] = i;
			rank = new int[N];
			sz = new int[N];
			Arrays.fill(sz, 1);
		}

		public int find(int x) {
			if (parent[x] != x) parent[x] = find(parent[x]);
			return parent[x];
		}

		public void union(int x, int y) {
			//noinspection SuspiciousNameCombination
			int xr = find(x), yr = find(y);
			if (xr == yr) return;

			if (rank[xr] < rank[yr]) {
				int tmp = yr;
				yr = xr;
				xr = tmp;
			}
			if (rank[xr] == rank[yr])
				rank[xr]++;

			parent[yr] = xr;
			sz[xr] += sz[yr];
		}

		public int size(int x) {
			return sz[find(x)];
		}

		public int top() {
			return size(sz.length - 1) - 1;
		}
	}

	class Solution__ {

		private final int[] dr = new int[]{-1, 0, 0, 1};
		private final int[] dc = new int[]{0, -1, 1, 0};

		public int[] hitBricks(int[][] grid, int[][] hits) {
			int[] ans = new int[hits.length];
			if (grid.length == 0) {
				return ans;
			}
			int rows = grid.length;
			int cols = grid[0].length;

			for (int i = 0; i < ans.length; i++) {
				int count = -1;
				int[] hit = hits[i];
				grid[hit[0]][hit[1]] = 0;
				Queue<int[]> queue = new ArrayDeque<>();
				queue.offer(hit);

				boolean[][] cache = new boolean[rows][cols];

				while (!queue.isEmpty()) {
					int[] curr = queue.poll();
					boolean[][] visited = new boolean[rows][cols];
					if ((curr == hit || grid[curr[0]][curr[1]] == 1) && !find(grid, visited, curr[0], curr[1], cache)) {
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

		private boolean find(int[][] grid, boolean[][] visited, int r, int c, boolean[][] cache) {
			if (visited[r][c] || grid[r][c] == 0) {
				return false;
			} else if (r == 0 || cache[r][c]) {
				return true;
			}
			visited[r][c] = true;
			int rows = grid.length;
			int cols = grid[0].length;
			for (int j = 0; j < 4; j++) {
				int tr = r + dr[j], tc = c + dc[j];
				if (tr >= 0 && tr < rows && tc >= 0 && tc < cols && grid[tr][tc] == 1) {
					if (find(grid, visited, tr, tc, cache)) {
						cache[r][c] = true;
						return true;
					}
				}
			}
			return false;
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
